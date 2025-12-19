import React from "react";
import { MyPageWrapper, Section } from "../styled/MyPage.styled";
import MyInfo from "../compenents/myPage/myInfo";
import MyCommentList from "../compenents/myPage/myCommentList";
import MyFavorite from "../compenents/myPage/MyFavorite";
import MyProductList from "../compenents/myPage/MyProductList";

const MyPage = () => {
  return (
    <MyPageWrapper>
      <MyInfo />
      <MyProductList />
      <MyFavorite />
      <MyCommentList />
    </MyPageWrapper>
  );
};

export default MyPage;