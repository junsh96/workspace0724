import React from "react";

import { useProduct } from "../context/ProductContext";
import { HomeWrapper } from "../styled/Home.styled";
import HomeBanner from "../compenents/home/HomeBanner";
import HomeActions from "../compenents/home/HomeAction";
import HomeRecentProducts from "../compenents/home/HomeRecentProducts";

const Home = () => {
  const { value } = useProduct();

  const recentProducts = [...value].reverse().slice(0, 6);

  return (
    <HomeWrapper>
      <HomeBanner />
      <HomeActions />
      <HomeRecentProducts products={recentProducts} />
    </HomeWrapper>
  );
};

export default Home;