package com.board.sy.dao;

import com.board.sy.domain.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoImpl implements CommentDao{
    @Autowired
    SqlSession session;
    String namespace = "com.board.sy.dao.CommentMapper.";

    public int count(String pno) throws Exception{
        return session.selectOne(namespace + "count", pno);
    }

    public int deleteAll(String pno) throws Exception{
        return session.delete(namespace + "deleteAll", pno);
    }

    public int delete(String cno) throws Exception{
        return session.delete(namespace + "delete" ,cno);
    }

    public int insert(CommentDto dto) throws Exception{
        return session.insert(namespace + "insert", dto);
    }

    public List<CommentDto> selectAll(String pno) throws Exception{
        return session.selectList(namespace + "selectAll", pno);
    }

    public CommentDto select(String cno) throws Exception{
        return session.selectOne(namespace + "select", cno);
    }

    public int update(CommentDto dto) throws Exception{
        return session.update(namespace + "update", dto);
    }
}
