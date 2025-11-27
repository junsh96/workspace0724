import React, { useContext } from 'react'
import ThemeContext from './ThemeContext';

const MainContext = () => {
    const {theme, toggleTheme} = useContext(ThemeContext);
    const containerStyle = {
        width: "100vw",
        height : "100vw",
        padding : "12px",
        background : theme,
        color : theme === "white" ?  "black" : "white"
    }    
return (
    <div>
        <p>안녕하세요 테마 변경 테스트</p>
        <button onClick={toggleTheme} >테마 변경</button>
    </div>
  )
}

export default MainContext