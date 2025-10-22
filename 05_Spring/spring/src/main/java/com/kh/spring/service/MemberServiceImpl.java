package com.kh.spring.service;

import com.kh.spring.model.mapper.MemberMapper;
import com.kh.spring.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //@Compenent보다 더 구체화하여 service객체에 등록
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;
    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }



    @Override
    public Member getMemberById(String memberId) {
        return memberMapper.getMemberById(memberId);
    }

    @Override
    public int getMemberCountById(String memberId) {
        return memberMapper.getMemberCountById(memberId);
    }

    @Override
    public int addMember(Member member) {
        /*
            mybatis를 스프링없이 단독으로 사용할때에는 수동으로 커밋 또는 롤백을 해줘여한다.
            스프링과 함께 사용할때에는 트랜잭션 처리를 스프링이 자동으로 관리한다.
         */

        return memberMapper.addMember(member);
    }

    @Override
    public Member updateMember(Member member) {

        int result = memberMapper.updateMember(member);
        if (result > 0) {
            return memberMapper.getMemberById(member.getMemberId());
        } else {
            return null;
        }

    }

    @Override
    public Member updatePwd(String memberPwd, String updatePwd, String memberId) {
        int result = memberMapper.updatePwd(memberPwd, updatePwd, memberId);

        if (result > 0) {
            return memberMapper.getMemberById(memberId);
        } else {
            return null;
        }
    }

    @Override
    public int deleteMember(String memberId) {
        return memberMapper.deleteMember(memberId);

    }
}
