import React from 'react'
import useInput from '../customHook/useInput';
import { JoinCard, JoinContainer, JoinTitle, StyledInput, SubmitButton } from '../styled/Join.styled';
import { InputGroup, Label } from '../styled/Login.styled';
import { useNavigate } from 'react-router-dom';

const Join = ({userList = [], userAdd}) => {
    const navigate = useNavigate();

    const userJoin = (e) => {
        e.preventDefault();

        if (!id.value.trim()) return alert("아이디를 입력해주세요.");
        if (!name.value.trim()) return alert("이름을 입력해주세요.");
        if (!password.value.trim()) return alert("비밀번호를 입력해주세요.");

        const idExits =  userList.some(u => u.id === id.value)
        if (idExits) {
            alert("이미 존재하는 아이디 입니다.");
            id.setValue("");
        } else {

            const joinUser = {
                id : id.value,
                name : name.value,
                password : password.value,
                joinDate : Date.now(),
                amount : 0
        }

            userAdd(joinUser);
            alert("회원가입이 완료되었습니다.")
            id.setValue("");
            name.setValue("");
            password.setValue("");
            console.log(userList)
            navigate("/")

        }

    }

    const id = useInput('');
    const name = useInput('');
    const password = useInput('');

    return (
        <>
            <JoinContainer>
                <JoinCard>
                    <JoinTitle>회원가입</JoinTitle>

                    <form onSubmit={userJoin}>
                    <InputGroup>
                        <Label>아이디</Label>
                        <StyledInput
                        type="text"
                        placeholder="아이디를 입력해주세요."
                        {...id}
                        />
                    </InputGroup>

                    <InputGroup>
                        <Label>이름</Label>
                        <StyledInput
                        type="text"
                        placeholder="이름을 입력해주세요."
                        {...name}
                        />
                    </InputGroup>

                    <InputGroup>
                        <Label>비밀번호</Label>
                        <StyledInput
                        type="password"
                        placeholder="비밀번호를 입력해주세요."
                        {...password}
                        />
                    </InputGroup>

                    <SubmitButton type="submit">회원가입</SubmitButton>
                    </form>
                </JoinCard>
                </JoinContainer>
        </>
    )
}

export default Join