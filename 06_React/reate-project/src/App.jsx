import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import JavaScript from './components/JavaScript'
import Style from './components/style'
import Product from './components/Product'
import styled from 'styled-components'
import LifecycleTest from './components/LifecycleTest'
import CommentBox from './components/CommentBox'
import UseStateTest from './components/useState/UseStateTest'
import Signup from './components/useState/Signup'
import LandingPage from './components/useState/LandingPage'
import UseRefTest from './components/useRef/UseRefTest'
import UseRefScroll from './components/useRef/UseRefScroll'
import UseMemoTest from './components/useMemo/UseMemoTest'
import UseCallbackTest from './components/useCallback/UseCallbackTest'
import UseEffectView from './components/useEffect/UseEffectView'
import UseContextTest from './components/useContext/UseContextTest'
import MyInfo from './components/customHook/MyInfo'
import ToggleBox from './components/customHook/ToggleBox'
import { UserProVider } from './components/useContext/UserContext'
import Header from './components/useContext/Header'


function App() {
  const [isView, setIsView] = useState(true)

  const toggleButton = () => {
    setIsView(!isView);
  }

  return (
    <>
      {/* <UseStateTest/> */}
      {/* <Signup/> */}
      {/* <LandingPage/> */}
      {/* <UseRefTest/> */}
      {/* <UseRefScroll/> */}
      {/* <UseMemoTest/> */}
      {/* <UseCallbackTest/> */}
      {/* <UseEffectView/> 플러스 안됨*/}
      {/* <UseContextTest/> 테마 변경 안됨 */}
      {/* <MyInfo/> */}
      {/* <ToggleBox/> 에러 발생 */}

      <UserProVider>
        <Header/>
      </UserProVider>
    </>
  )
}

export default App
