package com.board.sy.dao;

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
public class MemberDaoImplTest {
    @Autowired MemberDao memberDao;

//    @Test
//    public void count() throws Exception{
////        memberDao.deleteAllMember();
////        assertTrue(memberDao.countMember()==0);
////
////        MemberDto dto = new MemberDto("hong", "1", "홍길동", "hong@hong.com", "1998", "01", "13");
////        memberDao.insertMember(dto);
////        assertTrue(memberDao.countMember()==1);
//    }
//    @Test
//    public void deleteAll() throws Exception{
////        memberDao.deleteAllMember();
////        assertTrue(memberDao.countMember() == 0);
//    }

//    @Test
//    public void insert() throws Exception{
////        memberDao.deleteAllMember();
////        assertTrue(memberDao.countMember() == 0);
////
////        MemberDto dto = new MemberDto("hong", "1", "홍길동", "hong@hong.com", "1998", "01", "13");
////        assertTrue(memberDao.insertMember(dto)==1);
////        assertTrue(memberDao.countMember() == 1);
////        assertEquals(memberDao.selectMember("hong").getPwd(),"1");
//    }

}