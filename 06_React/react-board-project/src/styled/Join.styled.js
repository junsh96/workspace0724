import styled from "styled-components";

export const JoinContainer = styled.div`
  width: 100%;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #f4f4f4;
`;

export const JoinCard = styled.div`
  width: 380px;
  padding: 32px;
  border-radius: 12px;
  background: #ffffff;
  box-shadow: 0 4px 20px rgba(0,0,0,0.1);
`;

export const JoinTitle = styled.h2`
  margin-bottom: 24px;
  text-align: center;
  font-weight: 600;
`;

export const InputGroup = styled.div`
  margin-bottom: 18px;
`;

export const Label = styled.label`
  display: block;
  margin-bottom: 6px;
  font-size: 14px;
  color: #333;
`;

export const StyledInput = styled.input`
  width: 100%;
  padding: 12px 14px;
  border: 1px solid #ccc;
  border-radius: 8px;
  font-size: 15px;
  outline: none;
  transition: border-color 0.2s ease;

  &:focus {
    border-color: #007bff;
  }
`;

export const SubmitButton = styled.button`
  width: 100%;
  padding: 12px 0;
  background: #28a745;   /* 로그인은 파란색, 회원가입은 초록색 추천 */
  border: none;
  border-radius: 8px;
  color: white;
  font-size: 16px;
  margin-top: 10px;
  cursor: pointer;
  transition: background 0.2s ease;

  &:hover {
    background: #1e7e34;
  }
`;