import React from "react";
import { useNavigate } from "react-router-dom";
import { useUsers } from "../context/UserContext";
import { useProduct } from "../context/ProductContext";

import {HomeWrapper,Banner,BannerTitle,ActionButtons,ProductGrid,ProductCard} from "./Home.styled";

const Home = () => {
  const navigate = useNavigate();
  const { users } = useUsers();
  const { value } = useProduct();

  // 최근 등록된 상품 6개
  const recentProducts = [...value].reverse().slice(0, 6);

  return (
    <HomeWrapper>

      {/* 메인 배너 */}
      <Banner>
        <BannerTitle>Resale Market</BannerTitle>
        {users?.id ? (
          <p><strong>{users.name}</strong>님, 환영합니다!</p>
        ) : (
          <p>로그인하여 중고 거래를 시작해보세요!</p>
        )}
      </Banner>

      {/* 액션 버튼 */}
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

      {/* 최근 등록된 상품 */}
      <h3 style={{ marginBottom: "15px" }}>최근 등록된 상품</h3>
      <ProductGrid>
        {recentProducts.length === 0 ? (
          <p>등록된 상품이 아직 없습니다.</p>
        ) : (
          recentProducts.map(item => (
            <ProductCard
              key={item.id}
              onClick={() => navigate(`/productDetail/${item.id}`)}
            >
              {item.image && <img src={item.image} alt="상품" />}
              <div className="title">{item.title}</div>
              <div className="date">{item.createDate}</div>
            </ProductCard>
          ))
        )}
      </ProductGrid>

    </HomeWrapper>
  );
};

export default Home;