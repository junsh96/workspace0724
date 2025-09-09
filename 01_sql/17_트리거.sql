/*
    트리거
    특정테이블에 대해 INSERT UPDATE DELETE 와 같은 DML 이벤트가 발생했을때
    자동으로 실행되는 PL/SQL코드 블록
    
    EX : 회원 탈퇴시 기존 회원 테이블에 데이터를 DELETE하기전에 탈퇴회원을 저장하는 테이블에
    INSERT
    신고 횟수가 일정수를 넘으면 묵시적으로 해당 회원을 블랙리스트에 추가할때.
    
    트리거 특징
    사용자가 명시적으로 실행하지 않아도 자동 실행됨.
    데이터 무결성 로깅 자동처리에 유용.
    테이블 단위로 작성되며 트리거 대상은 테이블
    
    트리거 분류
    시점
    - BEFORE TRIGGER : 내가 지정한 테이블에 DML이벤트가 실행되기 전 동작.
    - AFTER TRIGGER : 내가 지정한 테이블에 DML이벤트가 실행된 후 동작.
    
    적용대상
    - 문장 트리거 : 이벤트가 발생한 SQL문에 대해 딱 한번만 트리거 실행(FOR EACH ROW없음)
    - 행 트리거 : 이벤트가 발생한 행 마다 실행(FOR EACH ROW필요)
    행트리거에는 변경 전/후 데이터 참조가능.
        - :OLD : 기존 행 데이터
        - :NEW : 새로 들어오는 데이터
        
    CREATE [OR REPLACE] TRIGGER 트리거명
    BEFORE | AFTER INSERT | UPDATE | DELETE
    ON 테이블 명
    BEGIN 
        실행할 내용
    [EXCEPTION ...] -- 예외처리
    END;
    /
*/

SET SERVEROUTPUT ON;

--EMPLOYEE테이블에 새로운 행이 추가될때마다 자동으로 신입사원님 안녕하세요 출력

CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원님 안녕하세요');
END;
/

INSERT INTO EMPLOYEE(EMP_ID,EMP_NAME,EMP_NO,JOB_CODE)
VALUES(301,'김지원','111111-1111111','J7');

-- 입출고에 대한 데이터 기록 될때마다 해당 상품에 대한 재고수량 수정
--상품 재고 테이블 / 입출고 기록 테이블

CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY,
    PNAME VARCHAR2(30) NOT NULL,
    BRAND VARCHAR2(30) NOT NULL,
    PRICE NUMBER,
    STOCK NUMBER DEFAULT 0
);

CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5;

INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL,'갤럭시S25','삼성',1500000,DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL,'아이폰16','애플',1300000,DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL,'샤오미','샤오미',1000000,DEFAULT);

CREATE TABLE TB_PRODERAL(
    DECODE NUMBER PRIMARY KEY,
    PCODE NUMBER REFERENCES TB_PRODUCT,
    PDATE DATE NOT NULL,
    AMOUNT NUMBER NOT NULL,
    STATUS CHAR(3) CHECK(STATUS IN ('IN','OUT'))
);

CREATE SEQUENCE SEQ_DECODE;

INSERT INTO TB_PRODERAL
VALUES(SEQ_DECODE.NEXTVAL,200,SYSDATE,10,'IN');

UPDATE TB_PRODUCT
SET STOCK = STOCK+ 10
WHERE PCODE = 200;

COMMIT;

--  상품이 입고시 상품 테이블에 업데이트 필요.

CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT
ON TB_PRODERAL
FOR EACH ROW
BEGIN
    IF(:NEW.STATUS = 'IN')
        THEN UPDATE TB_PRODUCT
                SET STOCK = STOCK+:NEW.AMOUNT
                WHERE PCODE = :NEW.PCODE;
    ELSE
        UPDATE TB_PRODUCT
            SET STOCK = STOCK-:NEW.AMOUNT
            WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

--210번상품 입고
INSERT INTO TB_PRODERAL
VALUES(SEQ_DECODE.NEXTVAL,210,SYSDATE,7,'IN');

SELECT * FROM TB_PRODERAL;