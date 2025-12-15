import React from "react";
import { MyPageWrapper, Section } from "../styled/MyPage.styled";
import MyInfo from "../compenents/myPage/myInfo";
import MyProductList from "../compenents/myPage/myProductList";
import MyCommentList from "../compenents/myPage/myCommentList";
import MyFavorite from "../compenents/myPage/MyFavorite";

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