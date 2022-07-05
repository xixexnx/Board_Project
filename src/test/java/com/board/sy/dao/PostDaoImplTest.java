package com.board.sy.dao;

import com.board.sy.domain.PostDto;
import com.board.sy.domain.SearchCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PostDaoImplTest {
    @Autowired PostDao postDao;

    @Test
    public void deleteAll() throws Exception{
        postDao.deleteAll();
        assertTrue(postDao.count()==0);
    }

    @Test
    public void writePost() throws Exception{
        PostDto dto = new PostDto("P0001", "B0001", "[필독]", "공지사항", "hong");
        postDao.deleteAll();

        assertTrue(postDao.writePost(dto)==1);
        assertTrue(postDao.count()==1);
    }

    @Test
    public void getPost() throws Exception{
        PostDto dto = postDao.getPost("P0001");
        assertTrue(dto.getTitle().equals("[필독]"));
    }

    @Test
    public void makePno() throws Exception{
        assertTrue(postDao.makePno().equals("P0002"));
    }

    @Test
    public void modifyPost() throws Exception{
        PostDto dto = postDao.getPost("P0001");
        dto.setTitle("필독 아님");
        assertTrue(postDao.modifyPost(dto)==1);
        assertTrue(postDao.getPost("P0001").getTitle().equals("필독 아님"));
    }

    @Test
    public void deletePost() throws Exception{
        postDao.deletePost("P0001");
        assertTrue(postDao.count()==0);
    }

    @Test
    public void increaseViewCnt() throws Exception{
        PostDto dto = postDao.getPost("P0001");
        int view_cnt = dto.getView_cnt();

        assertTrue(postDao.increaseViewCnt("P0001")==1);

        dto = postDao.getPost("P0001");
        assertTrue(dto.getView_cnt()==(view_cnt + 1));
    }
}