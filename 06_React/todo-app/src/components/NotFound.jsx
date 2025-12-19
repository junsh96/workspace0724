import React from 'react'
import { useNavigate } from 'react-router-dom';

const NotFound = () => {
    const navigate = useNavigate();
    const pageBack = () => {
        navigate("/");
    }
  return (
    <>
    <div>잘못된 페이지 입니다.</div>
    <button onClick={pageBack}>뒤로가기</button>
    </>
    
  )
}

export default NotFound