import React from 'react'
import { useUsers } from '../context/UserContext';
import { HeaderBar, HeaderRight, Logo, MenuItem, MenuList, WelcomeText } from './Header.styled';
import { Link } from 'react-router-dom';

const Header = () => {

    const {users, setUsers} = useUsers();
    
    return (
        <>
            <HeaderBar>
                <Logo><Link to="/">Resale Market</Link></Logo>

                <HeaderRight>
                {users?.id ? (
                    <>
                    <WelcomeText><Link to={`/mypage/${users.id}`}>{users.name}</Link> 님 환영합니다.</WelcomeText>
                    <MenuList>
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