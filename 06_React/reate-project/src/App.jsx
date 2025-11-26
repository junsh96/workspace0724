import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import JavaScript from './components/JavaScript'
import Style from './components/style'
import Product from './components/Product'
import styled from 'styled-components'
import LifecycleTest from './components/LifecycleTest'
import CommentBox from './components/CommentBox'


function App() {
  const [isView, setIsView] = useState(true)

  const toggleButton = () => {
    setIsView(!isView);
  }

  return (
    <>
      {/* <JavaScript/> */}
      {/* <Style/> */}
      {/* <Table>
        <thead>
          <tr>
            <Th>제품명</Th>
            <Th>가격</Th>
            <Th>색상</Th>
          </tr>
        </thead>
        <tbody>
          {products.map(p => <Product key={p.product_id} product={p}/>)}
        </tbody>
      </Table> */}
      {/* {isView && <LifecycleTest/>}
      <button onClick={toggleButton}>{isView ? "숨기기" : "보이기"}</button> */}
      
        <CommentBox/>

    </>
  )
}

export default App
