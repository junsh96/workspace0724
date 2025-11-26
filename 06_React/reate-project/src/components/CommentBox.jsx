import React, { Component } from 'react'
import Comment from './Comment'

const serverCommentData = [
    {
        id: 1,
        message: "Hello"
    },
    {
        id: 2,
        message: "How are you"
    },
    {
        id: 3,
        message: "I'm fine"
    }

]

export default class CommentBox extends Component {
    constructor(props) {
        super(props)

        this.state = {
            commentList : []
        }
    }
//CommentBox 화면 렌더링 순간
componentDidMount() {
    setInterval(() => {
        // this.setState({
        //     commentList : serverCommentData
        // })
        const {commentList} = this.state;
        if (commentList.length < serverCommentData.length) {
            const nextComment = serverCommentData[commentList.length];
            this.setState({
                commentList : [...commentList, nextComment]
            })
        } else {
            this.setState({
                commentList : []
            })
            
        }
    },3000)
}
render() {
    const {commentList} = this.state;
    return (
        <>
           {
                commentList.map(c =>
                    <Comment key={c.id} message={c.message}/>
                )
            }
        </>
  
    )
  }
}
