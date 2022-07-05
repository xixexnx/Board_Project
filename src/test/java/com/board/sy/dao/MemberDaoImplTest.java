package com.board.sy.dao;

import com.board.sy.domain.MemberDto;
import com.board.sy.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Member;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDaoImplTest {
    @Autowired MemberDao memberDao;

    @Test
    public void count() throws Exception{
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);

        MemberDto dto = new MemberDto("hong", "1", "홍길동", "hong@hong.com", "1998", "01", "13");
        memberDao.insertMember(dto);
        assertTrue(memberDao.count()==1);
    }
    @Test
    public void deleteAll() throws Exception{
        memberDao.deleteAll();
        assertTrue(memberDao.count() == 0);
    }
    @Test
    public void insert() throws Exception{
        memberDao.deleteAll();
        assertTrue(memberDao.count() == 0);

        MemberDto dto = new MemberDto("hong", "1", "홍길동", "hong@hong.com", "1998", "01", "13");
        assertTrue(memberDao.insertMember(dto)==1);
        assertTrue(memberDao.count() == 1);
        assertEquals(memberDao.selectMember("hong").getPwd(),"1");
    }

    @Test
    public void update() throws Exception{
//        우선순위가 아님. 회원정보 수정
        memberDao.deleteAll();
        assertTrue(memberDao.count()==0);

        MemberDto dto = new MemberDto("sin", "1", "신짱구", "sin@sin.com", "2005", "10", "13");
        assertTrue(memberDao.insertMember(dto)==1);
        assertTrue(memberDao.count()==1);
    }
}