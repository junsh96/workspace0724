import { createContext, useState, useContext } from "react";

const TodayTodoContext = createContext();

export const TodayTodoProvider = ({ children }) => {
  const [todayTodos, setTodayTodos] = useState([]);

  return (
    <TodayTodoContext.Provider value={{ todayTodos, setTodayTodos }}>
      {children}
    </TodayTodoContext.Provider>
  );
};

export const useTodayTodos = () => useContext(TodayTodoContext);