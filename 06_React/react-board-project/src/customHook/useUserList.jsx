import { useEffect, useState } from "react"

const USERS_KEY = "users";

const useUserList = (init = []) => {
    const [value, setValue] = useState(() => {
        try {
            const saved = localStorage.getItem(USERS_KEY);
            return saved ? JSON.parse(saved) : init;
        } catch (e) {
            console.error("users 로컬스토리지 파싱 오류:", e);
            return init;
        }
    });

    useEffect(() => {
        localStorage.setItem(USERS_KEY, JSON.stringify(value));
    }, [value]);

    const userAdd = (item) => {
        setValue(prev => [...prev, item]);
    }

    const userRemove = (item) => {
        setValue(prev => prev.filter(p => p.id !== item));
    }

    const userUpdate = (item) => {
        setValue(prev => {
            const target = prev.find(p => p.id === item.id);

            if (!target) {
                alert("유저 정보가 존재하지 않습니다.");
                return prev;
            }

            return prev.map(p=> (p.id === item.id ? item : p));

        })
    }

    return {value, userAdd, userRemove, userUpdate};
}

export default useUserList;