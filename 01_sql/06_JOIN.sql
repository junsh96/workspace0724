/*
    <JOIN>
    두개이상의 테이블에서 데이터를 조회하고자 할때 사용되는 구문
    
    조회 결과는 하나의 결과 (RESULT SET)을 반환 한다.
    
    관계형 데이터베이스에서는 최소한의 데이터를 각각의 테이블에 담고있음.
    (무작정 다 조회하는것이 아니라 각 테이블간 연결고리를 통해 데이터를 매칭시켜 조회)
    
    JOIN은 오라클 전용 구문 / ANSI 구문으로 나뉨
*/

SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;

SELECT DEPT_ID,DEPT_TITLE
FROM DEPARTMENT;

/*
    1. 등가 조인/ 내부조인 INNER JOIN
    연결시켜준 컬럼의 값이 일치하는 행들만 조회(일치하는 값이 없는 행은 조회 제외)
*/

--> 오라클 전용 구문
-- FROM 절에 조회하고자하는 테이블 나열
-- WHERE 절에 매칭시킬 컬럼에대한 조건을 제시
SELECT EMP_ID,EMP_NAME,DEPT_CODE,DEPT_TITLE
FROM EMPLOYEE,DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

--> AMSI 구문
-- FROM 절에 기준이 되는 테이블 하나만 기술.
-- JOIN절에 JOIN하고자 하는 테이블 기술 + 매칭시킬 컬럼에 대한 조건을 기술.

--1. 연결할 두 컬럼명이 다른 경우 JOIN ON을 사용하여 연결할 컬럼명을 명시적으로 연결.
SELECT EMP_ID,EMP_NAME,DEPT_CODE,B.DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT B
ON DEPT_CODE = B.DEPT_ID;

--2. 연결할 컬럼명이 동일할 경우
--전체 사원들의 사번, 사원명, 직급코드, 직급명
SELECT  A.EMP_ID, A.EMP_NAME, A.JOB_CODE, B.JOB_NAME
FROM EMPLOYEE A
JOIN JOB B
ON A.JOB_CODE = B.JOB_CODE;

--직급이 대리인 사원의 사번 사원 직급명 급여조회
SELECT A.EMP_ID,A.EMP_NAME,B.JOB_NAME,A.SALARY
FROM EMPLOYEE A
JOIN JOB B
ON A.JOB_CODE = B.JOB_CODE
WHERE B.JOB_NAME = '대리';

SELECT EMP_ID,EMP_NAME,JOB_NAME,SALARY
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리';

--1. 부서가 인사관리부인 사원들의 사번 이름 보너스
SELECT EMP_NAME,EMP_ID,BONUS
FROM EMPLOYEE
JOIN DEPARTMENT B
ON DEPT_CODE = B.DEPT_ID
WHERE B.DEPT_TITLE = '인사관리부';

--2. 부서와 지역테이블을 참고하여 전체 부서의 부서코드 부서명 지역코드 지역명
SELECT DEPT_ID,DEPT_TITLE,B.LOCAL_CODE,B.LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION B
ON LOCATION_ID = B.LOCAL_CODE;


--3. 보너스를 받는 사원의 사번, 사원명, 보너스 부서명
SELECT EMP_ID,EMP_NAME,BONUS,B.DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT B
ON DEPT_CODE = B.DEPT_ID
WHERE BONUS IS NOT NULL;

--4. 부서가 총무부가 아닌 사원들의 사원명 급여
SELECT EMP_NAME,SALARY
FROM EMPLOYEE
JOIN DEPARTMENT B
ON DEPT_CODE = B.DEPT_ID
WHERE B.DEPT_TITLE !='총무부';

/*
    2. 외부 조인 (OUTER JOIN) / 포괄 조인
    두 테이블간 JOIN이 일치하지 않는 행도 포함시켜 조회가능
    단, 반드시 LEFT,RIGHT를 지정해야한다(어떤 테이블을 기준으로 할것인가.
*/

