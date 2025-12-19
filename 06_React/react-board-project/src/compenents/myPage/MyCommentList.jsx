import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Section, SectionTitle, ListItem } from "../../styled/MyPage.styled";
import { useUsers } from "../../context/UserContext";
import { myComment } from "./api/MyPage.api";

const MyCommentList = () => {
  const { users } = useUsers();
  const [myComments, setComments] = useState(null);
  const navigate = useNavigate();
      useEffect(() => {
        const fetchMyComment = async () => {
          if(!users?.user_id) return;
            try {
                const res = await myComment(users.user_id);
                console.log("!@#!@#",res.data);
                setComments(res.data);
            } catch(e) {
                console.log(e);
            }
        };
        fetchMyComment();
      },[users.user_id]);

  const allComments = JSON.parse(localStorage.getItem("comments") || "[]");
  // const myComments = allComments
  //   .filter(c => c.userId === users.id)
  //   .reverse()
  //   .slice(0, 5);
if(!myComments) return null;
  return (
    <Section>
      <SectionTitle>내 댓글</SectionTitle>
      {myComments.length === 0 ? (
        <div>작성한 댓글이 없습니다.</div>
      ) : (
        myComments.map(c => (
          <ListItem key={c.id}>
            <span>{c.comment}</span>
            <button onClick={() => navigate(`/productDetail/${c.product_id}`)}>
              글 보기
            </button>
          </ListItem>
        ))
      )}
    </Section>
  );
};

export default MyCommentList;