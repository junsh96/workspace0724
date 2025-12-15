import styled from "styled-components";

export const MyPageWrapper = styled.div`
  width: 900px;
  margin: 40px auto;
  padding: 20px;
`;

export const Section = styled.div`
  background: #fff;
  padding: 20px;
  border-radius: 12px;
  margin-bottom: 25px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.06);
`;

export const SectionTitle = styled.h3`
  margin-bottom: 15px;
  font-size: 20px;
  font-weight: 700;
`;

export const ProfileBox = styled.div`
  display: flex;
  align-items: center;
  gap: 20px;
`;

export const ProfileImage = styled.div`
  width: 70px;
  height: 70px;
  background: #e5e5e5;
  border-radius: 50%;
`;

export const ProfileInfo = styled.div`
  display: flex;
  flex-direction: column;
  gap: 6px;

  /* 추가 */
  margin-left: auto;
  margin-right: auto;
  text-align: center;

  span {
    font-size: 15px;
  }
`;

export const ListItem = styled.div`
  padding: 12px 0;
  border-bottom: 1px solid #eee;

  &:last-child {
    border: none;
  }

  display: flex;
  justify-content: space-between;
  align-items: center;

  .title {
    font-weight: 600;
    cursor: pointer;
  }

  .date {
    color: #666;
    font-size: 13px;
  }
`;

export const SellSpan = styled.span`
    display: inline-block;
    padding: 8px 14px;
    margin-left: 10px;
    font-size: 14px;
    font-weight: bold;
    color: #c0392b;
    border: 2px solid #c0392b;
    border-radius: 4px;
    transform: rotate(-8deg);
    opacity: 0.85;
    background: rgba(255, 230, 230, 0.4);
`