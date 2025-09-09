/*
    DDL(DATA DEFINITION LANAGUAGE) : 데이터 정의어
    데이터 베이스에서 사용하는 SQL 명령어중 데이터를 저장할 객체의 구조를 정의하거나 변경하는 역활을 함.
    실제 데이터 값이 아닌 규칙 자체를 정의하는 언어.
    
    오라클에서 객체(구조) : 테이블, 뷰, 시퀀스, 패키지, 인덱스, 패키지 , 트리거, 프로시저, 함수, 사용자 등   
    
    
    객체를 생성(CREATE), 변경(ALTER), 사제(DROP)
*/

/*
    CREATE : 객체를 생성하는 구문
    
    1. 테이블 생성
    - 테이블 : 행과 열로 구성되는 가장 기본적인 데이터베이스 객체
                모든 데이터들은 테이블을 통해서 저장된다.
                (DBMS용어중 하나로 데이터를 일종의 표 형태로 표현한것.)
                
    [표현식]
    CREATE TABLE 테이블 명 (
        컬럼명 자료형(크기),
        컬럼명 자료형(크기),
        .
        .
        .
        
    )
    
    * 자료형
    - 숫자 (NUMBER)
    - 문자 (CHAR(BYTE) || VARCHAR2(BYTE))
        - CHAR : 최대 바이트가 2000 / 고정 길이
        - VARCHAR2 : 최대 바이트가 4000 / 가변길이
    - 날짜 (DATE)
    
*/

-- 회원에 대한 데이터를 담기위한 테이블 MEMBER
CREATE TABLE MEMBER (
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(30),
    MEM_PWD VARCHAR2(30),
    MEM_NAME VARCHAR2(21),
    GENDER CHAR(3),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE
);



/*
    컬럼에 주석 달기
    
    [표현법]
    COMMENT ON COLUMN 테이블명.컬럼 IS '주석 내용';
*/

COMMENT ON COLUMN MEMBER.MEM_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEM_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.MEM_PWD IS '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEM_NAME IS '회원명';
COMMENT ON COLUMN MEMBER.PHONE IS '전화번호';
COMMENT ON COLUMN MEMBER.EMAIL IS '이메일';
COMMENT ON COLUMN MEMBER.GENDER IS '성별';
COMMENT ON COLUMN MEMBER.CREATE_AT IS '생성날짜';


INSERT INTO MEMBER 
VALUES (1,'USER01','PASS01','홍길동','남','010-1111-2222','AAA@NAVER.COM','25/07/30');

SELECT * FROM MEMBER;


INSERT INTO MEMBER 
VALUES (1,'USER01','PASS01',NULL,NULL,'010-1111-2222',NULL,NULL);

/*
    제약 조건
    - 원하는 데이터값(유효햔 형식의 값)만 유지하기 위해서 특정 컬럼에 설정하는 제약
    - 데이터 무결성 보장을 목적으로 함 -> 데이터베이스에 저장된 데이터가 정확하고 일관되며 신뢰할수 있는 상태를 유지.
    
    종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY....
*/

/*
    NOT NULL : 절대 NULL이 들어오면 안되는 경우 사용.
    삽입/수정시 NULL값을 허용하지 않도록 제한
    
    <제약조건 부여 방식>
    1. 컬럼 레벨 제약조건
    CRAETE TABLE MEMBER(
        NAME VARCHAR2(30) NOT NULL
    )
    2. 테이블 레벨 제약조건
    CREATE TABLE MEMBER(
        NAME VARCHAR2(30),
        CONSTRAINT MEM_PK PRIMARY KEY(NAME)
    )
*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(30) NOT NULL,
    MEM_PWD VARCHAR2(30) NOT NULL,
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE
);

INSERT INTO MEMBER 
VALUES (1,'USER01','PASS01','홍길동',NULL,NULL,NULL,NULL);

INSERT INTO MEMBER 
VALUES (1,'USER01','PASS01','홍길동','남','010-1111-2222','AAA@NAVER.COM','25/07/30');

INSERT INTO MEMBER 
VALUES (1,NULL,'PASS01','홍길동',NULL,NULL,NULL,NULL);

-- 아이디가 중복되었음에도 추가됨.
/*
    UNIQUE
    해당 컬럼에 중복값이 들어가서는 안되는 경우 사용.
    컬럼값에 중복값을 제한하는 제약 조건.
    삽입/수정시 기존에 있는 데이터값중 중복값이 있을 경우 오류 발생
*/


