package com.board.sy.controller;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import com.board.sy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board")
    public String getBoardList(String bno, Model m){
        List<BoardDto> boardList = null;
        List<PostDto> postList = null;
        try{
            boardList = boardService.getBoards();
            m.addAttribute("boardList", boardList);
            postList = boardService.getPosts("");
            m.addAttribute("postList",postList);
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
