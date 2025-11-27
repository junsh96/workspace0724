import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import JavaScript from './components/JavaScript'
import Style from './components/style'
import Product from './components/Product'
import styled from 'styled-components'
import Home from './pages/Home'
import { BrowserRouter,Routes, Route, Link } from 'react-router-dom'
import About from './pages/About'
import Profile from './pages/Profile'
import NotFound from './pages/NotFound'


// BrowserRouter: 전체 라우팅을 관리하는 최상위 컴포넌트 -> URL변화를 추적해서 그에 맞는 페이지를 렌더링
// Routes : Route들을 감싸서 경로를 비교하고 그중 하나를 렌더링 시키는 라우트 목록
// Route : path와 elements로 한 페이지에 대한 규칙을 정의하는 컴포넌트
// Link : a태그와 동일한 역할을 하지만 실제 서버에 요청을 보내지 않고 spa방식으로 브라우저에서 react-router-dom을 통한 이동

function App() {
  const [count, setCount] = useState(0)

  return (

      <BrowserRouter>
      <nav>
        <Link to="/">홈</Link>
        <Link to="/about">소개</Link>
        <Link to="/profile">프로필</Link>
        
      </nav>
        <Routes>
          <Route path='/' element={<Home/>}/>
          <Route path='/about' element={<About/>}/>
          <Route path='/profile/:userName' element={<Profile/>}/>
          <Route path='*' element={<NotFound/>}/>
        </Routes>
      </BrowserRouter>

  )
}

export default App
