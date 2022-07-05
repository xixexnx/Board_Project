package com.board.sy.service;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PostServiceImplTest {
    @Autowired PostService postService;

    @Test
    public void getPost() throws Exception{
        PostDto dto = postService.getPost("P0001");
        assert(dto.getTitle().equals("[필독]"));

    }

    @Test
    public void getBoard() throws Exception{
        BoardDto boardDto = postService.getBoard("P0001");
        assertTrue(boardDto.getBno().equals("B0001"));
        assertTrue(boardDto.getTitle().equals("공지 사항"));
    }

    @Test
    public void upPost() throws Exception{
        PostDto dto = new PostDto("P0003", "B0003", "Test", "test", "sin");
        assertTrue(postService.upPost(dto)==1);

        assertTrue(postService.getPost("P0003").getTitle().equals("Test"));
    }

    @Test
    public void makePno() throws Exception{
        assertTrue(postService.makePno().equals("P0004"));
    }

    @Test
    public void modify() throws Exception{
        PostDto dto = postService.getPost("P0003");
        dto.setTitle("No Test");

        assertTrue(postService.modify(dto)==1);
        assertTrue(postService.getPost("P0003").getTitle().equals("No Test"));
    }

    @Test
    public void delete() throws Exception{
        assertTrue(postService.delete("P0003")==1);
    }
}