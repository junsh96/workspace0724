//js의 함수 정의 -> function 함수명(매개 변수) {
//                    실행코드                      }
function test1() {
    console.log("test1 함수 실행");
}

//자바 스크립트는 함수를 변수에 할당할수있음.
function test2() {
    console.log("test2 함수 실행");
}

//입급객체, 1종객체/변수 -> 변수에 담을 수 있다. -> 함수에 인자 전달 가능. 함수 결과 반환.
//js에서 함수는 1종객체이기 때문에 위에 모든 게 가능.
//익명 함수 js에서 함수의 이름이 필수는 아니다.
//다만 호출시 이름이 필요하기 때문에 필요시 작성.
const test3 = function() {
    console.log("test3")
}

test1();
test2();

//js는 오버로딩을 지원하지 않는다. 매개변수의 갯수가 달라도 동일한 메소드로 인식한다.
let test4 = function(name) {
    //js의 함수는 기본적으로 arguments를 가지고 있음.
    console.log(arguments)
    console.log("test4");
    console.log(name);
}

test4();
test4("TEST");
test4("TEST",66,);
test4("TEST",66,"test");