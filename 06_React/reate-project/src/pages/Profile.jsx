import React from 'react'
import { useLocation, useParams } from 'react-router-dom'

const Profile = () => {
    // const params = useParams();
    // params.userName;
    const {userName} = useParams();

    const { search } = useLocation(); //모든 쿼리스트림

    const query = new URLSearchParams(search);
    const sort  = query.get("sort");
    console.log(sort);
  return (
    <>
        {sort}
        <div>프로필 페이지 입니다.</div>
        <div>{userName}의 프로필</div>
    </>

  )
}

export default Profile