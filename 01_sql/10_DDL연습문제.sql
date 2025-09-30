-- 실습문제 --
-- 도서관리 프로그램을 만들기 위한 테이블들 만들기 --
-- 이때, 제약조건에 이름을 부여할 것
-- 각 컬럼에 주석 달기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER)
-- 컬럼 : PUB_NO (출판사 번호) - 기본키 (PUBLISHER_PK)
--        PUB_NAME (출판사명) - NOT NULL (PUBLISHER_NN)
--        PHONE (출판사 전화번호) - 제약조건 없음

-- 샘플 3개 정도 생성
CREATE TABLE TB_PUBLISHER(PUB_NO NUMBER PRIMARY KEY,
                            PUB_NAME VARCHAR(20) NOT NULL,
                            PHONE VARCHAR(20));
                            
INSERT INTO TB_PUBLISHER VALUES(1,'A출판사','010-1111-1111');
INSERT INTO TB_PUBLISHER VALUES(2,'B출판사','010-1111-2222');
INSERT INTO TB_PUBLISHER VALUES(3,'C출판사','010-1111-3333');
    
COMMENT ON COLUMN "TB_PUBLISHER"."PUB_NO" IS '출판사 번호';
COMMENT ON COLUMN "TB_PUBLISHER"."PUB_NAME" IS '출판사명';
COMMENT ON COLUMN "TB_PUBLISHER"."PHONE" IS '출판사 전화번호';
-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블(TB_BOOK)
-- 컬럼 : BK_NO (도서번호) - 기본키 (BOOK_PK)
--        BK_TITLE (도서명) - NOT NULL (BOOK__NN_TITLE)
--        BK_AUTHOR (저자명) - NOT NULL (BOOK__NN_AUTHOR)
--        BK_PRICE (가격) - 제약조건 없음
--        BK_PUB_NO (출판사 번호) - 외래키 (BOOK_FK), TB_PUBLISHER 테이블 참조
--                                 이때 참조하고 있는 부모데이터 삭제 시 자식데이터도 삭제되도록 옵션 지정

-- 샘플 5개 정도 생성
CREATE TABLE TB_BOOK (BK_NO NUMBER PRIMARY KEY,
                        BK_TITLE VARCHAR2(40) NOT NULL,
                        BK_AUTHOR VARCHAR2(10) NOT NULL,
                        BK_PRICE VARCHAR2(20),
                        BK_PUB_NO NUMBER REFERENCES TB_PUBLISHER(PUB_NO) ON DELETE CASCADE);
                        
INSERT INTO TB_BOOK VALUES(1,'책A','A작가','12000원',1);
INSERT INTO TB_BOOK VALUES(2,'책B','A작가','32000원',1);
INSERT INTO TB_BOOK VALUES(3,'책C','B작가','13000원',2);
INSERT INTO TB_BOOK VALUES(4,'책D','C작가','15000원',3);
INSERT INTO TB_BOOK VALUES(5,'책E','D작가','18000원',1);

COMMENT ON COLUMN "TB_BOOK"."BK_NO" IS '도서번호';
COMMENT ON COLUMN "TB_BOOK"."BK_TITLE" IS '도서명';
COMMENT ON COLUMN "TB_BOOK"."BK_AUTHOR" IS '저자명';
COMMENT ON COLUMN "TB_BOOK"."BK_PRICE" IS '가격';
COMMENT ON COLUMN "TB_BOOK"."BK_PUB_NO" IS '출판사 번호';
-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블(TB_MEMBER)
-- 컬럼 : MEMBER_NO (회원번호) - 기본키 (MEMBER_PK)
--        MEMBER_ID (아이디) - 중복금지 (MEMBER_UQ_ID)
--        MEMBER_PWD (비밀번호) - NOT NULL (MEMBER_NN_PWD)
--        MEMBER_NAME (회원명) - NOT NULL (MEMBER_NN_NAME)
--        GENDER (성별) - M 또는 F로 제한 (MEMBER_CK_GEN)
--        ADDRESS (주소) - 제약조건 없음
--        PHONE (연락처) - 제약조건 없음
--        STATUS (탈퇴여부) - 기본값 N, N 또는 Y만 허용 (MEMBER_CK_STA)
--        ENROLL_DATE (가입일) - 기본값 SYSDATE, NOT NULL (MEMBER_NN_EN)

