import React from "react";
import { useUsers } from "../context/UserContext";
import { useProduct } from "../context/ProductContext";

import {MyPageWrapper,Section,SectionTitle,ProfileBox,ProfileImage,ProfileInfo,ListItem, SellSpan} from "./MyPage.styled";

import { useNavigate } from "react-router-dom";

const MyPage = () => {
  const navigate = useNavigate();
  const { users } = useUsers();
  const { value } = useProduct();

  if (!users?.id) return <div>로그인이 필요합니다.</div>;

  // 전체 댓글 로드
  const allComments = JSON.parse(localStorage.getItem("comments") || "[]");

  // 내가 올린 게시글
  const myProducts = value.filter(p => p.userId === users.id).reverse().slice(0, 5);

  // 내가 작성한 댓글
  const myComments = allComments.filter(c => c.userId === users.id).reverse().slice(0, 5);

  // 총 판매 금액
  const totalSell = users.amount || 0;

  return (
    <MyPageWrapper>

      {/* 내 정보 */}
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

      {/* 내가 올린 게시글 */}
      <Section>
        <SectionTitle>내가 올린 게시글 (최근 5개)</SectionTitle>
        {myProducts.length === 0 ? (
          <div>등록한 게시글이 없습니다.</div>
        ) : (
          myProducts.map(item => (
            <ListItem key={item.id}>
              <span className="title" onClick={() => navigate(`/productDetail/${item.id}`)}>
                {item.title}
                {item.status === "complete" && ( 
                    <SellSpan>
                        판매완료
                    </SellSpan>
                )}
              </span>
              <span className="date">{item.createDate}</span>
            </ListItem>
          ))
        )}
      </Section>

      {/* 내가 작성한 댓글 */}
      <Section>
        <SectionTitle>내 댓글</SectionTitle>
        {myComments.length === 0 ? (
          <div>작성한 댓글이 없습니다.</div>
        ) : (
          myComments.map(c => (
            <ListItem key={c.id}>
              <span>{c.comment}</span>
              <button onClick={() => navigate(`/productDetail/${c.productId}`)}>
                글 보기
              </button>
            </ListItem>
          ))
        )}
      </Section>

    </MyPageWrapper>
  );
};

export default MyPage;