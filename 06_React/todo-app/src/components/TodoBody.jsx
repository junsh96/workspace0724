import React from 'react'
import { useTodayTodos } from '../context/TodayTodoContext';
import useCheckbox from '../customHook/useCheckbox';


const TodoBody = ({index}) => {
    const { todayTodos, setTodayTodos } = useTodayTodos();
    const todayTodo = todayTodos[index];
    const checkbox = useCheckbox(index);

    //인덱스 기준 배열 필터
    const deleteTodo = () => {
        setTodayTodos(prev => prev.filter((_, i) => i != index));
    }

    return (
        <tr>
            <td>{todayTodo.todo}</td>
            <td>{todayTodo.category}</td>
            <td><input type="checkbox" {...checkbox}/></td>
            <td><button onClick={deleteTodo}>삭제</button></td>
        </tr>
    )
}

export default TodoBody