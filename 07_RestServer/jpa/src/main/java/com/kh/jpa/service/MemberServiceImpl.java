package com.kh.jpa.service;

import com.kh.jpa.dto.MemberDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    @Override
    public String createMember(MemberDto.Create createMemberDto) {
        return "";
    }
}
