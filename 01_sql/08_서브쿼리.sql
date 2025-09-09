/*
    <서브쿼리>
    하나의 SQL안에 포함된 다른 SELECT 문
    메인 SQL문을 위해서 보조역활을 하는 쿼리문
*/

-- 노옹철 사원과 같은 부서에 속한 사원들 전체 조회
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME ='노옹철');


--전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번 이름 직급 코드 급여
SELECT EMP_ID, EMP_NAME,JOB_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);


/*
    서브 쿼리 구문
    서브 쿼리를 수행한 결과값이 몇행, 몇열로 나오느냐에 따라 분류
    -- 단일 행 서브 쿼리: 서브 쿼리의 조회 결과값이 하나일때
    -- 다중 행 서브 쿼리: 서브 쿼리의 조회 결과값이 여러행일때(여러 행 한열)
    -- 다중 열 서브 쿼리: 서브 쿼리의 조회 결과값이 한행이지만 여러열일때
    -- 다중 행 다중 열 서브 쿼리: 서브쿼리의 조회 결과값이 여러행 여러 컬럼일때
    
    서브쿼리의 결과값에 따라서 서브쿼리 앞쪽에 연산자가 달라진다.  
*/

/*
    단일 행 서브 쿼리
    서브 쿼리 결과값이 한개일때
    
    일반적으로 비교연산자와 사용.
    <> = !=
*/

-- 전직원의 평균 급여보다 급여를 더 적게 받는 사원들의 사원명 직급 코드 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEE);
-- 최저 급여를 받는 사원의 사번 이름 급여 입사일
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);
-- 노옹철 사원의 급여보다 더 많이 받는 사원들의 사번 이름 부서명 급여
SELECT EMP_ID,EMP_NAME,DEPT_TITLE,SALARY
FROM EMPLOYEE
JOIN DEPARTMENT
ON DEPT_CODE = DEPT_ID
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME='노옹철');
-- 부서별 급여합이 가장 큰 부서의 부서 코드 급여합
SELECT DEPT_CODE ,SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) FROM EMPLOYEE GROUP BY DEPT_CODE );
-- 전지연 사원과 같은 부서의 사람들의 사번 사원명 전화번호 입사일 부서명 본인 제외

SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE,DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT
ON DEPT_CODE = DEPT_ID
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME='전지연')
AND EMP_NAME != '전지연';

/*
    2 다중행 서브 쿼리
    서브쿼리를 수행한 결과값이 여러 행일때 (컬럼은 한개)
    비교대상 IN : 여러개의 결과값중 한개라도 일치하는 값이 있는가
    , 비교대상 <,> ANY : 여러개의 값중 한개라도 비교연산을 만족하는가
    , 비교대상 <,> ALL : 여러개의 값모두가 비교연산을 만족하는가
*/

-- 유재식 또는 윤은해 사원과 같은 직급인 사원들의 사번 사원명 직급코드 급여 조회
SELECT EMP_ID , EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN(SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME IN ('유재식','윤은해'));

-- 대리 직급임에도 과장직급의 최소급여보다  더 많이 받는 사원들의 사번 이름 직급 급여
--대리 직급 포함
SELECT EMP_ID,EMP_NAME, JOB_NAME,SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리' 
AND SALARY > (SELECT MIN(SALARY) FROM EMPLOYEE JOIN JOB USING(JOB_CODE) WHERE JOB_NAME = '과장');

SELECT EMP_ID,EMP_NAME, JOB_NAME,SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리' 
AND SALARY > ANY (SELECT SALARY FROM EMPLOYEE JOIN JOB USING(JOB_CODE) WHERE JOB_NAME = '과장');

/*
    다중열 서브 쿼리
    결과값은 한 행이지만 나열된 컬럼수가 여러개일 경우 (두개이상의 컬럼)
*/

-- 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원 조회
-- 사원명 부서코드 직급코드 입사일
-- 튜플 비교 : 두개이상의 열(컬럼)을 조합해서 비교하는 방식
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE,JOB_CODE) = (SELECT DEPT_CODE,JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '하이유');

