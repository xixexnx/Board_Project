package com.board.sy.service;

import com.board.sy.dao.MemberDao;
import com.board.sy.domain.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberDao memberDao;

    @Override
    public MemberDto getUser(String mid) throws Exception {
        return memberDao.selectMember(mid);
    }

    @Override
    public int joinUser(MemberDto memberDto) throws Exception{
        return memberDao.insertMember(memberDto);
    }

}
