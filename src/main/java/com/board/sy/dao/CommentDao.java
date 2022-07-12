package com.board.sy.dao;

import com.board.sy.domain.CommentDto;

import java.util.List;

public interface CommentDao {
    int count(String pno) throws Exception;
    int deleteAll(String pno) throws Exception;
    int delete(String cno) throws Exception;
    int insert(CommentDto dto) throws Exception;
    List<CommentDto> selectAll(String pno) throws Exception;
    CommentDto select(String cno) throws Exception;
    int update(CommentDto dto) throws Exception;
}
