package com.board.sy.service;

import com.board.sy.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceImplTest {
    @Autowired BoardService boardService;

    @Test
    public void getBoards() throws Exception{
        List<BoardDto> list = boardService.getBoards();
        assertTrue(list.size()==1);
    }

    @Test
    public void getBoard() throws Exception{
        BoardDto dto = boardService.getBoard("B0001");
        assertTrue(dto.getTitle().equals("공지 사항"));
    }

    @Test
    public void getPosts() {
    }
}