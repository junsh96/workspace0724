/*
        <DCL: 데이터 제어문>
        계정에 시스템 권한 또는 객체 접근 권한을 부여하거나 회수하는 구문.
        즉, 누가 어떤 객체에 무엇을 할 수 있는지를 통제함.
        
        > 시스템 권한 : DB객체생성, 사용자 생성권한 등 관리자 권한
        > 객체 접근 권한 : 테이블, 뷰, 시퀀스 등 객체에 접근할수있는 권한
        
        1) 사용자 생성
        CREATE USER 사용자명 IDENTIFIED BY 비밀번호;
        2) 권한부여
        GRAND 권한 (RESOURCE,CONNECT) TO 계정;
        3) 권한회수
        REVOKE 권한 TO 계정
        
        ORACLE은 기본적으로 사용자 생성 후 권한을 부여해야 로그인 및 객체 사용 가능
        
*/

SELECT * FROM ROLE_SYS_PRIVS;

/*
    <TCL: 트랜잭션 제어문>
    트랜잭션은 하나이상의 DML(INSERT, UPDATE,DELETE)문을 묶어서 하나의 논리적 작업 단위로 처리하는 개념.
    
    DML문 한개를 수행할 때 트랜잭션이 존재하지 않으면 트랜잭션을 만들어서 묶음.
                        트랜잭션이 존재하면 해당 트랜잭션에 작업을 묶어서 처리.
                        
                        
    COMMIT : 트랜잭션 확정 및 저장.
    ROLLBACK : 트랜잭션 취소 및 이전 상태로 복원.
    
    SAVEPOINT : 롤백용으로 중간지점 지정.
    ROLLBACK TO : 특정지점까지 복원.
    
    대부분은 AUTOCOMMIT이 설정되어 있어서 DML을 전달할 때마다 자동으로 커밋.
    
*/
-- 오토 커밋 여부 확인
SHOW AUTOCOMMIT;

--오토 커밋 설정
--SET AUTOCOMMIT ON /OFF;

DROP TABLE EMP_01;

CREATE TABLE EMP_01 AS(SELECT EMP_ID,EMP_NAME,DEPT_TITLE
                        FROM EMPLOYEE
                        JOIN DEPARTMENT
                        ON DEPT_CODE = DEPT_ID);
                        
SELECT * FROM EMP_01;

--사번이 200,201번인 사람 제거
DELETE FROM EMP_01
WHERE EMP_ID IN (200,201);

COMMIT;

ROLLBACK;

--사번이 217,216,214 제거
DELETE FROM EMP_01
WHERE EMP_ID IN (217,214,216);

SELECT * FROM EMP_01;

SAVEPOINT SP;

INSERT INTO EMP_01
VALUES (801,'김민규','기술지원부');

INSERT INTO EMP_01
VALUES (802,'정수빈','창업지원부');

COMMIT;

CREATE TABLE TEST(
    TID NUMBER
);

ROLLBACK;

SELECT * FROM TEST;

/*
    DDL문(CREATE,ALTER,DROP)을 수행 하는 순간 기존 트랜잭션은 무조건 COMMIT됨.
    즉, DDL문 수행 전 변경사항들이 있다면 정확하게 픽스하고 진행.
    
    ACID속성 : 트랜잭션에 일관성과 신뢰성을 보장하기 위해 지켜야 하는 4가지 핵심 속성
    A(AUTOMICTITY) 원자성 : 트랜잭션 내 작업은 모두 완료되거나 취소되어야 한다.
    C(CONSISTENCY) 일관성 : 트랜잭션 수행 전후에 DB상태가 항상 유효한 상태(제약조건 충족)이여야 한다.
    I(ISOLATION) 독립성 : 여러 트랜잭션이 동시에 실행되어도 서로 간섭없이 독립적으로 실행되어야 한다.
    D(DURABILITY) 지속성 : 트랜잭션이 COMMIT되면 그 결과는 시스템이 종료되고 영구적으로 보존되어야한다.
*/





SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;


