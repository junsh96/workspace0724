/*
    <함수(FUNCTION)>
    전달된 컬럼값을 읽어들여서 함수(기능)을 실행한 결과를 반환
    
    - 단일행 함수 : N개의 값을 읽어들여서 N개의 결과값을 리턴한다(매행마다 함수실행결과를 반환)
    - 그룹함수 : N개의 값을 읽어들여서 한개의 값을 리턴한다.(그룹을 지어 그룹별로 함수 실행 결과를 번환)
    
    >> SELECT 절에 단일행 함수와 그룹합수를 함께 사용할수 없다.
    결과 행의 갯수가 서로 다르기 때문.
    
    >> 함수를 사용할수있는 위치 : SELECT,WHERE,ORDER BY, GROUP BY, HAVING절
*/

-------------------------단일행
/*
    <문자 처리 함수>
    *LANGTH(컬럼 / 문자열) : 해당 문자열의 글자수 반환
    *LANGTHB(컬럼 / 문자열) : 해당 문자열의 바이트수 반환
    
    한글은 글자당  3BYTE
    영어,숫자,특수문자 글자당 1BYTE
*/

SELECT LENGTH('오라클'), LENGTHB('오라클') FROM DUAL;


/*
    INSTR
    문자열로 부터 특정문자의 시작위치를 찾아서 반화
    
    INSTR(컬럼 / '문자열' , '찾으려는 문자' ,[찾을 위치의 시작값]) -> NUMBER
*/

SELECT EMAIL, INSTR(EMAIL,'@') AS "@위치"
FROM EMPLOYEE;

/*
    SUBSTR
    문자열에서 특정 문자 추출
    [표현법]
    SUBSTR(컬럼/문자열 ,시작위치, 추출할 문자 갯수)_
*/

SELECT SUBSTR(EMP_NO,8,1) FROM EMPLOYEE;

-- 사원들중 여자 사원만 이름 주민번호 조회
SELECT EMP_NAME,EMP_NO FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8,1) IN ('2','4');

-- 이메일의 아이디 부분만 추출
SELECT SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)  FROM EMPLOYEE;

/*
    LPAD/RPAD
    문자열을 조회할때 통일감있게 정렬하는 함수
    
    [표현법]
    LPAD/RPAD(문자열, 반환할 문자열 길이,추가할 문자)
*/

SELECT EMP_NAME,LPAD(EMAIL,30) FROM EMPLOYEE;

--사원들의 사원명 , 주민번호 뒷자리 블러
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO,1,8),14,'X') FROM EMPLOYEE;


/*
    LTRIM/RTRIM
    문자열에서 특정 문잘르 제거한 나머지를 반환
    [표현법]
    LTRIM(컬럼 / 문자열 , [제거하려는 문자열])
    
    문자열의 왼쪽/오른쪽에서 제거하고자 하는 문자열을 찾아 제거한뒤 나머지 문자열 반환
*/


SELECT LTRIM('      K      H ') FROM DUAL; -- 앞에서 다른 문자가 나올때까지 공백 제거

SELECT LTRIM('123123K      H 123','123') FROM DUAL; -- 앞에서 다른 문자가 나올때까지 123제거

SELECT LTRIM('ACABACCAKHBA','ABC') FROM DUAL; -- 제거하고자 하는 문자는 문자열이아닌 문자들.

/*
    TRIM
    문자열의 앞/뒤 양쪽에 있는 지정한 문자들을 제거한 나머지 반환
    TRIM([LEADING | TRAILING | BOTH] 제거하고자 하는 문자열 FROM 문자열) 
*/

SELECT TRIM (BOTH ' ' FROM ' K   H ') FROM DUAL;

/*
    LOWER / UPPER / INITCAP
    LOWER : 모든 문자열 소문자 변환
    UPPER : 모든 문자열 대문자 변환
    INITCAP : 띄어쓰기기준 첫글자 마다 대문자로 변환
*/

/*
    CONCAT
    문자열 두개를 전달받아 하나로 합친후 반환
    REPLACE
    특정 문자열에서 특정부분을 다른 부분으로 교체
*/

/*
    ABS
    숫자의 절대값을 구하는 함수
    MOD
    두 수를 나눈 나머지 값을 반환.
    ROUND
    반올림 결과 반환
    CEIL
    올림 결과 반환
    TRUNNC, FLOOR
    버림 결과 반환
*/

