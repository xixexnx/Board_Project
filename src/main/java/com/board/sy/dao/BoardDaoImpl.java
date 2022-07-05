package com.board.sy.dao;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import com.board.sy.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao{
    @Autowired private SqlSession session;
    private static String namespace = "com.board.sy.dao.BoardMapper.";

    @Override
    public List<BoardDto> getBoards() throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public BoardDto getBoard(String bno) throws Exception{
        return session.selectOne(namespace+"select", bno);
    }
    @Override
    public List<PostDto> getPosts(String bno) throws Exception{
        return session.selectList(namespace+"selectPost", bno);
    }
    @Override
    public int insertBoard(BoardDto dto) throws Exception{
        return session.insert(namespace+"insertBoard", dto);
    }
    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace + "deleteAll");
    }
    @Override
    public int count() throws Exception{
        return session.selectOne(namespace + "count");
    }
    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace+"searchResultCnt", sc);
    }

    @Override
    public List<PostDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"searchSelectPage", sc);
    }
}
