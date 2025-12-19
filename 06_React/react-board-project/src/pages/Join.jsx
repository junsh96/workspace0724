import React from 'react'
import useInput from '../customHook/useInput';
import { JoinCard, JoinContainer, JoinTitle, StyledInput, SubmitButton } from '../styled/Join.styled';
import { InputGroup, Label } from '../styled/Login.styled';
import { useNavigate } from 'react-router-dom';
import { addUser,idCheck } from '../compenents/common/api/User.api';

const Join = ({userList = [], userAdd}) => {
    const navigate = useNavigate();

    const userJoin = async(e) => {
        e.preventDefault();

        if (!id.value.trim()) return alert("아이디를 입력해주세요.");
        if (!name.value.trim()) return alert("이름을 입력해주세요.");
        if (!password.value.trim()) return alert("비밀번호를 입력해주세요.");

        const idExits =  await idCheck(id.value);
        if (idExits.data > 0) {
            alert("이미 존재하는 아이디 입니다.");
            id.setValue("");
        } else {

            const joinUser = {
                user_id : id.value,
                user_name : name.value,
                password : password.value,
                amount : 0
        }

            try {

                await addUser(joinUser);
                //userAdd(joinUser);
                alert("회원가입이 완료되었습니다.")
                id.setValue("");
                name.setValue("");
                password.setValue("");
                console.log(userList)
                navigate("/")

            } catch(e) {
                alert("회원가입에 실패했습니다.");
                console.error(error);
            }
            

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