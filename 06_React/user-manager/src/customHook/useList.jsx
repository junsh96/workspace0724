import { useState } from "react"

const useList = (init = []) => {
    const [value, setValue] = useState(init);

    const userAdd = (item) => {
        setValue(prev => [...prev, item]);
    }

    const userRemove = (item) => {
        setValue(prev => prev.filter(p => p.id !== item));
    }

    return [value, userAdd, userRemove];
}

export default useList;