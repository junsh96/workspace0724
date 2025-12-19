import React, { useState } from 'react'
import UserListBody from './UserListBody';
import { Link } from 'react-router-dom';
import { Table, Tbody, Th } from './Style.styled';

const UserList = ({userList=[]}) => {

    

    return (
        <>
        <button><Link to="/userRegistration">유저 등록</Link></button>
            <Table>
                <thead>
                    <tr>
                        <Th>아이디</Th>
                        <Th>이름</Th>
                        <Th>나이</Th>
                    </tr>
                </thead>
                <Tbody>
                    {userList.map(u => <UserListBody key={u.id} userList={u}/>) }
                </Tbody>
            </Table>
            
        </>

    )
}

export default UserList