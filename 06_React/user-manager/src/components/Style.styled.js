import styled from "styled-components";

export const Table = styled.table`
    width: 100%;
    border-collapse: collapse; 
    background: #fff;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    
`
export const Th = styled.th`
    background: #f4f6f8;
    color: #333;
    font-weight: 600;
    padding: 14px 12px;
    border-bottom: 1px solid #ddd;
    text-align: center;
    font-size: 14px;
`
export const Tbody = styled.tbody`
    background-color: #fff;
`

export const Td = styled.td`
    padding: 12px 10px;
    border-bottom: 1px solid #eee;
    text-align: center;
    font-size: 14px;
    color: #555;
    
`
export const OnlineTd = styled.td`
    padding: 12px 10px;
    border-bottom: 1px solid #eee;
    text-align: center;
    font-size: 14px;
    color: ${(props) => props.color};
    display: flex;
    align-items: flex-start;
`

export const Online = styled.span`
    margin-top: 7px;
    display: inline-block;
    background-color: ${(props) => props.background};
    border-radius: 50%;
    width: 10px;
    height: 10px;
`



export const Form = styled.form`
  width: 360px;
  margin: 40px auto;
  padding: 25px;
  border: 1px solid #ddd;
  border-radius: 12px;
  background: #f9f9f9;
  box-shadow: 0 4px 12px rgba(0,0,0,0.08);
`


export const Input = styled.input`
  width: 100%;
  padding: 10px 12px;
  border: 1px solid #ccc;
  border-radius: 8px;
  font-size: 14px;
  outline: none;
  transition: 0.2s border-color;

`


export const Button = styled.button`
  padding: 10px 16px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-size: 14px;
  transition: 0.2s;
  background: ${(props) => props.color};
  color : white;
`