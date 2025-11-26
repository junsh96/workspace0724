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
export const OnOfTd = styled.td`
    border: 1px solid black;
    display: flex;
    align-items: flex-start;
    color : ${props => props.color || green};
`

export const Status = styled.td`
    margin-top: 7px;
    display: inline-block;
    border-radius: 50%;
    width: 10px;
    height: 10px;
    background-color: ${props => props.background || green};
`
