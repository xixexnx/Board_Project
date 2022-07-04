package com.board.sy.dao;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;

public interface PostDao {
    PostDto getPost(String pno) throws Exception;

    BoardDto getBoardName(String pno) throws Exception;
    int writePost(PostDto dto) throws Exception;
    String makePno() throws Exception;
    int modifyPost(PostDto dto) throws Exception;
    int deletePost(String pno) throws Exception;
}
