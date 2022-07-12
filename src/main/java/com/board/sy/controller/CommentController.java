package com.board.sy.controller;

import com.board.sy.domain.CommentDto;
import com.board.sy.service.CommentService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/board/post/comment/{pno}")
    public ResponseEntity<List<CommentDto>> showComment(@PathVariable String pno){
        List<CommentDto> list = null;
        try{
            list = commentService.getCommentList(pno);
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/board/post/comment")
    public ResponseEntity<String> writeComment(@RequestBody CommentDto dto, HttpSession session){
        try{
            dto.setCommenter((String) session.getAttribute("id"));
            commentService.writeComment(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/board/post/comment/{cno}")
    public ResponseEntity<String> modifyComment(@PathVariable String cno, @RequestBody CommentDto dto){
        try{
            dto.setCno(cno);
            commentService.updateComment(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/board/post/comment/{cno}")
    public ResponseEntity<String> deleteComment(@PathVariable String cno){
        try{
            commentService.deleteComment(cno);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
