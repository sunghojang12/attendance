package com.jg.attendance.controller;

import com.jg.attendance.domain.member.MemberRequest;
import com.jg.attendance.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUpForm(){
        return "member/signup";
    }

    @PostMapping(("signUp"))
    public String signUp(MemberRequest memberRequest){
        log.info("memberRequest{}", memberRequest);
        memberService.signUp(memberRequest);
        return "redirect:/member/signIn";
    }

    @GetMapping("/signIn")
    public String signIn(){

        return "member/signIn";
    }
}
