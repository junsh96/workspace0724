import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import JavaScript from './components/JavaScript'
import Style from './components/style'
import Product from './components/Product'
import styled from 'styled-components'

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`

const Th = styled.th`
  background-color: #8a8a8a;
  color: white;
  padding: 12px;
  border: 1px solid #afafaf;
`

const products = [
  {
    product_id : 1,
    product_name : "삼성 갤럭시 s25",
    price : 1000000,
    color: "블랙"
  },
  {
    product_id : 2,
    product_name : "삼성 갤럭시 s25 울트라",
    price : 1500000,
    color: "화이트"
  },
  {
    product_id : 3,
    product_name : "아이폰 17",
    price : 1005000,
    color: "민트"
  }
]


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/* <JavaScript/> */}
      {/* <Style/> */}
      <Table>
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
      </Table>
      
    </>
  )
}

export default App
