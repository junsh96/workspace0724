/*
    <PL/SQL>
    오라클 DBMS에서 사용하는 절차적 SQL 확장 언어이다.
    일반 SQL의 단점을 보완해서 변수의 정의, 조건, 반복 등을 지원하며 다수의 SQL문을 한번에 실행 할수 있음.
    PL/SQL은 블록구조를 사용함.
    
    --PL/SQL 구조
    DECLARE  - 선택/선언부 : 변수,상수등을 선언.
    BRGIN    - 실행부 : SQL문 또는 제어문의 로직 기술.
    EXCEPTION - 선택/예외 처리부 : 오류 발생시 처리.
    END; - PL/SQL의 마지막에 기술
*/
--출력 활성화
SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO_ORACLE');
END;
/

/*
    1. DECLARE 선언부
    변수및 상수를 선언한느 공간
    일반타입,래퍼런스 타입,ROW타입
    DELCARE
        변수명 [CONSTANT] 자료형  [:=초기값]
*/

DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER :=3.14;
BEGIN
    EID := &번호;
    ENAME := &이름;
    
    DBMS_OUTPUT.PUT_LINE('EID:' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI' || PI);
END;
/

/*
    래퍼런스 타입 변수 : 어떤 테이블의 어떤 컬럼의 데이터타입을 참조해서 사용할지 정의
    
*/


DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    --EID := 800;
    --ENAME := '전수환';
    --SAL := 1000000;
    SELECT EMP_ID,EMP_NAME,SALARY FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('EID:' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL' || SAL);
END;
/

/*
    래퍼런스 타입 변수로 EID,ENAME,SAL,DTITLE을 선언하고
    각 자료형 EMPLOYEE(EMP_ID,EMP_NAME,JOB_CODE,SALARY), DEPARTMENT(DEPT_TITLE)을 참조하고
    사용자가 입력한 사번의 사번, 사원명, 직급코드,급여, 부서명 조회후 각 변수에 담아서 출력
*/

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    --EID := 800;
    --ENAME := '전수환';
    --SAL := 1000000;
    SELECT EMP_ID,EMP_NAME,JOB_CODE,SALARY,DEPT_TITLE
    INTO EID,ENAME,JCODE,SAL,DTITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT
    ON DEPT_CODE = DEPT_ID
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE(EID||','||ENAME||','||JCODE||','||SAL||','||DTITLE);
    --DBMS_OUTPUT.PUT_LINE('ENAME' || ENAME);
    --DBMS_OUTPUT.PUT_LINE('SAL' || SAL);
    --DBMS_OUTPUT.PUT_LINE('DTITLE' || DTITLE);
END;
/
/*
    ROW 타입 변수 선언
    --테이블의 한 행에 대한 모든 컬럼을 한번에 담을수있는 변수
    
    변수명 테이블명%ROWTYPE
*/

DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;

    DBMS_OUTPUT.PUT_LINE(E.EMP_ID||','||E.EMP_NAME||','||E.BONUS);
END;
/

/*
    BEGIN 실행부
    <조건문>
    1. 단일 IF
    IF 조건식 THEN 
        실행내용
    END IF;
*/
--입력받은 사번에 해당하는 사원의 사번 사원명 직급코드 보너스 급여 조회
-- 보너스를 받지 않는 사원입니다.
-- 보너스를 받지 않는 사원은 : XXX 출력
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    --EID := 800;
    --ENAME := '전수환';
    --SAL := 1000000;
    SELECT EMP_ID,EMP_NAME,JOB_CODE,SALARY,NVL(BONUS,0)
    INTO EID,ENAME,JCODE,SAL,BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE(EID||','||ENAME||','||JCODE||','||SAL||','||BONUS);
    --DBMS_OUTPUT.PUT_LINE('ENAME' || ENAME);
    --DBMS_OUTPUT.PUT_LINE('SAL' || SAL);
    --DBMS_OUTPUT.PUT_LINE('DTITLE' || DTITLE);
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다.');
    END IF;    
    
    IF BONUS !=0
        THEN DBMS_OUTPUT.PUT_LINE('보너스 :'||BONUS);
    END IF;
    
END;
/

/*
    IF-ELSE 조건식
    
    IF 조건식
        THEN 실행내용
    ELSE 
        실행내용
    END IF;
*/

--래퍼런스 변수 (EID,ENAME,DTITLE,NCODE)를 생성하고
--각 테이블에서  EMP_ID,EMP_NAME,DEPT_TITLE,NATIONAL_CODE참조
-- 사번 이름 부서명 근무국가 코드조회후 각 변수에 대입,
--NCODE 값이 KO인 경우 => TEAM =국내팀
--NCODE 값이 KO가 아닌경우 => TEAM = 해외 팀
--사번 이름 부서명 TEAM 출력
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE LOCATION.NATIONAL_CODE%TYPE;
    TEAM VARCHAR2(20);
BEGIN
    --EID := 800;
    --ENAME := '전수환';
    --SAL := 1000000;
    SELECT EMP_ID,EMP_NAME,DEPT_TITLE,NATIONAL_CODE
    INTO EID,ENAME,DTITLE,NCODE
    FROM EMPLOYEE
    JOIN DEPARTMENT
    ON DEPT_CODE= DEPT_ID
    JOIN LOCATION
    ON LOCATION_ID = LOCAL_CODE
    WHERE EMP_ID = &사번;
    
    IF NCODE = 'KO'
        THEN TEAM := '국내팀';
    ELSE
        TEAM := '해외팀';
    END IF;    
    DBMS_OUTPUT.PUT_LINE(EID||','||ENAME||','||DTITLE||','||'국내팀');
END;
/

/*
    IF-ELSE 조건식
    
    IF 조건식
        THEN 실행내용
    ELSE IF
        실행내용
    ELSE
        실행내용
    END IF;
*/

DECLARE
    SCORE NUMBER;
    GRADE VARCHAR2(20);
BEGIN
    SCORE :=&점수;
    
    IF SCORE >=90
        THEN GRADE := 'A';
    ELSIF SCORE >= 80
        THEN GRADE :='B';
    ELSIF SCORE >= 70
        THEN GRADE :='C';
    ELSIF SCORE >= 70
        THEN GRADE :='D';
    ELSIF SCORE >= 60
        THEN GRADE :='E';
    ELSE
        GRADE :='F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('당신의 점수는:'||SCORE||'이며 학점은'||GRADE||'입니다.');
END;
/

/*
    <반복문>
    1 BASIC LOOP문
    
    LOOP
        반복하고싶은 실행문
        *EXIT WHEN 탈출조건
    END LOOP;
    
    *탈출 조건은 조건식
    1) IF 조건식 THEN EXIT; END IF;
*/

DECLARE
    I NUMBER :=0;
BEGIN
    LOOP
        I := I+1;
        DBMS_OUTPUT.PUT_LINE(I);
        EXIT WHEN(I = 10);
    END LOOP;
END;
/

/*
    FOR LOOP문 /횟수가 정해진 반복문
    
    FOR 변수 IN [REVERSE] 초기값 ... 최종값
    LOOP
        반복할 코드
    END LOOP
*/

BEGIN
    FOR I IN 1..10
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/
DROP TABLE TEST;

CREATE TABLE TEST(
    TNO NUMBER PRIMARY KEY,
    TDATE DATE
);

BEGIN
    FOR I IN 1..100
    LOOP
        INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL,SYSDATE);
    END LOOP;
    
END;
/


/*
    WHILE LOOP문
    
    WHILE 반복문이 수행할 조건
    LOOP
        명령어
    END LOOP;
*/

DECLARE
    I NUMBER :=0;
BEGIN
    WHILE I < 10
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I :=I+1;
    END LOOP;
    
END;
/

/*
    예외 처리부
    예외 EXCEPTION : 실행중 발생하는 오류 
    EXCEPTION
        WHEN 예외명1 THEN 처리구문1
        WHEN 예외명2 THEN 처리구문2
        
    *시스템적으로 미리 처리해둔 예외  
    -NO_DATA_FOUND : SELECT 한 결과가 없을때
    -TOO_MANY_ROWS: SELECT한 결과가 여러행일 경우
    -ZERO_DIVIDE : 0으로 나눌 경우
    -DUP_VALUE_ON_INDEX: UNIQUE제약조건
*/  

--사용자가 입력한 수로 10을 나눗셈한 결과

DECLARE
    RESULT NUMBER;
BEGIN
    RESULT :=10/&숫자;
    DBMS_OUTPUT.PUT_LINE(RESULT);
EXCEPTION
    WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('나누기 연산자는 0으로 입력할수 없습니다.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('예외가 발생하였습니다.');
END;
/


