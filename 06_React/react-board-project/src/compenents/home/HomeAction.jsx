import React from "react";
import { useUsers } from "../../context/UserContext";
import { useNavigate } from "react-router-dom";
import { ActionButtons } from "../../styled/Home.styled";

const HomeActions = () => {
  const navigate = useNavigate();
  const { users } = useUsers();

  return (
    <ActionButtons>
      <button onClick={() => navigate("/productList")}>전체 상품 보기</button>

      {users?.id ? (
        <>
          <button onClick={() => navigate("/productEnroll")}>판매하기</button>
          <button onClick={() => navigate(`/myPage/${users.id}`)}>마이페이지</button>
        </>
      ) : (
        <button onClick={() => navigate("/login")}>로그인</button>
      )}
    </ActionButtons>
  );
};

export default HomeActions;