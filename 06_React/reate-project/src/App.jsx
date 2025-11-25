import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import JavaScript from './components/JavaScript'
import Style from './components/style'
import Product from './components/Product'
import styled from 'styled-components'
import Videos from './components/Videos'

const videoList = [
  {
    title: "TEST",
    channelName : "TEST",
    sumbnail : "",
    logo : "",
    views : "8.2만",
    date : "1개월전"
  },
  {
    title: "TEST",
    channelName : "TEST",
    sumbnail : "",
    logo : "",
    views : "8.2만",
    date : "1개월전"
  },
  {
    title: "TEST",
    channelName : "TEST",
    sumbnail : "",
    logo : "",
    views : "8.2만",
    date : "1개월전"
  },
  {
    title: "TEST",
    channelName : "TEST",
    sumbnail : "",
    logo : "",
    views : "8.2만",
    date : "1개월전"
  },
  {
    title: "TEST",
    channelName : "TEST",
    sumbnail : "",
    logo : "",
    views : "8.2만",
    date : "1개월전"
  },
  {
    title: "TEST",
    channelName : "TEST",
    sumbnail : "",
    logo : "",
    views : "8.2만",
    date : "1개월전"
  }
]

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/* <Hello/> */}
      {/* <Head type="h2"/> */}
      {/* <Head>
        <h3>무엇을 도와드릴까요?</h3>
      </Head> */}
      <Videos videoList={videoList}></Videos>
    </>
  )
}

export default App