-- 샘플 5개 정도 생성
CREATE TABLE TB_MEMBER(MEMBER_NO NUMBER PRIMARY KEY,
                        MEMBER_ID VARCHAR2(30) UNIQUE,
                        MEMBER_PWD VARCHAR2(30) NOT NULL,
                        MEMBER_NAME VARCHAR2(20) NOT NULL,
                        GENDER CHAR(5) CHECK(GENDER IN('M','F')),
                        ADDRESS VARCHAR2(50),
                        PHONE VARCHAR2(20),
                        STATUS CHAR(5)  DEFAULT 'N' CHECK(STATUS IN ('N','Y')),
                        ENROLL_DATE DATE DEFAULT SYSDATE NOT NULL
                        );

INSERT INTO TB_MEMBER VALUES(1,'ABCD','PWD123','멤버1','M','경기도 ㅇㅇ시 ㅇㅇ구','010-1111-1111','Y','20/01/14');
INSERT INTO TB_MEMBER VALUES(2,'DBCA','PWD23','멤버2','M','경기도 ㅇㅇ시 ㅇㅇ구','010-1111-2222','N',DEFAULT);
INSERT INTO TB_MEMBER VALUES(3,'ACDA','PWD13','멤버3','F','ㅇㅇ시 ㅇㅇ구','010-1111-3333','Y',DEFAULT);
INSERT INTO TB_MEMBER VALUES(4,'ADSA','PWD12','멤버4','M','강원도 ㅇㅇ시 ㅇㅇ구','010-1111-4444','Y',DEFAULT);
INSERT INTO TB_MEMBER VALUES(5,'WDA','PWD1234','멤버5','F','경상남도 ㅇㅇ군','010-1111-5555','N','19/08/23');

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_NO" IS '회원번호';
COMMENT ON COLUMN "TB_MEMBER"."MEMBER_ID" IS '아이디';
COMMENT ON COLUMN "TB_MEMBER"."MEMBER_PWD" IS '비밀번호';
COMMENT ON COLUMN "TB_MEMBER"."MEMBER_NAME" IS '회원명';
COMMENT ON COLUMN "TB_MEMBER"."GENDER" IS '성별';
COMMENT ON COLUMN "TB_MEMBER"."ADDRESS" IS '주소';
COMMENT ON COLUMN "TB_MEMBER"."PHONE" IS '연락처';
COMMENT ON COLUMN "TB_MEMBER"."STATUS" IS '탈퇴여부';
COMMENT ON COLUMN "TB_MEMBER"."ENROLL_DATE" IS '가입일';

SELECT * FROM TB_MEMBER;
-- 4. 어떤 회원이 어떤 도서를 대여했는지에 대한 대여목록 테이블(TB_RENT)
-- 컬럼 : RENT_NO (대여번호) - 기본키 (RENT_PK)
--        RENT_MEM_NO (대여회원번호) - 외래키 (RENT_FK_MEM), TB_MEMBER 참조
--                                     부모 데이터 삭제 시 자식데이터 값이 NULL이 되도록 지정
--        RENT_BOOK_NO (대여도서번호) - 외래키 (RENT_FK_BOOK), TB_BOOK 참조
--                                      부모 데이터 삭제 시 자식데이터 값이 NULL이 되도록 지정
--        RENT_DATE (대여일) - 기본값 SYSDATE

-- 샘플 3개 정도 생성
CREATE TABLE TB_RENT(RENT_NO NUMBER PRIMARY KEY,
                    RENT_MEM_NO NUMBER REFERENCES TB_MEMBER(MEMBER_NO) ON DELETE SET NULL,
                    RENT_BOOK_NO NUMBER REFERENCES TB_BOOK(BK_NO) ON DELETE SET NULL,
                    RENT_DATE DATE DEFAULT SYSDATE
                    );
                    
INSERT INTO TB_RENT VALUES(1,2,1,DEFAULT);
INSERT INTO TB_RENT VALUES(2,1,3,'24/07/09');
INSERT INTO TB_RENT VALUES(3,4,2,'25/06/26');

COMMENT ON COLUMN "TB_RENT"."RENT_NO" IS '대여번호';
COMMENT ON COLUMN "TB_RENT"."RENT_MEM_NO" IS '대여회원번호';
COMMENT ON COLUMN "TB_RENT"."RENT_BOOK_NO" IS '대여도서번호';
COMMENT ON COLUMN "TB_RENT"."RENT_DATE" IS '대여일';
-- 대여목록 조회
-- TB_RENT, TB_MEMBER, TB_BOOK 테이블을 JOIN하여 대여 정보를 조회
SELECT MEMBER_NO,MEMBER_ID,MEMBER_NAME,BK_TITLE,BK_PRICE
FROM TB_RENT
JOIN TB_MEMBER
ON RENT_MEM_NO = MEMBER_NO
JOIN TB_BOOK
ON RENT_BOOK_NO = BK_NO;
