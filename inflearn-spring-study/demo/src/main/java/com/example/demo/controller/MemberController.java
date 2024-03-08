package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired  // 컨트롤러와 서비스를 연결시켜줄 때. DI(의존관계 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
