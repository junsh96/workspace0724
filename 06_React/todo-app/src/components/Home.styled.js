import styled from "styled-components";

export const DashboardRow = styled.div`
  display: flex;
  gap: 16px;
  margin-bottom: 24px;
`;

export const DashboardCard = styled.div`
  flex: 1;
  background: #ffffff;
  border-radius: 12px;
  padding: 20px;
  text-align: center;
  box-shadow: 0 3px 10px rgba(0,0,0,0.1);
`;

export const Label = styled.span `
    font-size: 16px;
    font-weight: 600;
    color: #333;
`;
export const Span = styled.span`
    display: block;
    margin-top: 8px;
    font-size: 22px;
    font-weight: 700;
    color: #4A90E2;
`;
