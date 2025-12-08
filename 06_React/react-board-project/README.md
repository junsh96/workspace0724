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
│ ├── common/
│ │ ├── Header.jsx
│ │ └── NotFound.jsx
│ ├── home/
│ │ ├── HomeAction.jsx
│ │ ├── HomeBanner.jsx
│ │ └── HomeRecentProducts.jsx
│ ├── mypage
│ │ ├── MyCommentList.jsx
│ │ ├── MyFavorite.jsx
│ │ ├── MyInfo.jsx
│ │ └── MyProductList.jsx
│ ├── product
│ │ └── ProductBody.jsx
│ ├── prodcutDetail
│ │ ├── CommentList.jsx
│ │ ├── Comment.jsx
│ │ ├── CommentWriter.jsx
│ │ ├── ProductEditor.jsx
│ │ └── ProductViewer.jsx
├── context/
│ ├── UserContext.jsx
│ └── ProductContext.jsx
│
├── customHook/
│ ├── useInput.jsx
│ ├── useBase64FileInput.jsx
│ ├── useProductList.jsx
│ ├── useUserList.jsx
│ ├── useFavoriteList.jsx
│ └── useCommentList.jsx
├── p능

다중 이미지 업로드 기능

전체적인 디자인 개선

localstorage용량 문제 개선

