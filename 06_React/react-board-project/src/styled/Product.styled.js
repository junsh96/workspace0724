import styled from "styled-components";

export const ProductWrapper = styled.div`
    width: 900px;
    margin: 40px auto;
    padding: 20px;
`;

export const ProductTable = styled.table`
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;

    th, td {
        padding: 12px;
        border-bottom: 1px solid #ddd;
        text-align: center;
    }

    th {
        background-color: #f7f7f7;
        font-weight: bold;
    }

    tbody tr {
        cursor: pointer;
        transition: 0.2s;
    }

    tbody tr:hover {
        background-color: #fafafa;
    }
`;

export const WriteButton = styled.div`
    display: flex;
    justify-content: flex-end;

    a {
        background-color: #4A90E2;
        color: white;
        padding: 10px 18px;
        border-radius: 8px;
        font-size: 15px;
        text-decoration: none;
        transition: 0.2s;
    }

    a:hover {
        background-color: #357ABD;
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