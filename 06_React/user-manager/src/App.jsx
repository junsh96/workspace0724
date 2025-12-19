import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom'
import UserList from './components/UserList'
import UserDetail from './components/UserDetail'
import UserRegistration from './components/UserRegistration'
import NotFound from './components/NotFound'
import useList from './customHook/useList'

function App() {
  const [count, setCount] = useState(0)
  const [userList, userAdd, userRemove] = useList([]);
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<UserList userList={userList}/>}/>
          <Route path="/userDetail/:id" element={<UserDetail userRemove = {userRemove}/>}/>
          <Route path="/userRegistration" element={<UserRegistration userList={userList} userAdd={userAdd}/>}/>
          <Route path="*" element={<NotFound/>}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
