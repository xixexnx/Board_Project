package com.board.sy.service;

import com.board.sy.dao.BoardDao;
import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import com.board.sy.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardDao boardDao;

    @Override
    public List<BoardDto> getBoards() throws Exception {
        return boardDao.getBoards();
    }

    @Override
    public BoardDto getBoard(String bno) throws Exception{
        return boardDao.getBoard(bno);
    }
    @Override
    public List<PostDto> getPosts(String bno) throws Exception{
        return boardDao.getPosts(bno);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return boardDao.searchResultCnt(sc);
    }
    @Override
    public List<PostDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return boardDao.searchSelectPage(sc);
    }
}
