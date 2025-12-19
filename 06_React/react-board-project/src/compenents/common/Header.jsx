import React from 'react'
import { HeaderBar, HeaderRight, Logo, MenuItem, MenuList, WelcomeText } from '../../styled/Header.styled';
import { Link, useNavigate } from 'react-router-dom';
import { useUsers } from '../../context/UserContext';

const Header = () => {
    const navigate = useNavigate();

    const {users, setUsers} = useUsers();

    const logOut = () => {
        setUsers(null);
        navigate("/")
    }
    
    return (
        <>
            <HeaderBar>
                <Logo><Link to="/">Resale Market</Link></Logo>

                <HeaderRight>
                {users?.user_id ? (
                    <>
                    <WelcomeText><Link to={`/mypage/${users.user_id}`}>{users.user_name}</Link> 님 환영합니다.</WelcomeText>
                    <MenuList>
                        <MenuItem><Link onClick={logOut}>로그아웃</Link></MenuItem>
                        <MenuItem><Link to="/productList">물품</Link></MenuItem>
                        <MenuItem><Link to="/productEnroll">판매</Link></MenuItem>
                    </MenuList>
                    </>
                ) : (
                    <>
                        <WelcomeText>로그인이 필요합니다.</WelcomeText>
                        <Link to={'/login'}>로그인</Link>
                        <Link to={'/join'}>회원가입</Link>
                    </>

                )}
                </HeaderRight>
            </HeaderBar>
        </>
    )
}

export default Header