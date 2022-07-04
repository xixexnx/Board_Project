package com.board.sy.service;

import com.board.sy.dao.PostDao;
import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;

public interface PostService {
    PostDto getPost(String pno) throws Exception;
    BoardDto getBoardName(String pno) throws Exception;
    int upPost(PostDto dto) throws Exception;
    String makePno() throws Exception;
    int modify(PostDto dto) throws Exception;
    int delete(String pno) throws Exception;
}
