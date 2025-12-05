import styled from "styled-components";

export const HeaderBar = styled.header`
  width: 100%;
  padding: 16px 32px;
  display: flex;
  justify-content: space-between;  /* 좌 우 배치 */
  align-items: center;
  background: #fff;
  box-shadow: 0 2px 6px rgba(0,0,0,0.1);
  position: sticky;
  top: 0;
  z-index: 10;
`;

export const Logo = styled.h1`
  font-size: 24px;
  font-weight: 700;
  cursor: pointer;
  color: #333;
  margin: 0;
`;

export const HeaderRight = styled.div`
  display: flex;
  flex-direction: column; /* 위: 텍스트, 아래: 메뉴 */
  align-items: flex-end;  /* 오른쪽 정렬 */
`;

export const WelcomeText = styled.span`
  font-size: 14px;
  color: #555;
  margin-bottom: 6px;
`;

export const MenuList = styled.ul`
  display: flex;
  gap: 16px;
  padding: 0;
  margin: 0;
  list-style: none;
`;

export const MenuItem = styled.li`
  cursor: pointer;
  font-size: 15px;
  color: #333;
  font-weight: 500;
  transition: color 0.2s ease;

  &:hover {
    color: #007bff;
  }
`;