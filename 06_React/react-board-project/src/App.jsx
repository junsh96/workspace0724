import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Route, Routes, useLocation } from 'react-router-dom'
import { UserProvider } from './context/UserContext'
import useUserList from './customHook/useUserList'
import Login from './compenents/Login'
import Product from './compenents/Product'
import Join from './compenents/Join'
import { ProductProvider } from './context/ProductContext'
import ProductEnroll from './compenents/ProductEnroll'
import ProductDetail from './compenents/ProductDetail'
import Home from './compenents/Home'
import NotFound from './compenents/NotFound'
import Header from './compenents/Header'
import MyPage from './compenents/MyPage'

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
              <Route path="/productList" element={<Product userRemove={userRemove}/>} />
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
