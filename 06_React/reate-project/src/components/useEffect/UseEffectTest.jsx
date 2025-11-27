import React, { useEffect, useState } from 'react'

const UseEffectTest = () => {

    const [name, setName] = useState("TEST");
    const [num, setNum] = useState(0);

    const handleChangeName = (ev) => setName(ev.target.value);
    const handleChangeNum = (ev) => setNum(prev => prev + 1);

    //1.의존성 배열 없이 단순하게 이펙트함수만 전달 할때
    //의존성이 없는 경우 모든 렌더링시 실행.
    useEffect(() => {

    })

    //2. 빈 배열을 의존성 배열로 넣었을때
    //컴포넌트가 마운트 될때 1회 실행
    useEffect(() => {

    },[])

    //3.의존성 배열에 특정 state를 넣었을때
    //name이 변경될때만 실행 
    useEffect(() => {

    },[name])

    //4. 클린업 함수(컴포넌트가 사라질때 실행하는 함수)
    //특정 값이 변경되기 이전 값을 활용히고 싶을때(언마운트 전 실행)
    useEffect(() => {
        return () => {
            
        }
    },[num])

    //5. 컴포넌트가 완전히 사라질 때 실행되는 함수
    useEffect(() => {
        return () => {
            
        }
    },[])

  return (
    <div>
        <h2>useEffect 테스트</h2>
        <p>안녕하세요 <strong>{name}</strong>입니다</p>

        <input type="text"
            onChange={handleChangeName}
            value={name}
            placeholder='이름을 입력'
            />

        <p>
            버튼을 <strong>{num}</strong>번 입력하셧습니다.

        </p>
        <button onChange={handleChangeNum}> + </button>
    </div>
  )
}

export default UseEffectTest