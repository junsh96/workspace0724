
📦 Resale REST API Server

중고 상품 거래 서비스를 위한 Spring Boot 기반 REST API 서버입니다.
회원, 상품, 댓글, 마이페이지 기능을 제공합니다.

🛠 기술 스택

Java 17

Spring Boot

Spring Web (REST)

Spring Data JPA

Hibernate

H2 / MySQL

Lombok

Jackson

📁 프로젝트 구조 (요약)
```
com.kh.resale
 ├─ controller
 │   ├─ dto
 │   │  ├─ request
 │   │  │ ├─ CommonRequest
 │   │  │ ├─ LoginUserRequest
 │   │  │ ├─ ProductRequest
 │   │  │ ├─ UserRequest
 │   │  ├─ response
 │   │  │ ├─ CommonResponse
 │   │  │ ├─ ProductResponse
 │   │  │ └─ UserResponse
 │   ├─ UserController
 │   ├─ ProductController
 │   ├─ CommentController
 │   └─ MyPageController
 │
 ├─ service
 │   ├─ UserServiceImpl
 │   ├─ ProductServiceImpl
 │   ├─ CommentServiceImpl
 │   └─ MyPageServiceImpl
 │
 ├─ repository
 │   ├─ UserRepository
 │   ├─ ProductRepository
 │   └─ CommentRepository
 │
 ├─ entity
 │   ├─ User
 │   ├─ Product
 │   └─ Comment
 │
 └─ controller/dto
     ├─ request
     └─ response
```
🌐 공통 API 규칙

Base URL

/api


요청/응답 형식

JSON (application/json)

인증

현재 버전은 세션/토큰 인증 미적용

프론트에서 userId 전달 방식 사용

💬주요 기능
1. 회원 관리
   └─ 로그인
   └─ 회원가입
2. 게시글 관리
   └─ 등록
   └─ 수정
   └─ 삭제
   └─ 판매 완료
   └─ 조회수 증가
3. 마이페이지
   └─ 내 정보
   └─ 내 게시글
   └─ 내 댓글

📌 향후 개선 예정
1. 찜(즐겨찾기) 기능 구현
2. 페이징 처리
3. 검색 기능 추가
4. css 정리
