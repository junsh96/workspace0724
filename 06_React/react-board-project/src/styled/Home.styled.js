import styled from "styled-components";

export const HomeWrapper = styled.div`
  width: 100%;
  max-width: 1000px;
  margin: 30px auto;
  padding: 20px;
`;

export const Banner = styled.div`
  background: linear-gradient(135deg, #6cc6ff, #4b9fff);
  color: white;
  padding: 30px 20px;
  border-radius: 15px;
  margin-bottom: 30px;
  text-align: center;
`;

export const BannerTitle = styled.h2`
  font-size: 28px;
  margin-bottom: 10px;
`;

export const ActionButtons = styled.div`
  display: flex;
  gap: 10px;
  justify-content: center;
  margin-bottom: 40px;

  button {
    padding: 12px 16px;
    border-radius: 8px;
    border: none;
    cursor: pointer;
    background: #0077ff;
    color: white;
    font-size: 15px;
    transition: 0.2s;

    &:hover {
      background: #005cd1;
    }
  }
`;

export const ProductGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
`;

export const ProductCard = styled.div`
  background: white;
  border-radius: 12px;
  box-shadow: 0 3px 12px rgba(0, 0, 0, 0.08);
  padding: 15px;
  cursor: pointer;
  transition: 0.2s;

  &:hover {
    transform: translateY(-3px);
    box-shadow: 0 6px 15px rgba(0,0,0,0.15);
  }

  img {
    width: 100%;
    height: 160px;
    object-fit: cover;
    border-radius: 10px;
    margin-bottom: 12px;
  }

  .title {
    font-size: 16px;
    font-weight: 700;
    margin-bottom: 6px;
  }

  .date {
    font-size: 13px;
    color: #777;
  }
`;