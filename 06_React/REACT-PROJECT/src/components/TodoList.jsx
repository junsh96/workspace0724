import React from 'react'
import { CheckBox, DeleteButton, FilterContainer, ListContainer, NormalButton, TodoText } from './TodoList.styled'



const TodoList = () => {
    const {getFilteredTodos,filter,setFilter, toggleTodo, deleteTodo} = useTodoStore();
 
    const todos = getFilteredTodos();
    return (
    <ListContainer>
        <FilterContainer>
            <NormalButton
                onClick={() => setFilter('all')}
            >
                전체
            </NormalButton>
            <NormalButton
                onClick={() => setFilter('active')}
            >
                진행중
            </NormalButton>
            <NormalButton
                onClick={() => setFilter('completed')}
            >
                완료
            </NormalButton>

        </FilterContainer>

        {todos.map(todo => (
            <TodoItem key={todo.id}>
                <CheckBox
                    type="checkbox"
                    checkd={todo.completed}
                    onChange={() => toggleTodo(todo.id)}
                />
                <TodoText completed = {todo.completed} >{todo.TodoText} </TodoText>
                <DeleteButton onClick={() => deleteTodo(todo.id)} >삭제</DeleteButton>
            </TodoItem>
        ))}
    </ListContainer>
  )
}

export default TodoList