-- 박나라 사원과 같은 직급 코드, 같은 사수를 가지고 있는 사원들의 사번, 사원명, 직급 코드, 사수번호를 조회 - 박나라는 제외

SELECT EMP_ID,EMP_NAME,JOB_CODE,MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME='박나라')
AND EMP_NAME != '박나라';

/*
    다중행 다중열 서브 쿼리
    
    서브쿼리의 조회 결과값이 여러행 여러열일 경우
*/
-- 각 직급별 최소 급여를 받는 사원을 조회 사번 사원명 직급 코드 급여
SELECT EMP_ID, EMP_NAME, JOB_CODE,SALARY
FROM EMPLOYEE
WHERE (JOB_CODE,SALARY) IN (SELECT JOB_CODE,MIN(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE);

--각 부서별 최고 급여를 받는 사원들의 사번 사원명 부서코드 급여
SELECT EMP_ID, EMP_NAME,DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE,SALARY) IN (SELECT DEPT_CODE,MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE);

--각 부서별 급여 합계가 전체 급여 총합의 20% 보다 많은 부서의 부서명 부서별급여 합계 조회
SELECT DEPT_TITLE ,SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT
ON DEPT_CODE = DEPT_ID
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY)*0.2 FROM EMPLOYEE);

/*
    인라인 뷰
    FROM 절에 서브 쿼리를 작성한것
    서브쿼리에 수행 결과를 마치 테이블 처럼 사용.
*/

--사원들의 사번, 이름, 보너스 포함 연봉, 부서코드 조회
-- 보너스 포함 연봉이 NULL이면 안되고 3천만 이상만 조회
SELECT EMP_ID, EMP_NAME,(SALARY+(SALARY * NVL(BONUS,0)))*12, DEPT_CODE
FROM EMPLOYEE
WHERE (SALARY+(SALARY * NVL(BONUS,0)))*12 >= 30000000;

--연봉이 높은 순으로 5명만 조회
SELECT ROWNUM,EMP_ID, EMP_NAME,(SALARY+(SALARY * NVL(BONUS,0)))*12 AS 연봉, DEPT_CODE
FROM EMPLOYEE
WHERE (SALARY+(SALARY * NVL(BONUS,0)))*12 >= 30000000
ORDER BY 연봉 DESC;

-- ROWNUM : 오라클에서 기본적으로 제공해주는 컬럼 조회된 순서대로 1부터 부여 / 단, ROWNUM은 FROM 절에서 결정됨

-- 인라인뷰를 통해서 TOP-N분석 : 상위 몇개만 조회
-- 전직원중 급여가 가장 높은 5명
SELECT ROWNUM,EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;

SELECT EMP_NAME,SALARY
FROM (SELECT ROWNUM,EMP_NAME, SALARY
        FROM EMPLOYEE
        ORDER BY SALARY DESC)
WHERE ROWNUM < 6;

--가장 최근에 입사한 5명 급여 입사일  사원명

SELECT EMP_NAME,SALARY,HIRE_DATE
FROM (SELECT ROWNUM,EMP_NAME,SALARY,HIRE_DATE
        FROM EMPLOYEE
        ORDER BY HIRE_DATE DESC)
WHERE ROWNUM < 6;

-- 각 부서별 평균 급여가 높은 3개의 부서 조회
SELECT DEPT_TITLE,평균급여
FROM (SELECT DEPT_TITLE,SUM(SALARY) AS "평균급여" 
        FROM EMPLOYEE
        JOIN DEPARTMENT
        ON DEPT_CODE = DEPT_ID
        GROUP BY DEPT_TITLE
        ORDER BY "평균급여" DESC)
WHERE ROWNUM < 4;
-- 부서별 평균 급여가 270만원을 초과하는 부서들의 부서코드 부서별총급여합 부서별평균급여 부서별사원수 조회
SELECT DEPT_CODE,부서별총급여,부서별평균급여,부서별사원수
FROM (SELECT DEPT_CODE,SUM(SALARY) AS 부서별총급여,AVG(SALARY) AS 부서별평균급여,COUNT(*) AS 부서별사원수 
        FROM EMPLOYEE
        GROUP BY DEPT_CODE)
WHERE 부서별평균급여 > 2700000;
--