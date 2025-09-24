/**
 * 클로저란?
 * 클로저는 함수와, 그 함수가 선언된 시점의 렉시컬 환경의 조합.
 * 즉, 내부 함수의 선언 시점에 외부 함수의 변수를 함께 저장해서 사용하는 것을 클로저.
 * 
 * 콜백/이벤트 핸들러/모듈패턴에서 핵심적인 역활을 함.
 */


function getCounter() {
    let count = 0;

    function increase() {
        count ++;
        return count;
    }

    return increase;
}

const run = getCounter();
console.log(run());

//count는 외부에서 직접 보이지 않지만 , increase()를 통해서 변경.
//run이 살아 있는 한 count가 메모리에 유지됨. -> 상태유지

function out(outVal) {
    function inner(innerVal) {
        console.log("out: ", outVal);
        console.log("inner : ", innerVal);
    }

    return inner;
}

const printer = out("외부함수");
printer("내부함수");
//outVal는 out함수의 실행이 끝난 뒤에도 inner함수가 기억.


//getCounter 실행시마다 새로운 렉시컬 환경이 만들어진다.
//run1, run2, run3은 완전히 독립된 상태값을 다진다.
let run1 = getCounter();
let run2 = getCounter();
let run3 = getCounter();

// console.log(run1());
// console.log(run1());
// console.log(run1());

// console.log(run2());
// console.log(run2());
// console.log(run2());

// console.log(run3());
// console.log(run3());
// console.log(run3());

function createStore(initial = 0) {
    let value = initial;

    return {
        get : function() {return value;},
        set : function(v) {value = v;},
        increase : function() {value ++; return value;}
    }
}

const store = createStore(10);
console.log(store.get());
store.increase();
store.set(100);
console.log(store.get());
// -> 외부에서 value에 직접 접근이 불가 / 메서드로만 조작.

function attachOnce(el, msg) {

    let clicked = false; //지역상태(클로저 생성)
    el.addEventListener("click",function() {
        if(clicked) return; //클릭한적 있는지?
        clicked = true; // 클로저에 있는 clicked -> true
        console.log(msg); //클릭시 하고싶은 동작을 수행.
    })

}

//el을 눌러도 처음 한번만 msg를 출력

