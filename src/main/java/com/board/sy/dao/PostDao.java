package com.board.sy.dao;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import com.board.sy.domain.SearchCondition;

import java.util.List;

public interface PostDao {
    PostDto getPost(String pno) throws Exception;

    BoardDto getBoard(String pno) throws Exception;
    int writePost(PostDto dto) throws Exception;
    String makePno() throws Exception;
    int modifyPost(PostDto dto) throws Exception;
    int deletePost(String pno) throws Exception;
    int searchResultCnt(SearchCondition sc)throws Exception;
    List<PostDto> searchSelectPage()throws Exception;
}