--찾을 위치의 시작 값: 1, 순번: 1 -> 기본값


SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;

SELECT EMAIL
FROM EMPLOYEE;

SELECT LPAD(EMAIL, 30)
FROM EMPLOYEE;



SELECT LPAD(EMAIL, 30, '#')
FROM EMPLOYEE;

SELECT LTRIM('    K  H   ') FROM DUAL;

SELECT RTRIM('123123KH123', '123') FROM DUAL;


SELECT TRIM('    K  H   ') FROM DUAL;

SELECT TRIM(BOTH 'Z' FROM 'ZZZZZZK  HZZZ') FROM DUAL;

SELECT TRIM(LEADING 'Z' FROM 'ZZZZZZK  HZZZ') FROM DUAL;

SELECT TRIM(TRAILING 'Z' FROM 'ZZZZZZK  HZZZ') FROM DUAL;


SELECT LOWER('Welcome To My KH') FROM DUAL;


SELECT UPPER('Welcome To My KH') FROM DUAL;


SELECT INITCAP('welcome to my kh') FROM DUAL;

SELECT CONCAT('가나다', 'ABC') FROM DUAL;

SELECT '가나다' || 'ABC' FROM DUAL;

SELECT EMAIL, REPLACE(EMAIL, 'kh', 'hk')
FROM EMPLOYEE;

SELECT ABS(-10), ABS(-5.4) FROM DUAL;

SELECT MOD(10.9, 3) FROM DUAL;


SELECT ROUND(123.456) FROM DUAL; -- 기본차수는 소수점 첫번째 자리에서 반올림

SELECT ROUND(123.456, 1) FROM DUAL; --위치값이 양수로 증가할수록 소수점 뒤로 한칸씩 이동한다.

SELECT ROUND(123.456, -1) FROM DUAL; --위치값이 음수로 감소할수록 소수점 앞으로 한칸씩 이동한다.


SELECT CEIL(123.456) FROM DUAL;


SELECT TRUNC(123.456) FROM DUAL;

SELECT TRUNC(123.456, 1) FROM DUAL;

SELECT TRUNC(123.456, -1) FROM DUAL;



--SYSDATE : 시스템의 현재 날짜및 시간을 반환
SELECT SYSDATE FROM DUAL;

--MONTHS_BETWEEN : 두 날짜 사이의 개월 수
--사원들의 사원명, 입사일, 근무일수, 근무 개월 수
SELECT EMP_NAME, HIRE_DATE, FLOOR(SYSDATE - HIRE_DATE), CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
FROM EMPLOYEE;

--ADD_MONTHS : 특정 날짜에 개월수를 더한 값을 반환
SELECT ADD_MONTHS(SYSDATE, 7) FROM DUAL;

--사원테이블에서 사원명, 입사일, 수습기간 종료일(입사일로부터 3개월 뒤) 조회
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 3)
FROM EMPLOYEE;

--NEXT_DAY(DATE, 요일(문자 | 숫자)) : 특정 날짜 이후 가장 가까운 요일의 날짜를 반환
SELECT NEXT_DAY(SYSDATE, 2) FROM DUAL;
-- 1: 일 ~ 7 : 토
SELECT NEXT_DAY(SYSDATE, '토요일') FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;


--LAST_DAY(DATE) : 해당월의 마지막 날짜를 구해서 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

/*
    EXTRACT : 특정 날짜로부터 년|월|일 값만 추출해서 반환
    
    [표현법]
    EXTRACT(YEAR FROM DATE) : 연도만추출
    EXTRACT(MONTH FROM DATE) : 월만추출
    EXTRACT(DAY FROM DATE) : 일만추출
*/

--사원의 사원명, 입사년도, 입사월, 입사일 조회
SELECT EMP_NAME,
        EXTRACT(YEAR FROM HIRE_DATE) AS "입사년도",
        EXTRACT(MONTH FROM HIRE_DATE) AS "입사월",
        EXTRACT(DAY FROM HIRE_DATE) AS "입사일"
FROM EMPLOYEE;

