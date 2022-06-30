package com.board.sy.controller;

import com.board.sy.domain.MemberDto;
import com.board.sy.service.MemberService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonValue;
import jdk.jshell.spi.ExecutionControlProvider;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    MemberService memberService;

    @GetMapping("/register")
    public String registerForm(){
        return "registerForm";
    }

    @PostMapping("/register")
    public String register(MemberDto memberDto, Model m){
        try {
            if(memberService.joinUser(memberDto) != 1) throw new Exception("Join Fail");
            return "loginForm";
        } catch (Exception e) {
           e.printStackTrace();
           return "registerForm";
        }
    }

    @GetMapping(value = "/idCheck")
    public @ResponseBody String midCheck(String mid){
        try {
            if(memberService.getUser(mid) == null)
                return "true";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

}