CREATE TABLE MEMBER (
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(30) NOT NULL,
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE
    --UNIQUE(MEM_ID)
);

-- 제약조건 부여시 제약조건 명을 지정해주면 오류 구문에서 제약조건 확인이 쉽다

/*
    제약조건 부여시 함께 제약조건명을 부여
    컬럼 지정 방식
    CREATE TABLE 테이블명(
        컬럼명 자료형 CONSTRAINT 제약조건명 제약조건
    )
    테이블 레벨 방식
    CREATE TABLE 테이블명(
        컬럼명 자료형,
        CONSTRAINT 제약조건명 제약조건
    )
*/
DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
    MEM_ID VARCHAR2(30) CONSTRAINT MEMID_NT NOT NULL CONSTRAINT MEMID_UQ UNIQUE,
    MEM_PWD VARCHAR2(30) CONSTRAINT MEMPWD_NT NOT NULL,
    MEM_NAME VARCHAR2(21) CONSTRAINT MEMNAME_NT NOT NULL,
    GENDER CHAR(3) CHECK (GENDER IN ('남','여')),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    CONSTRAINT EMAIL_UQ UNIQUE(EMAIL)
    -- CHECK (GENDER IN('남','여'))
);

/*
    CHECK(조건식)
    해당 컬럼에 들어올수있는 값에 대한 조건을 제시
    데이터를 추가하거나 수정할때 조건식을 만족해야 정상적인 실행이 가능하다
*/


INSERT INTO MEMBER 
VALUES (1,'USER01','PASS01','홍길동',NULL,'010-1111-2222','AAA@NAVER.COM','25/07/30');

INSERT INTO MEMBER 
VALUES (1,'USER02','PASS02','홍길동','여','010-1111-2222','BBB@NAVER.COM','25/07/30');
-- CHECK 제약조건 때문에 남,여 이외 입력시 에러발생
-- NULL은 CHECK와 무관

