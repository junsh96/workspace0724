import React, { useEffect, useState } from "react";
import { Section, SectionTitle, ProfileBox, ProfileImage, ProfileInfo } from "../../styled/MyPage.styled";
import { useUsers } from "../../context/UserContext";
import { myInfo } from "./api/MyPage.api";

const MyInfo = () => {
  const { users } = useUsers();
  const [myInfos, setMyInfo] = useState(null);
    useEffect(() => {
      const fetchMyInfo = async () => {
        if(!users?.user_id) return;
          try {
              const res = await myInfo(users.user_id);
              console.log("!@#!@#",res.data);
              setMyInfo(res.data);
          } catch(e) {
              console.log(e);
          }
      };
      fetchMyInfo();
    },[users.user_id]);
if(!myInfos) return null;

  return (
    <Section>
      <SectionTitle>내 정보</SectionTitle>
      <ProfileBox>
        <ProfileImage />
        <ProfileInfo>
          <span><strong>{myInfos.user_name}</strong> 님</span>
          <span>ID: {myInfos.user_id}</span>
          <span>가입일: {new Date(myInfos.join_date).toLocaleString("ko-KR")}</span>
          <span>총 판매 금액: {myInfos.amount.toLocaleString()} 원</span>
        </ProfileInfo>
      </ProfileBox>
    </Section>
  );
};

export default MyInfo;