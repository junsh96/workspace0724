
/*
    테이블
    - 데이터베이스에서 데이터를 저장하는 기본 개념
    - 행과 열로 구성된 데이터 집합
    
    컬럼
    - 테이블 내의 각 데이터 속성을 정의하는 필드
    - 컬럼은 테이블에 저장할 때 속성 = 값으로 저장
    
    => 테이블은 여러 컬럼으로 구성되고 , 각 컬럼은 테이블이 표현하는 데이터의 세부적인 속성을 나타냄.
    <select>
    select 컬럼명 1,컬럼명 2..... from 테이블명
    [where 조건]
    [order by정렬 기준 [asc|desc] ]
*/


select * from job;

-- job테이블에서 직급 이름만 조회
select job_name from job;

--department 테이블 모든 정보 조회
select * from department;

--employee 테이블의 직원명, 이메일, 전화번호, 고용일 조회
select emp_name,email,phone,hire_date from employee;

--employee테이블의 이름, 연봉, 총수령액(보너스 포함), 실수령액(총수령액 - (연봉 *세금(3%)))
select emp_name, salary*12 AS 연봉,(salary + (salary*nvl(bonus,0)))*12 as 총수령액,((salary + (salary*nvl(bonus,0)))*12)-(salary *12*0.03) as 실수령액 from employee;

-- 데이터베이스에서 null 은 빈값을 의미.
-- 모든 연산에 null이 포함된 경우 , 결과는 null이 된다.


-- 사원명, 입사일, 근무일수를 employee에서 조회,
-- 데이터베이스에서는 날짜를 계산할때 덧셈 뺄셈이 가능하다.
-- 현재시간 - 입사일 = 근무시간
-- date - date 결과는 일로 표시.
-- sysdate : 오라클 now [년/월/일/시/분/초]
select emp_name, hire_date, sysdate - hire_date  from employee;

select emp_name, hire_date, sysdate from employee;
--dual 테이블은 오라클에서 제공하는 가상 테이블
select sysdate from dual;

/*
    <컬럼 별칭>
    컬럼명에 별칭을 부여하면 깔끔하게 표현할수 있다.
    [표현식]
    컬럼명 별칭/ 컬럼명 as 별칭 / 컬럼명 "별칭" / 컬럼명 as "별칭"
*/

select emp_name 사원명,salary as 급여,bonus "보너스", salary * 12 as "연봉" from employee;


/*
    <리터럴>
    직접 값을 나타내는 단위, 임의로 지정한 값.
*/
select emp_id,emp_name,salary,'원' from employee;


/*
    <연결 연산자 ||>
    여러 컬럼값들을 마치 하나의 컬럼처럼 연결할수있음.
*/
select emp_name || '님 급여는 ' || salary || '원' from employee;



/*
    <distinct>
    중복제거 - 컬럼에 표시된 값들을 한번씩만 조회 하고자 할때 사용.
*/
/* 실제로 사용되고 있는 직급목록*/
select job_code from employee;

select DISTINCT(job_code) from employee;

--실제로 사용되고있는 부서 목록
select DISTINCT(dept_code) from employee;

select emp_name,dept_code , job_code from employee;

--distinct는 한 명령어에서 한번만 사용가능.
--distinct는 항상 row데이터 전체에 대해서 중복을 제거한다.
select DISTINCT dept_code , job_code from employee;
-- 위처럼 사용시 dept_code , job_code 2개를 쌍으로 묶어서 중복을 제거한 값을 보여준다.

------------------------------------------------------------------------

/*
    <where 절>
    조회하고자하는 테이블로부터 특정 조건을 만족하는 데이터만 조회하고자 할 때 사용함.
    조건식에도 다양한 연산자를 사용할수 있음.
    
    [표현법]
    select 컬럼, 컬럼 ... from 테이블
    where 조건;
    
    >>비교연산자<<
    >,<,=>=,<= : 대소비교.
    = : 동일.
    != , ^=, <> : 동일x
*/

-- employee 테이블에서 부서코드가 D9인 사원들만 조회
select * from employee where dept_code='D9';

