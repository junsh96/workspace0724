import React from 'react'
import { useNavigate } from 'react-router-dom';

const NotFound = () => {
    const navigate = useNavigate();
    const pageBack = () => {
        navigate("/");
    }
    return (
        <>
            <div>잘못된 접근입니다.</div>
            <button onClick={pageBack}>홈으로</button>
        </>

    )
}

export default NotFound