import { useState } from "react"

const useRadio = (init) => {
    const [value , setValue] = useState(init);

    const onChange = (e) => {
        console.log(e.target.value)
        setValue(e.target.value);
    }

    return [value, onChange];
}

export default useRadio;