package com.board.sy.service;

import com.board.sy.dao.PostDao;
import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostDao postDao;
    @Override
    public PostDto getPost(String pno) throws Exception{
        return postDao.getPost(pno);
    }
    @Override
    public BoardDto getBoard(String pno) throws Exception{
        return postDao.getBoard(pno);
    }

    @Override
    public int upPost(PostDto dto) throws Exception{
        return postDao.writePost(dto);
    }

    @Override
    public String makePno() throws Exception{
        return postDao.makePno();
    }

    @Override
    public int modify(PostDto dto) throws Exception{
        return postDao.modifyPost(dto);
    }

    @Override
    public int delete(String pno) throws Exception{
        return postDao.deletePost(pno);
    }
}
