import React from 'react'
import { useLocation, useNavigate, useParams } from 'react-router-dom'
import { Online, OnlineTd, Table, Tbody, Td } from './Style.styled';

const UserDetail = ({userRemove}) => {

    const navigate = useNavigate();
    const { id } = useParams();
    const { search } = useLocation(); //모든 쿼리스트림
    const params = new URLSearchParams(search);
    console.log(params.get("status"));
    const pageBack = () => {
        navigate("/");
    }
    const deleteUser = () => {
        userRemove(id);
        alert("삭제되었습니다.")
        navigate("/");
    }
  return (
    <>
    <Table>
        <Tbody>
            <tr>
                <Td>ID</Td>
                <Td>{id}</Td>
                <Td>name</Td>
                <Td>{params.get("name")}</Td>
            </tr>
            <tr>
                <Td>age</Td>
                <Td>{params.get("age")}</Td>
                <Td>status</Td>
                {params.get("status")==="true" ? <OnlineTd color="green"><Online background="green"/>온라인 상태입니다.</OnlineTd> : <OnlineTd color="gray"><Online background="red"/>오프라인 상태입니다.</OnlineTd>}
            </tr>
        </Tbody>

    </Table>

    <button onClick={pageBack}>뒤로 가기</button>
    <button onClick={deleteUser}>삭제하기</button>
    </>

  )
}

export default UserDetail