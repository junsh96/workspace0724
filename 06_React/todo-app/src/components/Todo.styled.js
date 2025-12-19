// TodoStyled.js
import styled from "styled-components";

/* 전체 레이아웃 */
export const TodoLayout = styled.div`
  max-width: 900px;
  margin: 24px auto;
  padding: 24px;
  background: #f7f9fc;
  border-radius: 16px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.06);
`;

/* 폼 영역 */
export const TodoForm = styled.form`
  display: flex;
  gap: 12px;
  margin-bottom: 20px;
`;

export const FormField = styled.div`
  display: flex;
  flex-direction: column;
  gap: 6px;
  flex: 1;
`;

export const FieldLabel = styled.span`
  font-size: 14px;
  font-weight: 600;
  color: #444;
`;

export const TextInput = styled.input`
  padding: 8px 10px;
  border-radius: 8px;
  border: 1px solid #d0d4e4;
  font-size: 14px;
  outline: none;

  &:focus {
    border-color: #4a90e2;
    box-shadow: 0 0 0 2px rgba(74,144,226,0.2);
  }
`;

export const SelectInput = styled.select`
  padding: 8px 10px;
  border-radius: 8px;
  border: 1px solid #d0d4e4;
  font-size: 14px;
  outline: none;
  background: #fff;

  &:focus {
    border-color: #4a90e2;
    box-shadow: 0 0 0 2px rgba(74,144,226,0.2);
  }
`;

export const SubmitButton = styled.button`
  padding: 9px 18px;
  border-radius: 8px;
  border: none;
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
  background: #4a90e2;
  color: #fff;
  white-space: nowrap;
  transition: background 0.15s;

  &:hover {
    background: #3b79c0;
  }
`;

/* 카테고리 필터 */
export const FilterBar = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 12px;
`;

export const FilterLabel = styled.span`
  font-size: 14px;
  font-weight: 600;
  color: #444;
`;

/* 테이블 */
export const TodoTableWrapper = styled.div`
  margin-top: 8px;
  background: #fff;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 3px 10px rgba(0,0,0,0.06);
`;

export const TodoTable = styled.table`
  width: 100%;
  border-collapse: collapse;
  font-size: 14px;
`;

export const TodoThead = styled.thead`
  background: #edf1fb;
`;

export const TodoTh = styled.th`
  padding: 10px 12px;
  text-align: left;
  font-weight: 600;
  color: #555;
  border-bottom: 1px solid #dfe3f0;
`;

export const TodoTr = styled.tr`
  &:nth-child(even) {
    background: #fafbff;
  }
  &:hover {
    background: #f1f4ff;
  }
`;

export const TodoTd = styled.td`
  padding: 9px 12px;
  border-bottom: 1px solid #eef1f8;
  vertical-align: middle;
`;

export const CheckboxCell = styled(TodoTd)`
  width: 80px;
  text-align: center;
`;

export const DeleteCell = styled(TodoTd)`
  width: 80px;
  text-align: center;
`;