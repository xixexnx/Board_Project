package com.board.sy.dao;

import com.board.sy.domain.CommentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.stream.events.Comment;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentDaoImplTest {
    @Autowired
    CommentDao commentDao;

    @Test
    public void count() throws Exception{
        assertTrue(commentDao.count("P0001")==0);
    }

    @Test
    public void deleteAll() throws Exception{
        CommentDto dto = new CommentDto("P0001", "C0001", "deleteAllTest", "aaa");
        commentDao.insert(dto);
        assertTrue(commentDao.count("P0001")==2);
        commentDao.deleteAll("P0001");
        assertTrue(commentDao.count("P0001")==0);
    }

    @Test
    public void delete() throws Exception{
        commentDao.deleteAll("P0001");
        assertTrue(commentDao.count("P0001")==0);
        CommentDto dto = new CommentDto("P0001", "C0001", "deleteTest", "aaa");
        assertTrue(commentDao.insert(dto)==1);
        assertTrue(commentDao.count("P0001")==1);
        commentDao.delete("C0004");
        assertTrue(commentDao.count("P0001")==0);
    }

    @Test
    public void insert() throws Exception{
        commentDao.deleteAll("P0001");
        assertTrue(commentDao.count("P0001")==0);
        CommentDto dto = new CommentDto("P0001", "C0001", "insertTest", "aaa");
        assertTrue(commentDao.insert(dto)==1);
        assertTrue(commentDao.count("P0001")==1);
        commentDao.deleteAll("P0001");
        assertTrue(commentDao.count("P0001")==0);
    }

    @Test
    public void selectAll() throws Exception{
        commentDao.deleteAll("P0001");
        assertTrue(commentDao.count("P0001")==0);
        CommentDto dto = new CommentDto("P0001", "C0001", "selectAllTest", "aaa");
        assertTrue(commentDao.insert(dto)==1);
        List<CommentDto> list = commentDao.selectAll("P0001");
        assertTrue(list.size()==1);
        assertEquals(list.get(0).getCno(),"C0001");
    }

    @Test
    public void select() throws Exception{
        commentDao.deleteAll("P0001");
        assertTrue(commentDao.count("P0001")==0);
        CommentDto dto = new CommentDto("P0001", "C0001", "selectTest", "aaa");
        assertTrue(commentDao.insert(dto)==1);
        CommentDto comment = commentDao.select("C0001");
        assertEquals(comment.getCno(),"C0001");

        CommentDto comment1 = commentDao.select("C0002");
        assertTrue(comment1==null);
    }

    @Test
    public void update() throws Exception{
        commentDao.deleteAll("P0001");
        assertTrue(commentDao.count("P0001")==0);
        CommentDto dto = new CommentDto("P0001", "C0001", "selectTest", "aaa");
        assertTrue(commentDao.insert(dto)==1);

        CommentDto comment = commentDao.select("C0001");
        comment.setComment("updateTest");
        assertTrue(commentDao.update(comment)==1);

        comment = commentDao.select("C0001");
        assertEquals(comment.getComment(),"updateTest");
    }
}