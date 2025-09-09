/*
    DQL(QUERY 데이터 질의어 ) : SELECT 
    DML(MANIPULATION 데이터 조작어) : INSERT , UPDATE , DELETE
    DDL(DEFINTION 데이터 정의어) : CREATE , ALTER, DROP
    DCL(CONTROL 데이터 제어어) : GRANT , REVOKE
    TCL(TRANSACTION 트랜잭션 제어어) : COMMIT , ROLLBACK
    
    <DML>
    데이터 조작어
    테이블 값을 삽입, 수정, 삭제하는 구문
*/

/*
    1. INSERT
    테이블에 새로운 행(ROW)을 추가하는 구문
    
    [표현식]
    1)INSERT INTO 테이블명 VALUES (값,값,값,)
    테이블의 모든 컬럼에 대한 값을 순서대로 제시해서 한 행을 INSERT 하고자 할때 사용.
    컬럼의 수와 순번을 지켜서 VALUES 값을 나열해야한다.
*/

SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE
VALUES(900,'김수민','880914-1234567','AAA@NAVER.COM','01000000000','D7','J7',4000000,0.2,200,SYSDATE,NULL,'N');

/*
    INSERT INTO 테이블명(컬럼,컬럼,컬럼..) VALUES(값, 값, 값)
    
    테이블에 내가 원하는 컬럼에만 INSERT 가능
    컬럼 값을 제시하지 않은 값은 기본적으로 NULL.
*/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME,EMP_NO,JOB_CODE,HIRE_DATE)
VALUES(901,'최수민','440701-234567','J7',SYSDATE);

/*
    3) INSERT INTO 테이블명 (서브 쿼리);
    VALUES에 직접 값을 명시하는 것이 아니라 대신 서브 쿼리로 조회된 값을 모두 INSERT 한다.
*/

CREATE TABLE EMP_01(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(20),
    DEPT_TITLE VARCHAR2(20)
);

INSERT INTO EMP_01(SELECT EMP_ID, EMP_NAME,DEPT_TITLE
                    FROM EMPLOYEE
                    LEFT JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID);
                    
SELECT * FROM EMP_01;

/*
    INSERT ALL
    두개 이상의 테이블에 각각 INSERT할때 사용되는 서브쿼리가 동일한 경우
*/

CREATE TABLE EMP_DEPT
AS(SELECT EMP_ID,EMP_NAME,DEPT_CODE,HIRE_DATE FROM EMPLOYEE WHERE 1=0);

CREATE TABLE EMP_MANGER
AS(SELECT EMP_ID,EMP_NAME,MANAGER_ID FROM EMPLOYEE WHERE 1=0);

--부서 코드가 D1인 사원들의 사번 이름 부서코드 입사일 사수사번 조회
SELECT EMP_ID,EMP_NAME,DEPT_CODE,HIRE_DATE,MANAGER_ID FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

/*
    [표현식]
    INSERT ALL
    INTO 테이블명 VALUES(컬럼)
    INTO 테이블2 VALUES(컬럼)
    서브쿼리;
*/

INSERT ALL
INTO EMP_DEPT VALUES(EMP_ID,EMP_NAME,DEPT_CODE,HIRE_DATE)
INTO EMP_MANGER VALUES(EMP_ID,EMP_NAME,MANAGER_ID)
(SELECT EMP_ID,EMP_NAME,DEPT_CODE,HIRE_DATE,MANAGER_ID FROM EMPLOYEE
WHERE DEPT_CODE = 'D1');

/*
    UPDATE
    테이블에 기록되어있는 기존의 데이터를 수정하는 구문
    
    [표현법]
    UPDATE 테이블명
    SET 컬럼 = 값,
        컬럼  = 값
    WHERE 조건식  
    
    WHERE절이 없으면 전체 행 수행
    UPDATE시에도 제약조건 확인
*/

CREATE TABLE DEPT_TABLE
AS (SELECT * FROM DEPARTMENT);

--D9 부서명을 전략기획팀으로 변경

UPDATE DEPT_TABLE
SET DEPT_TITLE = '전략기획팀'
WHERE DEPT_ID = 'D9';

SELECT * FROM DEPT_TABLE;

CREATE TABLE EMP_SALARY
AS (SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY,BONUS FROM EMPLOYEE);

-- 테이블에서 노옹철 사원의 급여를 100만원으로
UPDATE EMP_SALARY
SET SALARY = '1000000'
WHERE EMP_NAME = '노옹철';

--선동일 사원의 급여를 700만, 보너스를 0.2로
UPDATE EMP_SALARY
SET SALARY = '7000000',
    BONUS = '0.2'
WHERE EMP_NAME = '선동일';
--전체사원의 급여를 기존급여에서 10%인상
UPDATE EMP_SALARY
SET SALARY = SALARY+(SALARY*0.1);


SELECT * FROM EMP_SALARY;

/*
    서브 쿼리 사용
    UPDATE 테이블
    SET 컬럼 = 서브쿼리
    WHERE 서브쿼리 
*/

--방명수 사원의 급여와 보너스 값을 유재식 사원의 급여와 보너스 값으로 변경
UPDATE EMP_SALARY
SET SALARY = (SELECT SALARY FROM EMP_SALARY WHERE EMP_NAME = '유재식'),
    BONUS = (SELECT BONUS FROM EMP_SALARY WHERE EMP_NAME = '유재식')
WHERE EMP_NAME = '방명수';

--ASIA지역에서 근무하는 사원들의 보너스를 0.3으로변경
UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE DEPT_CODE IN (SELECT DEPT_ID FROM DEPARTMENT JOIN LOCATION ON LOCATION_ID = LOCAL_CODE WHERE LOCAL_NAME LIKE 'ASIA%');


SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;




/*
    DELETE
    테이블에 기록된 데이터를 삭제하는 구문(한 행 단위로 삭제)
    
    [표현식]
    DELETE FROM 테이블
    WHERE  조건
    
    조건 미입력시 전체 삭제
*/

--
DELETE FROM EMPLOYEE;

ROLLBACK;

DELETE FROM EMPLOYEE
WHERE EMP_NAME = '김수민';

DELETE FROM EMPLOYEE
WHERE EMP_ID = '901';

