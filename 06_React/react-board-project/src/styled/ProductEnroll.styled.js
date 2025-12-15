import styled from "styled-components";

export const EnrollContainer = styled.div`
  width: 900px;
  margin: 40px auto;
  padding: 30px;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0px 4px 12px rgba(0,0,0,0.1);
`;

export const EnrollTitle = styled.h2`
  font-size: 24px;
  margin-bottom: 25px;
  font-weight: 700;
  text-align: center;
`;

export const FormGroup = styled.div`
  margin-bottom: 18px;

  label {
    display: block;
    font-size: 15px;
    font-weight: 600;
    margin-bottom: 6px;
  }

  input[type="text"],
  input[type="number"],
  textarea {
    width: 100%;
    border: 1px solid #ccc;
    padding: 12px;
    border-radius: 8px;
    font-size: 14px;
    transition: all 0.2s;
    outline: none;

    &:focus {
      border-color: #007bff;
      box-shadow: 0 0 3px rgba(0, 123, 255, 0.4);
    }
  }

  textarea {
    height: 140px;
    resize: vertical;
  }
`;

export const FileInput = styled.input`
  margin-top: 8px;
`;

export const PreviewBox = styled.div`
  margin-top: 10px;

  img {
    border-radius: 8px;
    box-shadow: 0px 2px 6px rgba(0,0,0,0.2);
  }
`;

export const SubmitBtn = styled.button`
  width: 100%;
  padding: 14px 0;
  margin-top: 10px;
  background: #007bff;
  color: white;
  font-size: 16px;
  font-weight: bold;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: 0.2s;

  &:hover {
    background: #005fcc;
  }
`;