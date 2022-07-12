package com.board.sy.controller;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PageHandler;
import com.board.sy.domain.PostDto;
import com.board.sy.domain.SearchCondition;
import com.board.sy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board")
    public String getBoardList(String bno, Model m, SearchCondition sc){
        try{
            if(bno==null) bno="";
            sc.setBno(bno);
            int totalCnt = boardService.getSearchResultCnt(sc);

            m.addAttribute("totalCnt", totalCnt);

            PageHandler ph = new PageHandler(totalCnt, sc);
            m.addAttribute("ph", ph);

            List<PostDto> postList = boardService.getSearchResultPage(sc);
            m.addAttribute("postList", postList);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());

            BoardDto boardDto = boardService.getBoard(bno);
            m.addAttribute("board", boardDto);

            List<BoardDto> boardList = boardService.getBoards();
            m.addAttribute("boardList", boardList);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "/board";
    }

    @GetMapping("/board/list")
    public @ResponseBody Map<String, Object> getPostList(String bno){
        Map<String, Object> map = new HashMap<>();
        try {
            List<PostDto> list = boardService.getPosts(bno);
            map.put("list",list);
            if(bno != "" || bno == null){
                BoardDto board = boardService.getBoard(bno);
                map.put("board", board.getTitle());
            }else{
                map.put("board", "전체 게시판");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
