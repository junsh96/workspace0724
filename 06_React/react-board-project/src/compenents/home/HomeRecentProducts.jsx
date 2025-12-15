import React from "react";
import { useNavigate } from "react-router-dom";
import { ProductGrid, ProductCard } from "../../styled/Home.styled";

const HomeRecentProducts = ({ products }) => {
  const navigate = useNavigate();

  return (
    <>
      <h3 style={{ marginBottom: "15px" }}>최근 등록된 상품</h3>

      <ProductGrid>
        {products.length === 0 ? (
          <p>등록된 상품이 없습니다.</p>
        ) : (
          products.map(item => (
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
    </>
  );
};

export default HomeRecentProducts;