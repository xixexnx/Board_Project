package com.board.sy.dao;

import com.board.sy.domain.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
    @Autowired private SqlSession session;
    private static String namespace = "com.board.sy.dao.MemberMapper.";

    @Override
    public MemberDto selectMember(String mid) throws Exception{
        return session.selectOne(namespace + "select", mid);
    }

    @Override
    public int insertMember(MemberDto memberDto) throws Exception{
        return session.insert(namespace + "insert", memberDto);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }
}

