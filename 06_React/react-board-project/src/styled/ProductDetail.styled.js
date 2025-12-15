import styled from "styled-components";

export const DetailContainer = styled.div`
  width: 900px;      
  margin: 40px auto;
  padding: 20px 30px;

  background: #fff;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.08);
  box-sizing: border-box;
`;

/* 위쪽 상품 정보 섹션 전체 */
export const Section = styled.div`
  width: 100%;
  margin-bottom: 32px;
`;

/* 라벨 */
export const Label = styled.label`
  display: block;
  font-size: 15px;
  font-weight: 600;
  margin-bottom: 8px;
  color: #333;
`;

/* 인풋(제목, 가격) */
export const Input = styled.input`
  width: 100%;
  padding: 14px 16px;
  border-radius: 12px;
  border: 1px solid #dcdcdc;
  outline: none;
  font-size: 15px;
  box-sizing: border-box;

  &:focus {
    border-color: #ff7e35;
    box-shadow: 0 0 0 2px rgba(255, 126, 53, 0.15);
  }
`;

/* 내용 textarea */
export const TextArea = styled.textarea`
  width: 100%;
  min-height: 160px;
  padding: 14px 16px;
  border-radius: 12px;
  border: 1px solid #dcdcdc;
  font-size: 15px;
  resize: vertical;
  box-sizing: border-box;

  &:focus {
    border-color: #ff7e35;
    box-shadow: 0 0 0 2px rgba(255, 126, 53, 0.15);
  }
`;


export const ImageBox = styled.div`
  width: 380px;
  height: 380px;
  background: #f3f3f3;
  border-radius: 12px;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;

  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
`;
/* 버튼 묶음 (판매완료/수정/삭제) */
export const ButtonGroup = styled.div`
  display: flex;
  gap: 14px;
  margin-top: 24px;
`;

export const Btn = styled.button`
  flex: 1;
  padding: 14px 0;
  border: none;
  border-radius: 999px;
  font-size: 15px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.15s ease;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.04);

  ${({ typeBtn }) =>
    typeBtn === "delete"
      ? `
        background: #ff4d4f;
        color: #fff;

        &:hover {
          background: #e64547;
        }
      `
      : `
        background: #ff7e35;
        color: #fff;

        &:hover {
          background: #ff6a12;
        }
      `}

  &:disabled {
    opacity: 0.5;
    cursor: default;
    box-shadow: none;
  }
`;

/* 댓글 입력 폼 */
export const CommentForm = styled.form`
  margin-top: 48px;
  padding-top: 28px;
  border-top: 1px solid #e5e5e5;
`;

/* 댓글 입력 textarea */
export const CommentTextArea = styled.textarea`
  width: 100%;
  padding: 14px 16px;
  min-height: 120px;
  border-radius: 12px;
  border: 1px solid #dcdcdc;
  resize: vertical;
  font-size: 14px;
  box-sizing: border-box;
  margin-bottom: 14px;

  &:focus {
    border-color: #ff7e35;
    box-shadow: 0 0 0 2px rgba(255, 126, 53, 0.15);
  }
`;

/* 댓글 등록 버튼 */
export const CommentBtn = styled.button`
  width: 100%;
  padding: 13px 0;
  font-size: 15px;
  font-weight: 600;
  border-radius: 999px;
  border: none;
  background: #2ecc71;
  color: #fff;
  cursor: pointer;
  transition: background 0.15s ease;

  &:hover {
    background: #27ae60;
  }

  &:disabled {
    background: #ccc;
    cursor: default;
  }
`;

/* 판매완료 뱃지 */
export const SellSpan = styled.span`
  display: inline-block;
  padding: 6px 12px;
  margin-left: 8px;
  font-size: 13px;
  font-weight: 700;
  color: #d35400;
  border: 1px solid #f5a623;
  border-radius: 999px;
  background: #fff7e6;
  vertical-align: middle;
`;

export const InfoRow = styled.div`
  display: grid;
  grid-template-columns: 380px 1fr;   /* 왼: 이미지 / 오른: 내용 */
  gap: 40px;
  width: 100%;
  max-width: 1200px;  /* 페이지 전체 너비 */
  margin: 0 auto 40px auto;
  align-items: flex-start;
`;

export const FavoriteWrapper = styled.div`
  display: flex;
  justify-content: flex-end;
`;