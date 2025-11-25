import React from 'react'
import styled from 'styled-components'
import VideoCard from './VideoCard'

const Container = styled.div`
    display: flex;
    justify-content: flex-start;
    gap: 16px;
`

const Videos = ({videosList}) => {
  console.log({videosList});
  return <Container>
    {videosList.map(v => <VideoCard key = {index} video={v}/>)}
  </Container>
}

export default Videos