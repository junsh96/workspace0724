import styled from "styled-components";

export const CommentBox = styled.div`
  width: 100%;
  padding: 14px 16px;
  background: #fafafa;
  border-radius: 12px;
  margin-bottom: 12px;
  border: 1px solid #eeeeee;
  box-sizing: border-box;
`;

export const CommentHeader = styled.div`
  font-size: 14px;
  font-weight: 600;
  margin-bottom: 6px;
  color: #555;
`;

export const CommentContent = styled.div`
  font-size: 14px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 8px;
`;

export const DeleteBtn = styled.button`
  padding: 6px 12px;
  font-size: 12px;
  border: 1px solid #ff4d4f;
  background: #fff;
  color: #ff4d4f;
  border-radius: 999px;
  cursor: pointer;
  flex-shrink: 0;

  &:hover {
    background: #ff4d4f;
    color: #fff;
  }
`;