package com.board.sy.service;

import com.board.sy.domain.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getCommentList(String pno)throws Exception;
    CommentDto getComment(String cno) throws Exception;
    int writeComment(CommentDto dto)throws Exception;
    int updateComment(CommentDto dto)throws Exception;
    int deleteComments(String pno)throws Exception;
    int deleteComment(String cno)throws Exception;

    }
