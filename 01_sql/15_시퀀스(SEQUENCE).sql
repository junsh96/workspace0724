/*
    시퀀스 SEQUENCE
    자동으로 숫자를 발생시켜주는 객체.
    주로 기본키로 사용되는 회원번호, 사원번호, 택배번호 등에 사용.
    시퀀스를 사용하면 중복없는 숫자값을 편리하게 관리할수 있음.
*/


/*
    시퀀스 객체 생성
    
    CREATE SQEUENCE 시퀀스 명
    [START WITH 시작숫자] -> 처음 발생시킬 시작값 / 기본값 1
    [INCREMENT BY 증가값] -> 증가값을 지정할수 있다 / 기본값 1
    [MAXVALUE 최대값] -> 최대값 /기본값 매우큼.
    [MINVALUE 최소값] -> 최소값 / 기본갑 1
    [CYCLE | NO CYCLE] -> 값 순환 여부 / 기본 순환X
    [CACHE | NO CACHE] -> 캐시 메모리 사용 여부 
    
    캐시 메모리 -> 미리 일정량의 값을 생성하여 메모리에 준비 -> 속도 향샹
    EX) CHCHE 20 -> 시퀀스를 미리 20개 만들어두고 필요할때 사용.
*/

CREATE SEQUENCE SEQ_TEST;

--현재 계정이 소유한 시퀀스 목록 확인
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPEQ
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

/*
    시퀀스 사용
    시퀀스명.NECTVAL : 다음 숫자 발생 INCREMENT만큼 증가
    시퀀스명.CURRVAL : 가장 최근에 발생한 값.
    CURRVAL : 최초사용시 오류 발생. -> NEXTVAL을 호충해야한다.
*/

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPEQ.CURRVAL FROM DUAL;

SELECT SEQ_EMPEQ.NEXTVAL FROM DUAL;

/*
    시퀀스 수정
    
    ALTER SEQUNCE 시퀀스명
    [INCREMENT BY 증가값] -> 증가값을 지정할수 있다 / 기본값 1
    [MAXVALUE 최대값] -> 최대값 /기본값 매우큼.
    [MINVALUE 최소값] -> 최소값 / 기본갑 1
    [CYCLE | NO CYCLE] -> 값 순환 여부 / 기본 순환X
    [CACHE 바이트수 | NO CACHE] -> 캐시 메모리 사용 여부 
    
    START는 변경 불가
*/

ALTER SEQUENCE SEQ_EMPEQ
INCREMENT BY 10
MAXVALUE 400;

INSERT INTO EMPLOYEE(EMP_ID,EMP_NAME,EMP_NO,JOB_CODE) VALUES(SEQ_EMPEQ.NEXTVAL,'최지구','12356-1111111','J7');


/*
    시퀀스 삭제
    DROP SEQUENCE 시퀀스명
*/

DROP SEQUENCE SEQ_TEST;




-- 사용자 계정 생성
CREATE USER c##TEST IDENTIFIED BY TEST;

-- 접속 권한 및 테이블 생성 권한 부여
GRANT CONNECT, RESOURCE TO c##TEST;

-- 테이블스페이스 설정
ALTER USER C##TEST DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
