import React from 'react'
import useToggle from './useToggle'

const ToggleBox = () => {
    const [isView, toggleView] = useToggle();
  return (
    <div>
        <button onClick={toggleView}>
            {isView ? "숨기기" : "보이기"}
        </button>
        {
            isView && <div>컨텐츠 영역입니다.</div>
        }
    </div>
  )
}

export default ToggleBox