/*
    SYSDATE 시스템의 현재 날짜 / 시간
    
    MONTHS_BETWEEN 두 날짜 사이의 개월 수
    
    ADD_MONTHS 특정 날짜에 개월수 추가
    
    NEXT_DAY(DATE, 요일(문자 | 숫자)) : 특정 날짜 이후 가장 가까운 요일의 날짜를 반환 
    1 : 일/ 7: 토
    
    LAST_DAY(DATE) 해당 월의 마지막 날짜 반환
    
    EXTRACT : 특정 날짜로부터 년|월|일 값만 추출 해서 반환
    EXTRACT(YEAR FROM DATE) 년도 추출
    EXTRACT(MONTH FROM DATE) 월 추출
    EXTRACT(DAY FROM DATE) 일 추출
*/

--사원 테이블에서 사원명 입사일 수습기간 종료일(입사일로부터 3개월뒤) 조회

SELECT EMP_NAME,HIRE_DATE,ADD_MONTHS(HIRE_DATE,3) FROM EMPLOYEE;

/*
    <형변환 함수>
    TO_CHAR : 숫자타입 또는 날짜타입 값을 문자타입으로 변환
    
*/

SELECT TO_CHAR(12,'99999') FROM DUAL; -- 9의 자리수 만큼 확보

SELECT TO_CHAR(12,'00000') FROM DUAL; -- 0의 자리수만큼 공간확보후 빈칸을 0으로 채움

SELECT TO_CHAR(2000000,'L9999999') FROM DUAL; -- 현재 설정된 나라의 로컬 화폐 단위
SELECT TO_CHAR(2000000,'9,999,999') FROM DUAL;

-- 날짜 -> 문자
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE,'HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'HH"시" MI"분" SS"초"') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'PM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD DAY DY DY HH:MI:SS') FROM DUAL;

SELECT TO_CHAR(SYSDATE,'YYYY"년"MM"월"DD"일" HH"시" MI"분" SS"초"') FROM DUAL;
--년 관련
SELECT TO_CHAR(SYSDATE,'YYYY') ,
        TO_CHAR(SYSDATE,'YEAR'),
        TO_CHAR(SYSDATE,'RRRR'),
        TO_CHAR(SYSDATE,'YY')
FROM DUAL;

SELECT TO_DATE('2025','YYYY') ,
        TO_DATE('25','RRRR'),
        TO_DATE('25','YY'),
        TO_DATE('60','RR'), -- 2자리 입력시 현재 세기를 기준으로 자동 보정
        TO_DATE('60','YY') -- YY 항상 입력 그대로 해석 -> 현재 년도를 반영
FROM DUAL;

--월 관련 
SELECT TO_CHAR(SYSDATE, 'MM'), 
        TO_CHAR(SYSDATE, 'MON'),
        TO_CHAR(SYSDATE, 'MONTH')
FROM DUAL;

--일 관련
SELECT TO_CHAR(SYSDATE, 'DDD'), -- 오늘이 올해의 몇번째 일인지 
        TO_CHAR(SYSDATE, 'DD'), -- 오늘 일자
        TO_CHAR(SYSDATE, 'D') -- 요일
FROM DUAL;


--요일을 나타내는 포맷
SELECT TO_CHAR(SYSDATE, 'D'), 
        TO_CHAR(SYSDATE, 'DAY'),
        TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

/*
    TO_DATE : 숫자 OR 문자 타입을 날짜 타입으로 변경
    
    
*/
SELECT TO_DATE(20100101) FROM DUAL;
SELECT TO_DATE(611218) FROM DUAL; -- 기본적으로 년도를 두자리만 입력시 RR 룰이 적용.

SELECT TO_DATE(051010) FROM DUAL;
SELECT TO_DATE('051010') FROM DUAL;

SELECT TO_DATE('20020505 120500','YYYYMMDD HH24MISS') FROM DUAL;

---------------------------------------------------------------

/*
    TO_NUMBER 문자타입의 데이터를 숫자타입으로 변환
*/

SELECT TO_NUMBER('12414124') FROM DUAL;

SELECT '1000'+'5000' FROM DUAL;

SELECT TO_NUMBER('100,000','999,999') FROM DUAL;

