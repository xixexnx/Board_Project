package com.board.sy.service;

import com.board.sy.dao.CommentDao;
import com.board.sy.domain.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;

    @Override
    public List<CommentDto> getCommentList(String pno)throws Exception{
        return commentDao.selectAll(pno);
    }
    @Override
    public CommentDto getComment(String cno) throws Exception{
        return commentDao.select(cno);
    }
    @Override
    public int writeComment(CommentDto dto)throws Exception{
        return commentDao.insert(dto);
    }
    @Override
    public int updateComment(CommentDto dto)throws Exception{
        return commentDao.update(dto);
    }
    @Override
    public int deleteComments(String pno)throws Exception{
        return commentDao.deleteAll(pno);
    }
    @Override
    public int deleteComment(String cno)throws Exception{
        return commentDao.delete(cno);
    }
}
