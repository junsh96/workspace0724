import React from "react";
import { Banner, BannerTitle } from "../../styled/Home.styled";
import { useUsers } from "../../context/UserContext";

const HomeBanner = () => {
  const { users } = useUsers();

  return (
    <Banner>
      <BannerTitle>Resale Market</BannerTitle>
      {users?.id ? (
        <p><strong>{users.name}</strong>님, 환영합니다!</p>
      ) : (
        <p>로그인하여 중고 거래를 시작해보세요!</p>
      )}
    </Banner>
  );
};

export default HomeBanner;