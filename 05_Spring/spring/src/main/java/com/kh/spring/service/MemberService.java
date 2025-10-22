package com.kh.spring.service;

import com.kh.spring.model.vo.Member;

public interface MemberService {

    Member getMemberById(String memberId);
    int getMemberCountById(String memberId);
    int addMember(Member member);
    Member updateMember(Member member);
    Member updatePwd(String memberPwd, String updatePwd, String memberId);
    int deleteMember(String memberId);
}
