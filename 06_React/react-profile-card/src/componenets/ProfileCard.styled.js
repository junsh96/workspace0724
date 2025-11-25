import styled from "styled-components";

export const Table = styled.table`
    border: 1px solid black;
    width: 100%;
    
`
export const Th = styled.th`
    border: 1px solid black;
    padding: 12px;
`
export const Tbody = styled.tbody`
    background-color: yellow;
`

export const Td = styled.td`
    border: 1px solid black;
    
`
export const OnlineTd = styled.td`
    border: 1px solid black;
    color: green;
    display: flex;
    align-items: flex-start;
`
export const OflineTd = styled.td`
    border: 1px solid black;
    color : gray;
    display: flex;
    align-items: flex-start;
`

export const Online = styled.span`
    margin-top: 7px;
    display: inline-block;
    background-color: green;
    border-radius: 50%;
    width: 10px;
    height: 10px;
`
export const Ofline = styled.span`
    margin-top: 7px;
    display: inline-block;
    background-color: red;
    border-radius: 50%;
    width: 10px;
    height: 10px;
`