package com.board.sy.controller;

import com.board.sy.dao.MemberDao;
import com.board.sy.domain.MemberDto;
import com.board.sy.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class LoginControllerTest {
    @Autowired
    MemberService memberService;

    @Test
    public void loginCheck() {
        // mid = "aaaa", pwd="1", name="홍길동", email="aa@naver.com", birth="2022-01-01", reg_date="2022-06-28"
        String mid = "aaaa";
        MemberDto member = null;

        try{
            member = memberService.getUser(mid);

        }catch(Exception e){
            e.printStackTrace();
        }
        assertTrue(member.getMid().equals("aaaa"));
        assertTrue(member.getPwd().equals("1"));
        assertTrue(member.getMname().equals("홍길동"));
        assertTrue(member.getEmail().equals("aa@naver.com"));
//        assertTrue(member.getBirth().equals("2022-01-01"));
        assertTrue(member.getReg_date().equals("2022-06-28"));
    }
}