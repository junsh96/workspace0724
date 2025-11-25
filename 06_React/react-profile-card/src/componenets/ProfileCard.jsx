import React from 'react'
import { Td, Online,OnlineTd,OflineTd ,Ofline} from './ProfileCard.styled'

const ProfileCard = ({profile}) => {
    console.log(profile)
  return (
    <tr>
        <Td>{profile.name}</Td>
        <Td>{profile.age}</Td>
        {profile.isOnline ? <OnlineTd><Online/> 온라인 상태입니다.</OnlineTd> : <OflineTd><Ofline/> 오프라인 상태입니다.</OflineTd>} 
    </tr>

  )
}

export default ProfileCard