-- 내부 조인과 비교
-- 사원명 부서명 급여 연봉
-- 부서배치를 받지 않은 사원은?
SELECT EMP_NAME, DEPT_TITLE, SALARY , SALARY *12
FROM EMPLOYEE
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

-- LEFT 두 테이블중 왼편에 기술된 테이블 기준으로 JOIN

SELECT EMP_NAME, DEPT_TITLE, SALARY , SALARY *12
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

SELECT EMP_NAME, DEPT_TITLE, SALARY , SALARY *12
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;
-- 오라클 RIGHT
SELECT EMP_NAME, DEPT_TITLE, SALARY , SALARY *12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- FULL [OUTER] JOIN : 두 테이블이 가진 모든 행을 조회할 수 있다.
SELECT EMP_NAME, DEPT_TITLE, SALARY , SALARY *12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

/*
    3. 비등가 조인
    매칭 시킬 컬럼에 대한 조건 작성시 "="을 사용하지 않는 구문
    
    범위(수치적 범위 기간적 범위)를 기반으로 조인을 구현할 때 사용.
*/

SELECT EMP_NAME,SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY >= MIN_SAL AND SALARY<=MAX_SAL);

/*
    4.자체 조인(SELF JOIN)
    같은 테이블을 한번더 조인하는 경우
    - 하나의 테이블에 서로다른 두개의 행을 비교해야하는 경우 사용
    - 동일한 테이블을 조인하는 것이기 때문에 별칭을 사용해서 구분.
*/
-- 전체사원의 사원사번, 사원명, 사수, 사원 부서코드
--            사수 사번 사수명 사수 부서코드 

SELECT A.EMP_ID AS 사원,A.EMP_NAME AS 사원명,A.DEPT_CODE AS 사원부서,
        B.EMP_ID AS 사수,B.EMP_NAME AS 사수명,B.DEPT_CODE AS 사수부서
FROM EMPLOYEE A
JOIN EMPLOYEE B 
ON A.MANAGER_ID = B.EMP_ID;

/*
    <다중 조인>
    2개이상의 테이블을 가지고 JOIN
*/

--사번 사원명 부서명 직급명
 SELECT EMP_ID , EMP_NAME, DEPT_TITLE,JOB_NAME
 FROM EMPLOYEE
 JOIN DEPARTMENT
 ON DEPT_CODE = DEPT_ID
 JOIN JOB USING(JOB_CODE);
 
 -- 사번 사원명 부서명 지역명
 SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
 FROM EMPLOYEE
 JOIN DEPARTMENT
 ON DEPT_CODE = DEPT_ID
 JOIN LOCATION
 ON LOCATION_ID = LOCAL_CODE;
 
 -- 사번 사원명 부서명 직급명 지역명 국가명 급여등급
SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME,LOCAL_NAME,NATIONAL_NAME,SAL_LEVEL
FROM EMPLOYEE
JOIN DEPARTMENT
ON DEPT_CODE = DEPT_ID
JOIN JOB USING (JOB_CODE)
JOIN LOCATION
ON LOCATION_ID = LOCAL_CODE
JOIN NATIONAL USING(NATIONAL_CODE)
JOIN SAL_GRADE ON SALARY BETWEEN MIN_SAL AND MAX_SAL;

/*
    내추럴 조인(NATURAL JOIN)
    두 테이블간에 공통된 컬럼이름을 기준으로 정해서 자동으로 조인하는 방식
    ON이나 USING 조건을 지정하지 않아도 두 테이블간 공통된 컬럼을 기반으로 조인
    
    동일한 컬럼명이 각 테이블에 존재하는 경우에만 정상적 조인 가능
*/

SELECT * FROM EMPLOYEE
NATURAL JOIN JOB;

SELECT EMP_ID,EMP_NAME,DEPT_CODE,B.DEPT_TITLE
FROM EMPLOYEE LEFT OUTER JOIN DEPARTMENT B
ON DEPT_CODE = B.DEPT_ID;