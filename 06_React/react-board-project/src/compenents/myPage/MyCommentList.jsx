import React from "react";
import { useNavigate } from "react-router-dom";
import { Section, SectionTitle, ListItem } from "../../styled/MyPage.styled";
import { useUsers } from "../../context/UserContext";

const MyCommentList = () => {
  const { users } = useUsers();
  const navigate = useNavigate();

  const allComments = JSON.parse(localStorage.getItem("comments") || "[]");
  const myComments = allComments
    .filter(c => c.userId === users.id)
    .reverse()
    .slice(0, 5);

  return (
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
  );
};

export default MyCommentList;