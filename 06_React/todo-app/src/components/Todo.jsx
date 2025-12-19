import React from 'react'
import { useTodayTodos } from '../context/TodayTodoContext';
import useInput from '../customHook/useInput';
import TodoBody from './TodoBody';
import { FieldLabel, FilterBar, FilterLabel, FormField, SelectInput, SubmitButton, TextInput, TodoForm, TodoTable, TodoTableWrapper, TodoTh, TodoThead } from './Todo.styled';

const Todo = () => {
    const { todayTodos, setTodayTodos } = useTodayTodos();
    const todo = useInput('');
    const category = useInput('work');
    const categoryFilter = useInput('all');

    const handleCategory = (e) => {
        categoryFilter.onChange(e);
    }

    const filterTodoList = todayTodos
    .map((todo, i) => ({ ...todo, originalIndex: i }))
    .filter(todo => 
        categoryFilter.value == 'all' ? 
        true :
        todo.category === categoryFilter.value
    );

    const plusTodo = (e) => {
        e.preventDefault();
        console.log(todo.value)
        console.log(category.value)
        const todoList = {
            todo : todo.value,
            category : category.value,
            status : "progress"
        }
        setTodayTodos(prev => [...prev,todoList])

        todo.setValue('');
        category.setValue('work');

    }

    return (
        <>
            <div>

                <TodoForm  onSubmit={plusTodo}>
                    <FormField>
                       <FieldLabel>할 일:</FieldLabel>  
                       <TextInput  type="text" placeholder='할 일을 입력해주세요.' {...todo}/>
                    </FormField>
                    <FormField>
                        <FilterLabel>카테고리 : </FilterLabel>
                        <SelectInput  {...category}>
                            <option value="work">work</option>
                            <option value="personal">personal</option>
                            <option value="study">study</option>
                        </SelectInput>
                    </FormField>
                    <SubmitButton  type="submit">추가</SubmitButton>

                </TodoForm>
            </div>

            <div>
                <FilterBar>
                    <FilterLabel>카테고리 : </FilterLabel>
                    <SelectInput  onChange={handleCategory}>
                        <option value="all">all</option>
                        <option value="work">work</option>
                        <option value="personal">personal</option>
                        <option value="study">study</option>
                    </SelectInput>
                </FilterBar>
                <TodoTableWrapper>
                    <TodoTable>
                    <TodoThead>
                        <tr>
                            <TodoTh>할 일</TodoTh>
                            <TodoTh>카테고리</TodoTh>
                            <TodoTh>완료여부</TodoTh>
                            <TodoTh>삭제</TodoTh>
                        </tr>
                    </TodoThead>
                    <tbody>
                        {filterTodoList.map((t,index) => (<TodoBody key={index} index={t.originalIndex}/>))}
                    </tbody>
                </TodoTable>
                </TodoTableWrapper>
                
            </div>
        </>
    ) 
}

export default Todo