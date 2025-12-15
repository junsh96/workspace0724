import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Route, Routes, useLocation } from 'react-router-dom'
import { UserProvider } from './context/UserContext'
import useUserList from './customHook/useUserList'
import Home from './pages/Home'
import Login from './pages/Login'
import Join from './pages/Join'
import MyPage from './pages/MyPage'
import ProductPage from './pages/ProductPage'
import ProductEnroll from './pages/ProductEnroll'
import ProductDetail from './pages/ProductDetail'
import NotFound from './compenents/common/NotFound'
import { ProductProvider } from './context/ProductContext'
import Header from './compenents/common/Header'


function HeaderController() {
  const location = useLocation();

  const hideHeaderRoutes = ["/login", "/join"];
  const isHideHeader = hideHeaderRoutes.includes(location.pathname);

  return !isHideHeader && <Header />;
}

function App() {

  const {value : userList, userAdd, userRemove, userUpdate} = useUserList([]);
  console.log(userList);
  return (
    <>  
      <UserProvider>
        <ProductProvider>
          <BrowserRouter>
            <HeaderController />
            <Routes>
              <Route path="/" element={<Home />}/>
              <Route path="/login" element={<Login userList={userList}/>} />
              <Route path="/join" element={<Join userList={userList} userAdd={userAdd}/>}/>
              <Route path="/myPage/:id" element={<MyPage />}/>
              <Route path="/productList" element={<ProductPage userRemove={userRemove}/>} />
              <Route path="/productEnroll" element={<ProductEnroll />} />
              <Route path="/productDetail/:productId" element={<ProductDetail userUpdate={userUpdate} />} />
              <Route path="/*" element={<NotFound />} />
            </Routes>
          </BrowserRouter>
        </ProductProvider>
      </UserProvider>

    </>
  )
}

export default App