---------------------------------------------------------

/*
    NULL 처리 함수
*/
-- NVL 
SELECT EMP_NAME, BONUS, NVL(BONUS,0)
FROM EMPLOYEE;

--전사원의 이름, 보너스 포함 연봉 조회
SELECT EMP_NAME, (SALARY+(SALARY * NVL(BONUS,0))) * 12
FROM EMPLOYEE;

--NVL2(컬럼, 반환값1 , 반환값2)
--반환값1 : 해당 컬럼 값이 존재하면 보여줄 값
--반환값2 : 해당 컬럼 값이 존재하지 않으면 보여줄 값
SELECT EMP_NAME, BONUS, NVL2(BONUS,'O','X')
FROM EMPLOYEE;

--NULLIF(비교대상1 , 비교대상2)
--두 값이 일치하면 NULL 반환 일치 하지 않으면 비교대상 1 반환

/*
    [선택함수]
    DECODE(비교하고자하는 대상, 비교값1,결과값1,비교값2,결과값2....)
*/

SELECT EMP_ID, EMP_NAME,EMP_NO,
        DECODE(SUBSTR(EMP_NO,8,1),1,'남',2,'여','잘못입력') AS 성별
FROM EMPLOYEE;

--직원의 이름, 기존급여, 인상된 급여 조회(각 직급별 차등인상)
-- 직급 J7은 10%인상
-- 직급 j6은 15%인상
-- 직급 J5은 20%인상
-- 그 외 직급은 5%인상

SELECT EMP_NAME,SALARY AS 인상전,DECODE(JOB_CODE,'J7', SALARY*1.1,'J6',SALARY*1.15,'J5',SALARY*1.2,SALARY*1.05) AS 인상후 ,JOB_CODE
FROM EMPLOYEE;

-------------------------------------

/*
    CASE문
    SQL에서 조건에 따라 값을 분기하고 싶을 때 사용하는 구문
    
    [표현법]
    CASE 
        WHEN 조건1 THEN 결과1
        WHEN 조건2 THEN 결과2
        ELSE 기본값
    END
*/

SELECT EMP_NAME,SALARY,
    CASE 
        WHEN SALARY > 5000000 THEN '시니어'
        WHEN SALARY > 3500000 THEN '미들'
        ELSE '주니어'
    END
FROM EMPLOYEE;

---------------------------------------------------------------------------------------

--<그룹함수>
--1 SUM(숫자타입 컬럼) : 해당 컬럼값들의 총 합계를 구하는 함수
--직원들의 모든 급여의 합
SELECT SUM(SALARY) FROM EMPLOYEE;

-- 남자사원들의 총 급여
SELECT SUM(SALARY) FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('1','3');

-- 부서 코드가 D5인 부서 사람들의 총 연봉
SELECT SUM(SALARY) FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

--AVG(NUMBER) : 해당 컬럼값들의 평균

SELECT AVG(SALARY) FROM EMPLOYEE;

---MIN() 해당 컬럼값중 가장 작은 값.
SELECT MIN(EMP_NAME),MIN(SALARY),MIN(HIRE_DATE) FROM EMPLOYEE;

--MAX() 해당 컬럼값중 가장 큰 값.
SELECT MAX(EMP_NAME),MAX(SALARY),MAX(HIRE_DATE) FROM EMPLOYEE;

--COUNT 해당 조건에 맞는 행의 갯수
--COUNT(*)  조회된 모든 행의 갯수
--COUNT(컬럼) 제시한 컬럼값이 NULL이 아닌 갯수
--COUNT(DISTINCT 컬럼) 해당 컬럼값에서 중복을 제거한 후의 갯수

-- 전체 사원수
SELECT COUNT(*) FROM EMPLOYEE;
-- 여자 사원수
SELECT COUNT(*) FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('2','4');
-- 보너스를 받는 사원수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

SELECT COUNT(BONUS) 
FROM EMPLOYEE;

--현재 사원들이 몇개의 부서에 분포되어있는지.
SELECT COUNT(DISTINCT(DEPT_CODE)) FROM EMPLOYEE;

/*
    SELECT *      실행순서 3
    FROM 테이블   실행순서 1
    WHERE 조건    실행순서 2
    ORDER BY 정렬기준  실행순서 4
    
*/