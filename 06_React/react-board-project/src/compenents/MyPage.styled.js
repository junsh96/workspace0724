import styled from "styled-components";

export const MyPageWrapper = styled.div`
  width: 100%;
  max-width: 900px;
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
    margin-left: "6px";
    padding: "2px 6px";
    background: "#ccc";
    border-radius: "4px";
    font-size: "12px";
    color: "#555";
`