/*
    PRIMARY KEY : 기본키
    테이블에서 각 행을 식별하기 위해 부여하는 제약조건 / 식별자 역활.
    
    EX) 회원번호, 학번, 부서코드, 주민등록 번호 등
    기본키 = UNOQUE + NOT NULL
    
    한테이블에 오직 한 개말 설정 가능
*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL CONSTRAINT MEMNO_PK PRIMARY KEY,
    MEM_ID VARCHAR2(30) CONSTRAINT MEMID_NT NOT NULL CONSTRAINT MEMID_UQ UNIQUE,
    MEM_PWD VARCHAR2(30) CONSTRAINT MEMPWD_NT NOT NULL,
    MEM_NAME VARCHAR2(21) CONSTRAINT MEMNAME_NT NOT NULL,
    GENDER CHAR(3) CHECK (GENDER IN ('남','여')),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    CONSTRAINT EMAIL_UQ UNIQUE(EMAIL)
    -- CHECK (GENDER IN('남','여'))
);

INSERT INTO MEMBER 
VALUES (1,'USER01','PASS01','홍길동',NULL,'010-1111-2222','AAA@NAVER.COM','25/07/30');

INSERT INTO MEMBER 
VALUES (1,'USER02','PASS02','홍길동',NULL,'010-1111-2222','AAA@NAVER.COM','25/07/30');
--기본키에 중복값/NULL을 담으려 할때 에러발생.

INSERT INTO MEMBER 
VALUES (2,'USER02','PASS02','홍길순',NULL,'010-1111-2222','BBB@NAVER.COM','25/07/30');

INSERT INTO MEMBER 
VALUES (3,'USER03','PASS03','홍길순',NULL,'010-1111-2222','CCC@NAVER.COM','25/07/30');

INSERT INTO MEMBER 
VALUES (4,'USER04','PASS04','홍길사',NULL,'010-1111-2222','DDD@NAVER.COM','25/07/30');


-- 복합키 : 두개의 컬럼을 동시에 하나의 PRIMARY KEY로 지정
CREATE TABLE TB_LIKE(
    MEM_NO NUMBER,
    PRODUCT_NAME VARCHAR2(50),
    LIKE_DATE DATE,
    PRIMARY KEY(MEM_NO,PRODUCT_NAME)
);

-- 회원(1,2,3,4)
-- 상품2개 (자전거,자전거2)
INSERT INTO TB_LIKE VALUES(1,'자전거A',SYSDATE);
INSERT INTO TB_LIKE VALUES(1,'자전거B',SYSDATE);
INSERT INTO TB_LIKE VALUES(1,'자전거A',SYSDATE);

-- 회원 등급에 대한 데이터를 보관하는 테이블
CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);


INSERT INTO MEM_GRADE VALUES(10,'일반회원');
INSERT INTO MEM_GRADE VALUES(20,'우수회원');
INSERT INTO MEM_GRADE VALUES(30,'특별회원');
INSERT INTO MEM_GRADE VALUES(40,'VIP회원');

SELECT * FROM MEM_GRADE;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(30) NOT NULL,
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3) CHECK (GENDER IN ('남','여')),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    GRADE_ID NUMBER
);

INSERT INTO MEM 
VALUES (1,'USER01','PASS01','홍길동',NULL,NULL,NULL,'25/07/30',40);

INSERT INTO MEM 
VALUES (2,'USER02','PASS01','홍길이',NULL,NULL,NULL,'25/07/30',50);

INSERT INTO MEM 
VALUES (3,'USER03','PASS03','홍길삼',NULL,NULL,NULL,'25/07/30',10);

INSERT INTO MEM 
VALUES (4,'USER04','PASS04','홍길사',NULL,NULL,NULL,'25/07/30',NULL);

/*
    FOREIGN KEY(외래키) 제약조건
    다른 테이블의 기본키 혹은 고유키를 참조하도록 설정하는 제약 조건
    -> 다른 테이블을 참조한다고 표현
    -> 대부분의 경우 FOREIGN KEY를 통해서 테이블간의 관계를 활성화 한다.
    
    컬럼 레벨방식
    컬럼명 자료형 REFERENCES 참조할 테이블명 [참조할 컬럼명]
*/

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(30) NOT NULL,
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3) CHECK (GENDER IN ('남','여')),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE)
);

-- MEM GRADE(부모테이블)  --|------<---MEM(자식테이블)
-- 부모 테이블 : 외래키로 참조되는 테이블
-- 자식 테이블 : 외래키를 통해 부모테이블을 참조하는 테이블
-- 1:N일경우 보통 N이 자식
DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;
--자식 테이블에서 10이라는 GRADE_ID를 사용중이라 삭제 불가

--자식 테이블에서 이미 사용하는 값이 있을경우 
--부모테이블로부터 무조건 삭제가 안되는 "삭제제한"옵션이 기본적으로 설정.

/*
    자식테이블 생성시 외래키 제약조건을 부여할때 삭제옵션 함께 지정 가능.
    *삭제 옵션: 부모테이블의 데이터 삭제시 그 데이터를 참조하고있는 자식 데이터를 어떻게 처리할 것 인가.
    
    -ON DELETE RESTRICTED(기본값): 삭제 제한 옵션,자식데이터로부터 쓰이는 부모데이터 삭제 X
    -ON DELETE SET NULL : 부모 데이터 삭제시 해당 데이터를 사용하고있는 자식데이터 값을 NULL로 변경
    -ON DELETE CASCADE : 부모 데이터 삭제시 해당 데이터를 사용하고있는 자식데이터 모두 삭제.
*/

DROP TABLE MEM;
--ON DELETE SET NULL
-- 부모 삭제시 자식데이터 NULL로 변경
CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(30) NOT NULL,
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3) CHECK (GENDER IN ('남','여')),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE SET NULL
);

INSERT INTO MEM 
VALUES (1,'USER01','PASS01','홍길동',NULL,NULL,NULL,'25/07/30',40);

