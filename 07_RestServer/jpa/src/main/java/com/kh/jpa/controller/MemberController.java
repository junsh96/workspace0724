package com.kh.jpa.controller;

import com.kh.jpa.dto.MemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody MemberDto.Create createMemberDto) {

        return null;
    }

}
