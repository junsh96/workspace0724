import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './components/Home'
import Todo from './components/Todo'
import TodoDetail from './components/TodoDetail'
import Category from './components/category'
import { TodayTodoProvider } from './context/TodayTodoContext'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <TodayTodoProvider>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home/>}/>
          <Route path='/todos' element={<Todo/>}/>
          <Route path='/todos:id' element={<TodoDetail/>}/>
          <Route path='/category/:category' element={<Category/>}/>
          <Route path='/*'/>
        </Routes>
      </BrowserRouter>
    </TodayTodoProvider>

    </>
  )
}

export default App