-- employee 테이블에서 부서코드가 D1인 사원들의 사원명, 급여, 부서코드 조회
select emp_name,salary,dept_code from employee where dept_code = 'D1';    

-- employee 테이블에서 부서코드가 D1이아닌 사원들의 사원명, 급여, 부서코드 조회
select emp_name,salary,dept_code from employee where dept_code != 'D1';

-- 월급이 400 이상인 사원들의 사원명, 부서코드, 급여 조회
select emp_name, salary, dept_code from employee where salary >= 4000000;

/*
    <and / or 연산자>
    조건을 여러개 연결할때 사용.
    [표현법]
    조건 a and 조건 b => 조건 a와 조건 b가 모두 만족하는 값만 참으로 한다.
    조건 a or 조건 b => 조건 a와 조건 b중 하나만 만족해도 참으로 한다.
    
    <between and>
    조건식에 사용되는 구문
    몇이상 몇이하인 범위에 대한 조건을 제시할 때 주로 사용하는 연산자(이상, 이하만 가능)
    [표현법]
    비교대상 컬럼 between and 하안값 and 상한값;
*/

-- 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
select emp_name, emp_id, salary from employee where salary >= 3500000 and salary <= 6000000;

select emp_name, emp_id, salary from employee where salary between 3500000 and 6000000;

-- not : 논리 부정연산자.
-- 컬럼명 앞 or between 앞에 선언 가능.

select emp_name, emp_id, salary from employee where not salary between 3500000 and 6000000;


--입사일이 90/1/1 이상 01/01/01 이하 사원 전체 조회
select * from employee where hire_date >= '90/01/01' and hire_date <= '01/01/01';

select * from employee where hire_date between '90/01/01' and '01/01/01';

-- null을 비교 연산 할때
select * from employee where bonus is null;

select * from employee where bonus is not null;
    
    
    
--------------------------------------------------------------------------------------------



/*
    <LIKE>
    비교하고자 하는 컬럼 값이 내가 제시한 특정 패턴에 만족할 경우 조회
    
    [표현법]
    비교할 대상 컬럼 LIKE '특정패턴';
    
    특정패턴을 제시할 때 사용하는 와일드카드라는 개념이 정의.
    1. '%' : 포함 문자 검색
    EX) 비교할 대상 컬럼 LIKE '문자%' : 비교할 대상컬럼 값 중에서 해당문자로 시작하는 값을 전부 조회.
        비교할 대상 컬럼 LIKE '%문자' : 비교할 대상컬럼 값 중에서 해당문자로 끝나는 값을 전부 조회.
        비교할 대상 컬럼 LIKE '%문자%' : 비교할 대상컬럼 값 중에서 해당문자를 포함한 값 전부 조회.
        
    2. '_' : 한글자를 대체 검색할때 사용.
    EX) 비교할 대상 컬럼 LIKE '_문자' : 비교할 대상 컬럼 값 문자 앞에 아무글자나 딱 한글자가 있는 값을 조회.
        비교할 대상 컬럼 LIKE '문자_' : 비교할 대상 컬럼 값 문자 뒤에 아무글자나 딱 한글자가 있는 값을 조회.
        비교할 대상 컬럼 LIKE '_문자_' : 비교할 대상 컬럼 값 문자 앞뒤에 아무글자나 딱 한글자가 있는 값을 조회.
        
        => 내가 원하는 형태로 문자수를 조절할수 있다.
*/

SELECT EMP_NAME, salary
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

SELECT EMP_NAME, salary
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전__';

-- 사원들중에서 전화번호가 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호 조회.
SELECT EMP_ID,EMP_NAME,PHONE FROM EMPLOYEE
WHERE PHONE LIKE '__1%';

-- 이메일 중 _앞에 글자가 3글자인 사원들의 사번, 이름 이메일 조회.
SELECT EMP_ID, EMP_NAME,EMAIL FROM EMPLOYEE
--WHERE EMAIL LIKE '____%'; -- => 와일드카드로 인식되어 사용 불가 / 와일드카드를 직접문자로 사용할경우 일반문자로 사용해야함.
-- ESCAPE OPTION 을 등록해서 나만의 탈출 문자를 사용할수 있음.
WHERE EMAIL LIKE '___/_%'ESCAPE '/';


