import React from "react";
import { Section, SectionTitle, ProfileBox, ProfileImage, ProfileInfo } from "../../styled/MyPage.styled";
import { useUsers } from "../../context/UserContext";

const MyInfo = () => {
  const { users } = useUsers();

  return (
    <Section>
      <SectionTitle>내 정보</SectionTitle>
      <ProfileBox>
        <ProfileImage />
        <ProfileInfo>
          <span><strong>{users.name}</strong> 님</span>
          <span>ID: {users.id}</span>
          <span>가입일: {new Date(users.joinDate).toLocaleString("ko-KR")}</span>
          <span>총 판매 금액: {users.amount.toLocaleString()} 원</span>
        </ProfileInfo>
      </ProfileBox>
    </Section>
  );
};

export default MyInfo;