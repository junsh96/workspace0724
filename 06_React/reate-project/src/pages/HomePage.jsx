import React from 'react'
import styled from 'styled-components'
import { Container, Title } from '../components/styled/common'



const Button = styled(Link)`
    display: inline-block;
    background: #4f1342;
    color : white;
    padding: 12px 24px;
    border-radius: 4px;
    text-decoration: none;
    margin: 12px;

    &:hover {
        scale: 0.9;
    }
`

const HomePage = () => {
  return (
    <Container>
        <Title>게시판 관리</Title>
        <Button to="/posts">게시글 목록</Button>
    </Container>
  )
}

export default HomePage