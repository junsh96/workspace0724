import { useState } from "react"

const useInput = (init) => {
    const [value, setValue] = useState(init);

    const onChange = ev => setValue(ev.target.value);

    return {value, onChange,setValue}
}

export default useInput;