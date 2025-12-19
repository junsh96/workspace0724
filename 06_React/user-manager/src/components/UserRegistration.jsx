import React from 'react'
import useInput from '../customHook/useInput'
import useList from '../customHook/useList';
import useRadio from '../customHook/useRadio';
import { useNavigate } from 'react-router-dom';
import { Form, Input, Button } from './Style.styled';

const UserRegistration = ({userList = [], userAdd}) => {
    const navigate = useNavigate();
    const pageBack = () => {
        navigate("/");
    }

    const addUser = (e) => {
        console.log(userList);
        e.preventDefault();
        const exits = userList.some(u => u.name === name.value);

        if (exits) {
            alert("이미 존재하는 이름입니다.");
            name.onChange("");
        } else {
            const userInfo = {
                id : id.value,
                name : name.value,
                age : age.value,
                status : online === "true" ? true : false
            }
            userAdd(userInfo);
            alert("등록완료")
            navigate("/")
        }
    }

    const name = useInput('');
    const age = useInput('');
    const id = useInput('');
   const [online, onOnlineChange] = useRadio("false");
    
  return (
    <>
        <Form onSubmit={addUser}>
            <div>
                <div>
                    아이디 : <Input type="text" placeholder='아이디' {...id} />
                </div>
                
                <div>
                    이름 : <Input type="text" placeholder='이름' {...name}/>
                </div>
                <div>
                    나이 : <Input type="number" placeholder='나이' {...age}/>
                </div>
                <div>
                    온라인 여부 : 온 <input type="radio" 
                                value= "true"
                                name="onLine" 
                                checked={online === "true"} 
                                onChange={onOnlineChange}/> 오프 <input type="radio" 
                                                                value="false"
                                                                name="onLine"
                                                                checked={online === "false"}
                                                                onChange={onOnlineChange}/>
                </div>

            </div>
            <div>
                <Button type="submit" color="blue">회원등록</Button>
                <Button type="button" color="red" onClick={pageBack}>취소</Button>
            </div>
            
        </Form>
        
    </>

  )
}

export default UserRegistration