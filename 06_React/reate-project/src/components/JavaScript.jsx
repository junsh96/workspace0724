import React from 'react'

const text = 'Hello, JSX';
const num = 100;

const loginUser = {
    name : "TEST",
    id : "TEST",
    age : 19,
    info : "Hello" 
}

const imgUrl = "data:image/jpeg;base64,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";

const numbers = [1,3,5,7,9]

const userList = [
    {
    name : "TEST",
    id : "TEST",
    age : 19,
    info : "Hello" 
},
{
    name : "TEST2",
    id : "TEST2",
    age : 19,
    info : "Hello" 
},
{
    name : "TEST3",
    id : "TEST3",
    age : 19,
    info : "Hello" 
}
]

const getImg = () => <img src={imgUrl} alt="피카츄" width={100}/>

const JavaScript = () => {
  return (
    <>
        <h1>React의 JS</h1>
        <h2>변수 표현 방법</h2>
        <ul>
            <li>{text}</li>
            <li>{text + " TEST"}</li>
        </ul>
        <ul>
            <li>{num}</li>
            <li>{num + 900}</li>
        </ul>
        <h2>Boolean 값</h2>
        <ul>
            <li>{true}</li>
            <li>{false}</li>
            <li>{null}</li>
            <li>{undefined}</li>
        </ul>

        <h2>Object, Array</h2>
        <ul>
            {
                //[name, id, age, info]
                Object.keys(loginUser).map((key) => {
                  return <li ley={key}>{key} : {loginUser[key]}</li>  
                })
            }
            <li>{numbers}</li>{/*배열 그대로 출력(문자열로 자동 변환)*/}
            {[<li key={0}>111</li>,<li key={1}>222</li>,<li key={2}>333</li>]}
        </ul>

        <h2>태그 속성에 값 넣기</h2>
        <ul>
            <img src={imgUrl} alt="피카츄" width={100}></img>
        </ul>

        <h2>조건부 렌더링</h2>
        <ul>
            <li>{num > 10 ? "10보다 큼" : "10보다 작음"}</li>
            {num !== 10 && <li>num은 10보다 작음</li>}
            {num === 10 && <li>num은 10보다 작음</li>}
            {num !== 10 || <li>num은 10보다 작음</li>}
            {num === 10 || <li>num은 10보다 작음</li>}

            <h3>삼향 연산자</h3>
            <li>{1 + 1 === 2 ? "참이다" : "거짓이다"}</li>

            <h3>AND 연산자</h3>
            <li>{1 + 1 === 2 && "AND연산자1"}</li>
            <li>{1 + 1 !== 2 && "AND연산자2"}</li>
            {userList.length !== 0 && 
                userList.map(u =>
                    <li>{u.name}</li>
                )}

            <li>{1 + 1 === 2 || "AND연산자1"}</li>
            <li>{1 + 1 !== 2 || "AND연산자2"}</li>
            {userList.length === 0 || 
                userList.map(u =>
                    <li>{u.name}</li>
                )}
        </ul>

        <h2>함수 호출로 태그가 반환되어 올수 있다.</h2>
        <ul>
            <li>{getImg()}</li>
            <li>{getImg()}</li>
            <li>{getImg()}</li>
        </ul>
    </>
  )
}

export default JavaScript