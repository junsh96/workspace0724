import { useState } from "react";
import { useTodayTodos } from "../context/TodayTodoContext";

const useCheckbox = (index) => {
    const { todayTodos, setTodayTodos } = useTodayTodos();
    
    const isDone = todayTodos[index].status === "done";
    const [checked, setChecked] = useState(isDone);

    const onChange = () => {
        const newChecked = !checked;
        setChecked(newChecked);

        // Context 내부 데이터 업데이트
        setTodayTodos(prev =>
            prev.map((todo, i) =>
                i === index 
                    ? { ...todo, status: newChecked ? "done" : "progress" }
                    : todo
            )
        );
    };

        return { checked, onChange };
};

export default useCheckbox;