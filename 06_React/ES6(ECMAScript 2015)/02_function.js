// 함수 표현식

// 1. 기본 함수

function hello() {
    console.log("hello");
}

hello();

// js에서는 함수도 하나의 값(변수)으로 취급한다.
let _hello = hello;
console.log(_hello);
_hello();

// 2. 익명 함수
const printMsg =  function () {
    console.log("this is a function");
};

printMsg();

// 기본 함수는 호이스팅이 된다.
tmp();
function tmp() {
    console.log("나는 함수다")
}


tmp2();
let tmp2 = function() {
    console.log("나도 함수다")
}

// 기본값이 있는경우 뒤보단 앞에넣는것이 좋다.
// 함수의 기본 매개 변수
function greet(name = "방문자", msg = "안녕") {
    console.log(`${name}님 ${msg}`)
}

//js의 함수는 호출시 이름으로만 함수를 판단함.
greet("test","hello");
greet();

greet(null); // -> 개발자가 명시적으로 표현한 빈값
greet(undefined,"누구냐"); //-> 시스템이 정해준 빈값(개발자가 선언후 사용하지 않은 값)



// 기본값이 있는경우 뒤보단 앞에넣는것이 좋다.
function gree2(name = "방문자", msg) {
    console.log(`${name}님 ${msg}`)
}

greet2(undefined,"안녕");


// 2. 화살표 함수
function add1(a, b) {
    return a + b;
}

const add2 = (a, b) => {return a + b;}

// 함수의 구현부에 리턴값만 있다면 return 키워드와 {}를 생략 가능
const add3 = (a, b) => a+b;
// 매개변수가 한개라면 ()도 생략가능
const print = msg => console.log(msg);

//코드가 짧고 가독성이 좋다.

//this의 바인딩 차이
// 화살표 함수는 자신만의 this를 바인딩 하지 않는다.
const human1 = {
    name : "test",
    age : 55,
    info : function() {
        console.log(`안녕 나는 ${this.name}`)
        setTimeout(function() {
            console.log(`안녕 나는 ${this.name}`)

        }, 500)
    }
}

human1.info();

// Lexical scope
// 함수를 선언 위치에 따라 this가 결정되는 방식
const human2 = {
    name : "test2",
    age : 55,
    info : function() {
        console.log(`안녕 나는 ${this.name}`)
        setTimeout(() => {
            console.log(`안녕 나는 ${this.name}`)

        }, 500)
    }
}

human2.info();


// 3. 콜백 함수
// 특정 함수를 실행할때 실행하는 사람이 특정 기능을 완료한 후에 실행하고 싶은 코드를 정의하는 용도.

const run = (callBack) => {
    callBack();
}

run(() => {
    console.log("run 실행");
});