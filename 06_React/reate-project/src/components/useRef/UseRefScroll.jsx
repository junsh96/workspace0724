import React, { useRef } from 'react'
import styled from 'styled-components'

const Nav = styled.nav`
    position: fixed;
    top: 0;
    background: #fff;
    width: 100%;
    z-index: 10;
`

const NavUl = styled.ul`
    display: flex;
    gap: 12px;
    list-style: none;
    padding: 12px;
    cursor: pointer;
`

const UseRefScroll = () => {
    const scrollRef = useRef({
        main: null,
        about : null,
        history : null
    })

    const count = useRef(0);

    const handleScrollView = (key) => {
        scrollRef.current[key]?.scrollIntoView({behavior : "smooth"})
    }

  return (
    <>
        <Nav>
            <NavUl>
                <li><button onClick={() => handleScrollView("main")}>메인페이지</button></li>
                <li><button onClick={() => handleScrollView("about")}>회사소개</button></li>
                <li><button onClick={() => handleScrollView("history")}>회사이력</button></li>
            </NavUl>
        </Nav>

        <div>
            <section ref={(el) => {scrollRef.current.main = el}}>
                <h1>메인페이지</h1>
                <p>
                    메인페이지메인페이지메인페이지메인페이지
                    메인페이지메인페이지메인페이지메인페이지
                    메인페이지메인페이지메인페이지메인페이지
                    메인페이지메인페이지메인페이지메인페이지
                    메인페이지메인페이지메인페이지메인페이지
                    메인페이지메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    v
                    메인페이지
                    메인페이지메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지
                    메인페이지


                </p>
            </section>
            <section ref={(el) => {scrollRef.current.about = el}}>
                <h1>회사 소개</h1>
                <p>
                    회사입니다.회사입니다.회사입니다.회사입니다.
                    회사입니다.
                    회사입니다.
                    회사입니다.
                    회사입니다.회사입니다.회사입니다.회사입니다.
                    회사입니다.회사입니다.회사입니다.회사입니다.
                    회사입니다.회사입니다.회사입니다.회사입니다.
                    회사입니다.회사입니다.회사입니다.회사입니다.
                    회사입니다.회사입니다.회사입니다.회사입니다.
                </p>
            </section>
            <section ref={(el) => {scrollRef.current.history = el}}>
                <h1>회사이력</h1>
                <p>
                    회사이력
                    회사이력회사이력회사이력회사이력
                    회사이력회사이력회사이력
                    회사이력회사이력회사이력
                    회사이력
                    회사이력
                    회사이력
                    회사이력
                    회사이력
                    회사이력회사이력
                    회사이력
                    회사이력
                    회사이력
                </p>
            </section>
        </div>
    </>
  )
}

export default UseRefScroll