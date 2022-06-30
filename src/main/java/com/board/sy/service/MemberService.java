package com.board.sy.service;

import com.board.sy.domain.MemberDto;
import org.springframework.stereotype.Service;

public interface MemberService {
    MemberDto getUser(String mid) throws Exception;
    int joinUser(MemberDto memberDto) throws Exception;
}
