package com.board.sy.service;

import com.board.sy.domain.CommentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentServiceImplTest {
    @Autowired
    CommentService commentService;

    @Test
    public void getCommentList()throws Exception {
        List<CommentDto> list = commentService.getCommentList("P0001");
        assertTrue(list.size()==1);
    }

    @Test
    public void getComment()throws Exception {
        CommentDto dto = new CommentDto("P0001", "", "hola", "hong");
        assertTrue(commentService.writeComment(dto)==1);

        List<CommentDto> list = commentService.getCommentList("P0001");
        String cno = list.get(1).getCno();

        CommentDto dto1 = commentService.getComment(cno);
        assertEquals(dto1.getComment(),"hola");
        assertEquals(dto1.getCommenter(),"hong");
    }

    @Test
    public void writeComment()throws Exception {
        CommentDto dto = new CommentDto("P0001", "", "hong", "hello");
        assertTrue(commentService.writeComment(dto)==1);
        assertTrue(commentService.getCommentList("P0001").size()==1);
        CommentDto dto1 = commentService.getComment("C0001");
        assertEquals(dto1.getCommenter(), "hello");
    }

    @Test
    public void updateComment()throws Exception {
        CommentDto dto = commentService.getComment("C0001");
        dto.setComment("hello world!!");
        assertTrue(commentService.updateComment(dto)==1);

        CommentDto dto1 = commentService.getComment("C0001");
        assertEquals(dto1.getComment(), "hello world!!");
    }

    @Test
    public void deleteComments()throws Exception {
        commentService.deleteComments("P0001");
        assertTrue(commentService.getCommentList("P0001").size()==0);
    }

    @Test
    public void deleteComment()throws Exception {
        CommentDto dto = new CommentDto("P0001", "", "hong", "hello");
        assertTrue(commentService.writeComment(dto)==1);
        assertTrue(commentService.getCommentList("P0001").size()==1);
        String cno = commentService.getCommentList("P0001").get(0).getCno();
        commentService.deleteComment(cno);
        assertTrue(commentService.getCommentList("P0001").size()==0);
    }
}