import React from "react";

import { useNavigate } from "react-router-dom";
import { Section, SectionTitle, ListItem, SellSpan } from "../../styled/MyPage.styled";
import { useUsers } from "../../context/UserContext";
import { useProduct } from "../../context/ProductContext";

const MyProductList = () => {
  const { users } = useUsers();
  const { value } = useProduct();
  const navigate = useNavigate();

  const myProducts = value
    .filter(p => p.userId === users.id)
    .reverse()
    .slice(0, 5);

  return (
    <Section>
      <SectionTitle>내가 올린 게시글 (최근 5개)</SectionTitle>
      {myProducts.length === 0 ? (
        <div>등록한 게시글이 없습니다.</div>
      ) : (
        myProducts.map(item => (
          <ListItem key={item.id}>
            <span className="title" onClick={() => navigate(`/productDetail/${item.id}`)}>
              {item.title}
              {item.status === "complete" && <SellSpan>판매완료</SellSpan>}
            </span>
            <span className="date">{item.createDate}</span>
          </ListItem>
        ))
      )}
    </Section>
  );
};

export default MyProductList;