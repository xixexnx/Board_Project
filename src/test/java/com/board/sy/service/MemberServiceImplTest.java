package com.board.sy.service;

import com.board.sy.dao.MemberDao;
import com.board.sy.domain.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceImplTest {
    @Autowired MemberService memberService;

    @Test
    public void getUserTest() {
        // mid = "hong", pwd="1", name="홍길동", email="hong@hong.com", birth="1998-01-13", reg_date="2022-06-30"
        String mid = "hong";
        MemberDto member = null;
        try{
            member = memberService.getUser(mid);

        }catch(Exception e){
            e.printStackTrace();
        }

        assertTrue(member.getMid().equals("hong"));
        assertTrue(member.getPwd().equals("1"));
        assertTrue(member.getMname().equals("홍길동"));
        assertTrue(member.getEmail().equals("hong@hong.com"));
        assertTrue(member.getReg_date().equals("2022-07-05"));
    }

    @Test
    public void joinUserTest(){
        MemberDto member = null;
        try {
            member = new MemberDto("hong", "1", "홍길동", "hong@hong.com", "2011", "06", "22");
            assertTrue(memberService.joinUser(member)==1);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}