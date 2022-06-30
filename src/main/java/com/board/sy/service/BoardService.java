package com.board.sy.service;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> getBoards() throws Exception;
    BoardDto getBoard(String bno) throws Exception;
    List<PostDto> getPosts(String bno) throws Exception;
}
