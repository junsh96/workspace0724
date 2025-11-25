import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProfileCard from './componenets/ProfileCard'
import { Table, Tbody, Th } from './componenets/ProfileCard.styled'

function App() {
  const [count, setCount] = useState(0)

  const profileCards = [
    {
      id : 1,
      name : "학생1",
      age : "19",
      isOnline : true
    },
    {
      id : 2,
      name : "학생2",
      age : "20",
      isOnline : false
    },
    {
      id : 3,
      name : "학생3",
      age : "19",
      isOnline : true
    },
    {
      id : 4,
      name : "학생4",
      age : "21",
      isOnline : true
    },
    {
      id : 5,
      name : "학생5",
      age : "25",
      isOnline : false
    },
    {
      id : 6,
      name : "학생6",
      age : "16",
      isOnline : true
    },
    {
      id : 7,
      name : "학생7",
      age : "24",
      isOnline : true
    },
    {
      id : 8,
      name : "학생8",
      age : "28",
      isOnline : true
    },
    {
      id : 9,
      name : "학생9",
      age : "28",
      isOnline : false
    },
    {
      id : 10,
      name : "학생10",
      age : "25",
      isOnline : true
    }
  ]

  return (
    <>
    <Table>
        <thead>
            <tr>
                <Th>이름</Th>
                <Th>나이</Th>
                <Th>온라인 여부</Th>
            </tr>
        </thead>
        <Tbody>
          {profileCards.map(p => <ProfileCard key={p.id} profile={p}/>)}
        </Tbody>
    </Table>
      
    </>
  )
}

export default App
