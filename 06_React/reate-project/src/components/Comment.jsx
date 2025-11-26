import React, { Component } from 'react'
import styled from 'styled-components'

const Container = styled.div`
    border : 1px solid gray;
    display: flex;
`

export default class Comment extends Component {
constructor(props) {
    super(props)

    this.state = {}
}

    //컴포넌트가 마운트 되었을때 호출(찻 렌더링시)
    componentDidMount() {
        console.log("컴포넌트 마운트 완료")
    }

    componentDidUpdate(prevProps, preveState) {
        console.log("컴포넌트 업데이트")
        console.log(preveState)
    }

    componentWillUnmount() {
        console.log("컴포넌트 언마운트")
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("컴포넌트 업데이트 전")
        //업데이트 적용 유무 true시 업데이트
        return true;
    }


  render() {
    return (
     <Container>
        <span>{this.props.message}</span>
     </Container>
    )
  }
}
