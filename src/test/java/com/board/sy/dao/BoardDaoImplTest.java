package com.board.sy.dao;

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
public class BoardDaoImplTest {
    @Autowired
    BoardDao boardDao;

    @Test
    public void deleteAll() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);
    }

    @Test
    public void count() throws Exception{
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto dto = new BoardDto("B0001", "공지 사항");
        assertTrue(boardDao.insertBoard(dto)==1);
        assertTrue(boardDao.count()==1);
    }

    @Test
    public void insertBoard() throws Exception{
        boardDao.deleteAll();
        BoardDto dto = new BoardDto("B0001", "공지 사항");
        assertTrue(boardDao.insertBoard(dto)==1);
        assertTrue(boardDao.count()==1);

        dto = new BoardDto("B0002", "자유 게시판");
        assertTrue(boardDao.insertBoard(dto)==1);
        assertTrue(boardDao.count()==2);
    }

    @Test
    public void getBoards() throws Exception{
        boardDao.deleteAll();
        BoardDto dto = new BoardDto("B0001", "공지 사항");
        assertTrue(boardDao.insertBoard(dto)==1);
        assertTrue(boardDao.count()==1);

        dto = new BoardDto("B0002", "자유게시판");
        assertTrue(boardDao.insertBoard(dto)==1);
        assertTrue(boardDao.count()==2);

        List<BoardDto> list =  boardDao.getBoards();
        assertTrue(list.size()==2);

        assertTrue(list.get(0).getBno().equals("B0001"));
        assertTrue(list.get(0).getTitle().equals("공지 사항"));
        assertTrue(list.get(1).getBno().equals("B0002"));
        assertTrue(list.get(1).getTitle().equals("자유게시판"));
    }

    @Test
    public void getBoard() throws Exception{
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto dto = new BoardDto("B0001", "공지 사항");
        assertTrue(boardDao.insertBoard(dto)==1);
        assertTrue(boardDao.count()==1);

        BoardDto dto1 = boardDao.getBoard("B0001");
        assertTrue(dto1.getTitle().equals("공지 사항"));
    }

    @Test
    public void getPosts() throws Exception{
    }
}