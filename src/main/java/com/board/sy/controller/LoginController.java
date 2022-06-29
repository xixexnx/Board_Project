package com.board.sy.controller;

import java.net.URLEncoder;

import com.board.sy.dao.MemberDao;
import com.board.sy.domain.MemberDto;
import com.board.sy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String mid, String pwd, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception{

        if (!loginCheck(mid, pwd)) {
            String msg = URLEncoder.encode("아이디 또는 비밀번호가 일치하지 않습니다.","utf-8");
            return "redirect:/login/login?msg=" + msg;
        }

        HttpSession session = request.getSession();
        session.setAttribute("id", mid);

        if(rememberId){
            Cookie cookie = new Cookie("id", mid);
            response.addCookie(cookie);
        }else{
            Cookie cookie = new Cookie("id", mid);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        toURL = toURL == null || toURL.equals("") ? "/" : toURL;
        return "redirect:/" + toURL;
    }


    private boolean loginCheck(String mid, String pwd){
        MemberDto member = null;
        try{
            member = memberService.getUser(mid);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return member!=null && member.getPwd().equals(pwd);
    }
}
