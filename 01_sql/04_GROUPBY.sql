/*
    <GROUP BY>
    그룹 기준을 제시할 수 있는  구문
    여러개의 값들을 하나의 그룹으로 묶어서 처리하는 목적으로 이용.
*/

-- 각 부서별 급여 총합
SELECT SUM(SALARY),DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 각 부서별 사원수
SELECT COUNT(*),DEPT_CODE 
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE,COUNT(*),SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;


-- GROUP BY 절에 함수식 사용가능
-- 남자사원과 여자사원 수
SELECT COUNT(*),DECODE(SUBSTR(EMP_NO,8,1),1,'남',2,'여')
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO,8,1);

-- GROUP BY 절에 여러 컬럼을 기술할 수 있음
-- 여러 컬럼을 기술하면 해당 여러 컬럼을 모두 하나의 기준으로 사용
SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

/*
    <HAVING>
    그룹에 대한 조건을 제시하는 구문(그룹 함수식을 가지고 조건을 만든다.)
*/
-- 각 부서별 평균 급여(부서코드, 평균 급여)
SELECT DEPT_CODE,ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 각 부서별 평균 급여가 300만원 이상인 부서들만 부서코드, 평균 급여 조회
-- 해당 코드는 WHERE절이 먼저 실행되기 때문에 먼저 300만원 밑인 사람들을 거른뒤 평균을 구하기 때문에 오류 발생.
SELECT DEPT_CODE,ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE;

SELECT DEPT_CODE,ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >=3000000;

-- 직급별 직급코드, 총 급여합(단, 직급별 총 급여합이 1000만원이상인 직급만 조회)
SELECT JOB_CODE , SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;
-- 보너스를 받는 직원이 없는 부서의 부서 코드
SELECT DEPT_CODE,COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

/*
    SELECT *              -- 5
    FROM 테이블            -- 1
    WHERE 조건식           -- 2
    GROUP BY 그룹기준 컬럼  -- 3
    HAVING 조건식          -- 4
    ORDER BY 정렬기준      -- 6
    (오라클X)LIMIT         -- 7
*/




