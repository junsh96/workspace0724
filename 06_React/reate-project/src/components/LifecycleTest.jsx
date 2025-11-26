import React, { Component } from 'react'

/*
    class component
    state(필드 대체)를 가지고 있고 이를 수정할수 있다.
    생명주기에 따른 메서드를 사용할 수 있음.

    state값이 변경되면 리엑트는 변화를 감지하고 그에 맞게 컴포넌트를 리렌더링 한다.
    그래서 state값을 변경할 때는 state에 어떤 값을 직접 변경하는 것이 아닌
    this.setState라는 함수를 이용해서 완전히 새로운 state값을 넣어주어야 한다.

    react의 component 라이프사이클은 생성(mount) , 수정(update), 제거(unmount) 단계로 나누어 
    각 단계마다 componentDidMount, componentDidUpdate, componentWillUnMount 같은 메서드를 실행하여
    DOM을 조작하거나 리소스를 정리할 수 있는 기능이 있다. 
*/

class LifecycleTest extends Component {
    constructor(props) {
        super(props)
        this.state = {
            count : 0,
        }

        console.log("constructor : 컴포넌트의 생성자 호출");
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

    increment = () => {
        this.setState ({
            ...this.state,
            count : this.state.count +1
        })
    }

  render() {
    return (
      <div>
        <p>Count : {this.state.count}</p>
        <button onClick={this.increment}>1 증가</button>
      </div>
    )
  }
}

export default LifecycleTest