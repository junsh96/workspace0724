import React from 'react'
import useInput from './useInput'

const MyInfo = () => {

    const name = useInput(''); // {value : value, onChange : onChange}
    const email = useInput('');

    const handleSubmit = (e) => {
        e.preventDefault();
        alert(`이름 : ${name.value}, 이메일 : ${email.value}`)
    }
  return (
    <form onSubmit={handleSubmit}>
        <input type="text" placeholder='이름...' value={name.value} onChange={name.onChange} />
        <input type="text" placeholder='이메일...' {...email} />  {/*객체안에 있는 값이 props로 전달 */}
        <button type="submit">제출</button>
    </form>
  )
}

export default MyInfo