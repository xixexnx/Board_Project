package com.board.sy.controller;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import com.board.sy.domain.SearchCondition;
import com.board.sy.service.BoardService;
import com.board.sy.service.PostService;
import org.apache.ibatis.annotations.Delete;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {
@Autowired
PostService postService;
@Autowired
BoardService boardService;

    @GetMapping("/board/post/{pno}")
    public String read(@PathVariable("pno") String pno, SearchCondition sc, RedirectAttributes rattr, Model m){
        try {
            PostDto postDto = postService.getPost(pno);
            BoardDto boardDto = postService.getBoard(pno);
            m.addAttribute(postDto);
            m.addAttribute(boardDto);
            m.addAttribute("mode", "read");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "READ_ERR");
            return "redirect:/post"+sc.getQueryString();
        }
        return "post";
    }

    @ResponseBody
    @PatchMapping("/board/post/{pno}")
    public ResponseEntity<String> modify(@PathVariable String pno, @RequestBody PostDto dto){
        try{
            dto.setPno(pno);
            if(postService.modify(dto)!=1)
                throw new Exception ("Modify Failed");

            return new ResponseEntity<>("MOD_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("MOD_ERR", HttpStatus.OK);
        }
    }

    @GetMapping("/board/post")
    public String getPosts(String bno, Model m) throws Exception {
        List<PostDto> boardList = boardService.getPosts(bno);
        m.addAttribute("boardList", boardList);
        return "board";
    }

    @GetMapping("/board/post/create")
    public String getPost(Model m){
        try{
            List<BoardDto> boardList = boardService.getBoards();
            m.addAttribute("BoardList", boardList);
            m.addAttribute("mode","new");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "post";
    }

    @PostMapping("/board/post")
    public String write(PostDto dto, String bno, HttpSession session, RedirectAttributes rattr, Model m){
        String writer = (String)session.getAttribute("id");
        try{
            dto.setBno(bno);
            dto.setWriter(writer);
            dto.setPno(postService.makePno());
            if(postService.upPost(dto)!=1)
                throw new Exception("Write Failed");

            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/board";
        }catch(Exception e){
            e.printStackTrace();
            m.addAttribute(dto);
            m.addAttribute("mode","new");
            m.addAttribute("msg", "WRT_ERR");
            return "board";
        }
    }

    @ResponseBody
    @DeleteMapping("/board/post/{pno}")
    public ResponseEntity<String> delete(@PathVariable String pno){
        try{
            if(postService.delete(pno)!= 1)
                throw new Exception ("DEL_FAILED");

            return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
        }
    }
}
