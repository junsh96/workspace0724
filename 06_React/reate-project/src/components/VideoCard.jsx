import React from 'react'
import { Container, Thumbnail ,ChannelInfo} from './VideoCard.styled'

const VideoCard = ({video}) => {
  return (
    <Container>
        <Thumbnail 
            src={video.sumbnail}
            alt={video.title}
        />
        <div>
            <ChannelInfo>
            <img
                src={video.logo}
                alt={video.channelName}
            />
            <div>
                <h3>{video.title}</h3>
                <p>{video.channelName}</p>
                <p>{video.views} 조회수 | {video.date}</p>
            </div>
            </ChannelInfo>

        </div>
    </Container>
  )
}

export default VideoCard