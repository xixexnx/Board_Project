package com.board.sy.dao;

import com.board.sy.domain.MemberDto;

public interface MemberDao {
    MemberDto selectMember(String mid) throws Exception;
    int insertMember(MemberDto memberDto) throws Exception;
    int deleteAll() throws Exception;
}
