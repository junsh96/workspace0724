import React from 'react'
import { Td } from './Style.styled'
import { Link } from 'react-router-dom'

const UserListBody = ({userList}) => {
  return (
    <tr>
        <Td><Link to={`/userDetail/${userList.id}?name=${userList.name}&age=${userList.age}&status=${userList.status}`}>{userList.id}</Link></Td>
        <Td>{userList.name}</Td>
        <Td>{userList.age}</Td>
    </tr>
  )
}

export default UserListBody