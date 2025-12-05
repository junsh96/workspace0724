import styled from "styled-components";

export const CommentBox = styled.div`
  padding: 14px 16px;
  background: #f9f9f9;
  border-radius: 12px;
  margin-bottom: 12px;
  border: 1px solid #eee;
`;

export const CommentHeader = styled.div`
  font-size: 14px;
  font-weight: 600;
  margin-bottom: 6px;
  color: #555;
`;

export const CommentContent = styled.div`
  font-size: 14px;
  margin-bottom: 10px;
`;

export const DeleteBtn = styled.button`
  padding: 6px 10px;
  font-size: 12px;
  border: none;
  background: #dc3545;
  color: white;
  border-radius: 6px;
  cursor: pointer;

  &:hover {
    background: #b52a38;
  }
`;