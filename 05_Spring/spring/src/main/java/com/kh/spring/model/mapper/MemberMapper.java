package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
@Mapper mybatis에서 mapper인터페이스를 정의할 때 사용하는 어노테이션
        스프링 Bean에 등록하야 의존성 주입
 */
@Mapper
public interface MemberMapper {

    Member getMemberById(@Param("memberId") String memberId);
    int getMemberCountById(String memberId);

    int addMember(Member member);

    int updateMember(Member member);

    int updatePwd(String memberPwd, String updatePwd, String memberId);

    int deleteMember(String memberId);
}
