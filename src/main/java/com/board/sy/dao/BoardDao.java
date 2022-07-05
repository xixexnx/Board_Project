package com.board.sy.dao;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import com.board.sy.domain.SearchCondition;

import java.util.List;

public interface BoardDao {
    List<BoardDto> getBoards() throws Exception;
    BoardDto getBoard(String bno) throws Exception;
    List<PostDto> getPosts(String bno) throws Exception;
    int insertBoard(BoardDto dto) throws Exception;

    int deleteAll() throws Exception;
    int count() throws Exception;
    int searchResultCnt(SearchCondition sc) throws Exception;
    List<PostDto> searchSelectPage(SearchCondition sc) throws Exception;
}
