import React from 'react'
import useInput from '../customHook/useInput'
import { useUsers } from '../context/UserContext'
import { useNavigate } from 'react-router-dom';
import { InputGroup, Label, LoginCard, LoginContainer, LoginTitle, StyledInput, SubmitButton } from '../styled/Login.styled';
import { loginUserById } from '../compenents/common/api/User.api';

const Login = ({userList = []}) => {
    const navigate = useNavigate();

    const {users, setUsers} = useUsers();
    const loginUser = async(e) => {
        e.preventDefault();

        if (!id.value.trim()) return alert("아이디를 입력해주세요.");
        if (!password.value.trim()) return alert("비밀번호를 입력해주세요.");


        const loginUserInfo = {
            user_id : id.value,
            password : password.value

        }

        try {
            const loginData = await loginUserById(loginUserInfo);
            console.log("!@#!$",loginData.data);
            setUsers(loginData.data);
            alert("로그인 성공")
            navigate("/");
        } catch(e) {
            alert("비밀번호와 아이디를 확인해주세요.")
            console.log(e);
        }



    }

    const id = useInput('');
    const password = useInput('');
    return (
        <>
            <LoginContainer>
                <LoginCard>
                    <LoginTitle>로그인</LoginTitle>
                    <form onSubmit={loginUser}>
                    <InputGroup>
                        <Label>아이디</Label>
                        <StyledInput type="text" placeholder="아이디를 입력해주세요" {...id} />
                    </InputGroup>

                    <InputGroup>
                        <Label>비밀번호</Label>
                        <StyledInput type="password" placeholder="비밀번호를 입력해주세요" {...password} />
                    </InputGroup>

                    <SubmitButton type="submit">로그인</SubmitButton>
                    </form>
                </LoginCard>
                </LoginContainer>
        </>
    )
}

export default Login