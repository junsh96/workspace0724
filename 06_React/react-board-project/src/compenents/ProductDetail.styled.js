import styled from "styled-components";

export const DetailContainer = styled.div`
  max-width: 780px;
  margin: 40px auto;
  padding: 30px;
  background: #fff;
  border-radius: 14px;
  box-shadow: 0px 4px 12px rgba(0,0,0,0.08);
`;

export const Section = styled.div`
  margin-bottom: 30px;
`;

export const Label = styled.label`
  display: block;
  font-size: 15px;
  font-weight: 600;
  margin-bottom: 8px;
`;

export const Input = styled.input`
  width: 100%;
  padding: 12px;
  border-radius: 10px;
  border: 1px solid #ccc;
  outline: none;
  font-size: 14px;

  &:focus {
    border-color: #007bff;
    box-shadow: 0 0 4px rgba(0, 123, 255, 0.3);
  }
`;

export const TextArea = styled.textarea`
  width: 100%;
  padding: 12px;
  height: 130px;
  border-radius: 10px;
  border: 1px solid #ccc;
  font-size: 14px;
  resize: vertical;

  &:focus {
    border-color: #007bff;
    box-shadow: 0 0 4px rgba(0, 123, 255, 0.3);
  }
`;

export const ImageBox = styled.div`
  margin-top: 10px;

  img {
    width: 200px;
    border-radius: 12px;
    box-shadow: 0px 2px 6px rgba(0,0,0,0.15);
  }
`;

export const ButtonGroup = styled.div`
  display: flex;
  gap: 12px;
  margin-top: 15px;
`;

export const Btn = styled.button`
  flex: 1;
  padding: 13px;
  border: none;
  border-radius: 10px;
  font-size: 15px;
  font-weight: bold;
  cursor: pointer;

  ${({ typeBtn }) =>
    typeBtn === "delete"
      ? `
    background: #dc3545;
    color: white;

    &:hover { background: #b52a38; }
  `
      : `
    background: #007bff;
    color: white;

    &:hover { background: #005fcc; }
  `}
`;

export const CommentForm = styled.form`
  margin-top: 40px;
  padding-top: 20px;
  border-top: 1px solid #ddd;
`;

export const CommentTextArea = styled.textarea`
  width: 100%;
  padding: 12px;
  height: 90px;
  border-radius: 10px;
  border: 1px solid #ccc;
  resize: vertical;
  margin-bottom: 12px;
  font-size: 14px;
`;

export const CommentBtn = styled.button`
  width: 100%;
  padding: 12px;
  font-size: 15px;
  font-weight: bold;
  border-radius: 10px;
  border: none;
  background: #28a745;
  color: white;
  cursor: pointer;

  &:hover {
    background: #1f8a39;
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