INSERT INTO MEM 
VALUES (2,'USER02','PASS01','홍길이',NULL,NULL,NULL,'25/07/30',30);

INSERT INTO MEM 
VALUES (3,'USER03','PASS03','홍길삼',NULL,NULL,NULL,'25/07/30',10);

INSERT INTO MEM 
VALUES (4,'USER04','PASS04','홍길사',NULL,NULL,NULL,'25/07/30',NULL);


DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;

SELECT * FROM MEM;


DROP TABLE MEM;
--ON DELETE CASCADE
--부모 삭제시 자식 데이터 삭제 
CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(30) NOT NULL,
    MEM_NAME VARCHAR2(21) NOT NULL,
    GENDER CHAR(3) CHECK (GENDER IN ('남','여')),
    PHONE VARCHAR(13),
    EMAIL VARCHAR2(50),
    CREATE_AT DATE,
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE
);

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;

/*
    <DEFAULT> *제약 조건이 아니다
    컬럼을 선정하지 않고 INSERT시에 NULL이 아닌 기본값을 INSERT하고자한다.
    미리 값을 세팅해둘수 있음.
    
    컬럼형 자료형 DEFAULT 기본값
*/


DROP TABLE MEM;
--ON DELETE CASCADE
--부모 삭제시 자식 데이터 삭제 
CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(30) NOT NULL UNIQUE,
    MEM_AGE NUMBER,
    HOBBY VARCHAR2(20) DEFAULT '코딩',
    CREATE_AT DATE DEFAULT SYSDATE
);

INSERT INTO MEM VALUES(1,'USER1',20,'운동','20/01/01');
INSERT INTO MEM VALUES(2,'USER2',24,NULL,NULL);
INSERT INTO MEM VALUES(3,'USER3',27,DEFAULT,DEFAULT);

--INSERT INTO 테이블명 (컬럼1,컬럼2) VALUES(값1, 값2);

INSERT INTO MEM(MEM_NO,MEM_ID,MEM_AGE) VALUES(4,'USER4',27);
--선택되지 않은 컬럼은 기본적으로 NULL 부여
-- 다만 디폴트 값이 있다면 해당 값이 적용

SELECT * FROM MEM;
-------------------------------
-- 관리자 계정으로 계정 생성
CREATE USER C##KH IDENTIFIED BY KH;

GRANT CONNECT, RESOURCE TO C##KH;

ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

---KH계정으로 진행.
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE WHERE 1=0);
-- CREATE TABLE 테이블 AS SELECT 문
--AS뒤에 오는 SELECT문의 결과를 기반으로 테이블을 생성하겠다.
-- WHERE 1=0 데이터 없이 열만 복제


/*
    테이블이 생성된 후에 제약조건을 수정하는 법
    
    ALTER TABLE 테이블 명 변경할 내용
    
    제약조건 추가
    -PRIMARY KEY : ALTER TABLE 테이블 명 ADD [CONSTRAINT 제약조건명]RPIMARY KEY (컬럼명);
    -FOREIGN KEY : ALTER TABLE 테이블 명 ADD FOREIGN KEY (컬럼명); REFERENCES 참조할테이블명(컬럼명);
    -UNIQUE : ALTER TABLE 테이블 명 ADD UNIQUE(컬럼명);
    -CHECK : ALTER TABLE 테이블 명 ADD CHECK(컬럼에 대한 조건식);
    위에 제약조건을 제거하려면
    ALTER TABLE 테이블 명 DROP 제약조건 명;
    
    -NOT NULL : ALTER TABLE 테이블 명  MODIFY 컬럼명 NOT NULL;
                 ALTER TABLE 테이블 명  MODIFY 컬럼명 NULL;
*/

--EMPLOYEE_COPY 테이블에 PRIMARY KEY   제약 조건 추가
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);

--EMPLOYEE테이블에 DEPT_CODEDP  외래키제약조건을 추가(DEPT_ID 참조)
ALTER TABLE EMPLOYEE ADD CONSTRAINT DEPT_FK FOREIGN KEY (DEPT_CODE) REFERENCES DEPARTMENT;