/*
    <IN>
    WHERE절에 비교대상 컬럼값이 내가 제시한 목록중에 일치하는지 검사하는 문법
    
    [표현법]
    비교대상 컬럼 IN(1,2,3,4....)
    
*/

-- 부서코드가 D6이거나 D8이거나 D5인 부서원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D6','D8','D5');


/*
    <연산자 우선 순위>
    1. 산술 연산자
    2. 연결 연산자
    3. 비교 연산자
    4. IS NULL/ LIKE / IN
    5. BETWEEN
    6. NOT
    7. AND
    8. OR
*/


----------------실습--------------------------










-- 1. 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME,HIRE_DATE FROM EMPLOYEE
WHERE EMP_NAME LIKE'%연';
-- 2. 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호 조회
SELECT EMP_NAME,PHONE FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';
-- 3. 이름에 '하'가 포함되어있고 급여가 240만원 이상인 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%'
AND SALARY >= 2400000;
-- 4. 부서 테이블에서 해외영업부서인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID,DEPT_TITLE FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%';
-- 5. 사수(MANAGER)가 없고 부서배치도 받지 않은 사원들의 사원명,사번, 부서코드 조회
SELECT EMP_ID,EMP_NAME,DEPT_CODE FROM EMPLOYEE
WHERE MANAGER_ID IS NULL
AND DEPT_CODE IS NULL;
-- 6. 연봉(급여 * 12)가 3천 이상이고 보너스를 받지 않는 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS FROM EMPLOYEE
WHERE (SALARY * 12) > 30000000
AND BONUS IS NULL;
-- 7. 입사일이 '95/01/01'이상이고 부서배치를 받지 않은 사원들의 사번, 사원명, 입사일, 부서코드 조회.
SELECT EMP_ID,EMP_NAME,HIRE_DATE,DEPT_CODE FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01'
AND DEPT_CODE IS NULL;
-- 8. 급여가 200이상이고 500이하인 사원중 입사일이 '01/01/01'이상이고 보너스를 받지 않는 사원들의 사번, 사원명, 급여, 입사일,보너스 조회
SELECT EMP_ID,EMP_NAME,SALARY,HIRE_DATE,BONUS FROM EMPLOYEE
WHERE SALARY BETWEEN 2000000 AND 5000000
AND HIRE_DATE >= '01/01/01'
AND BONUS IS NULL;
-- 9. 보너스를 포함한 연봉((SALARY+(SALARY*BONUS))*12)가 NULL이 아니고 이름에 '하'가 포함된 사원들의 사번, 사원명,급여 , 보너스포함 연봉 조회.
SELECT EMP_ID,EMP_NAME,SALARY,(SALARY+(SALARY*BONUS))*12 FROM EMPLOYEE
WHERE ((SALARY+(SALARY*BONUS))*12) IS NOT NULL
AND EMP_NAME LIKE '%하%';




/*
    <ORDER BY절>
    데이터를 정렬하여 조회하기위한 구문.
    SELECT 절 가장 마지막에 작성, 실행순서 또한 가장 마지막.
    
    [표현법]
    SELECT 컬럼
    FROM 테이블
    WHERE
    ORDER BY 정렬기준 컬럼 |별칭| 컬럼순번 ASC/DESC NULLS FIRST | NULLS LAST
    
    - ASC : 오름차순 - > 기본값
    - DESC: 내림차순
    
    NULL은 기본적으로 가장 큰 값으로 분류하여 정렬. 
    
*/

SELECT *
FROM EMPLOYEE
--ORDER BY BONUS NULLS LAST;
ORDER BY BONUS DESC, SALARY ASC;
-- 정렬기준에 컬럼값이 동일할경우 그 다음차순을 위해서 여러개의 기준 컬럼을 제시할수 잇다.

-- 전 사원의 사원명, 연봉조회 (연봉기준 내림차순)
SELECT EMP_NAME, SALARY * 12 AS 연봉
FROM EMPLOYEE
ORDER BY 연봉 DESC;

