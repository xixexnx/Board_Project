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
}
