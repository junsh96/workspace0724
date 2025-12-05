# 🛒 React 중고 거래 게시판 프로젝트

React와 LocalStorage를 기반으로 한 **중고 거래 게시판 서비스**입니다.  
사용자는 회원가입·로그인 후 상품을 등록하고, 수정·삭제, 댓글 입력, 판매완료 처리 등을 할 수 있습니다.

<br>

## 📌 기술 스택 (Tech Stack)

| 분야 | 기술 |
|-----|------|
| Frontend | React(v18), React Router, Styled-Components |
| State & Data | Context API, Custom Hooks, LocalStorage |
| Build Tool | Vite |
| Etc | FileReader(Base64 이미지 처리), JavaScript |

<br>

## 📂 프로젝트 구조
```
src/
├── components/
│ ├── Header.jsx
│ ├── Header.styled.js
│ ├── Home.jsx
│ ├── Home.styled.js
│ ├── Login.jsx
│ ├── Login.styled.js
│ ├── Join.jsx
│ ├── Join.styled.js
│ ├── Product.jsx
│ ├── ProductBody.jsx
│ ├── Product.styled.js
│ ├── ProductEnroll.jsx
│ ├── ProductEnroll.styled.js
│ ├── ProductDetail.jsx
│ ├── ProductDetail.styled.js
│ ├── Comments.jsx
│ ├── Comments.styled.js
│ ├── MyPage.jsx
│ ├── MyPage.styled.js
│ └── NotFound.jsx
│
├── context/
│ ├── UserContext.jsx
│ └── ProductContext.jsx
│
├── customHook/
│ ├── useInput.jsx
│ ├── useBase64FileInput.jsx
│ ├── useProductList.jsx
│ ├── useUserList.jsx
│ └── useCommentList.jsx
│
└── App.jsx
```

<br>

## ✨ 주요 기능

### ✔ 회원 기능
- 회원가입/로그인(LocalStorage 기반)
- 로그인한 사용자 정보 Context에서 전역 관리
- 마이페이지에서 정보 확인 (작성 글/댓글/판매 금액)

### ✔ 상품 기능
- 상품 등록 (제목, 내용, 이미지, 가격)
- Base64 이미지 저장 및 미리보기
- 상품 수정/삭제 (등록자 본인만 가능)
- 조회 시 조회수 자동 증가
- 판매완료 버튼 (본인만 가능)
  - 판매완료 시 myPage 금액 자동 증가
  - 댓글 입력/수정 불가 처리

### ✔ 댓글 기능
- 상품별 댓글 등록
- 댓글 삭제 (작성자 본인만 가능)
- 판매완료된 글은 댓글 입력 비활성화

### ✔ UI / UX
- 전체 Styled-components 적용
- 상세/목록/입력 화면 디자인 반영
- Header에서 로그인 사용자 이름 및 메뉴 표시
- 로그인/회원가입 화면에서는 헤더 숨김 처리

<br>

## 🚀 실행 방법

npm run dev

http://localhost:5173 접속

📦 로컬 스토리지 사용 데이터
| Key | 설명 |
|-----|------|
| users | 전체 사용자 목록 |
| products | 등록된 상품 목록 |
| comments | 전체 댓글 목록  |
| loggedUser | 현재 로그인한 사용자 정보 |



📌 향후 개선 방향

게시글/댓글 페이징 기능

검색 기능(상품명/작성자)

다중 이미지 업로드 기능

전체적인 디자인 개선

localstorage용량 문제 개선

