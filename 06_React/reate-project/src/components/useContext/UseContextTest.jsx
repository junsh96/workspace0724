import React, { useState } from 'react'
import ThemeContext from './ThemeContext';
import MainContext from './MainContext';

const UseContextTest = () => {
    const [theme, setTheme] = useState("white");

    const toggleTheme = () => setTheme(theme === "white" ? "black" : "white");
  return (
    <ThemeContext.Provider value={{theme, toggleTheme}}>
        <MainContext />
    </ThemeContext.Provider>
  )
}

export default UseContextTest