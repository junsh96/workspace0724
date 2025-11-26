import React from 'react'
import { Td,OnOfTd,Status} from './ProfileCard.styled'

const ProfileCard = ({profile}) => {
  
  return (
    <tr>
        <Td>{profile.name}</Td>
        <Td>{profile.age}</Td>
        {profile.isOnline ? <OnOfTd color={"green"}><Status background={"green"}/> 온라인 상태입니다.</OnOfTd> : <OnOfTd color={"gray"}><Status background={"red"}/> 오프라인 상태입니다.</OnOfTd>} 
    </tr>

  )
}

export default ProfileCard