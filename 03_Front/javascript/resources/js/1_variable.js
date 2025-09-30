console.log("hello world!");
//브라우저의 개발자 콘솔 객체
//.log() console객체의 메서드중 하나로 메세지를 출력한다. 개발자도구의 콘솔영역에 표시.


/**
 * js의 변수
 * 1) var - 사용하지 않는다
 * 2) let
 * 3) const
 */
//js는 동적타입 언어
//변수의 타입을 명시적으로 지정하지 않고,  실행중에 값에 따라서 자동으로 타입이 결정.

var name = "ㅇㅇㅇ";
var age = 55;
var height = 100.3;
var isTrue = true;
console.log(name);

age = "오십";
var name = "ㅁㅁㅁ";
console.log(name);

/**
 * let은 var에서 같은 이름의 중복생성을 하지 못하게 막은 자료형
 * const 는 상수를 표현하기 위한 자료형
 */

let name2 = "ㅅㅅㅅ";

/**
 * js 네이밍 규칙
 * 
 * 변수이름
 * 1) 일반적으로 영어를 사용하며 문자와 숫자 모두 사용할수있다.
 * 2) 특수문자는 언더스코어(_)와 달러($)를 사용.
 * 3) 숫자로 시작하면 안됨.
 * 4) 키워드를 변수명으로 사용하면 안됨.
 * 
 * 일반적으로 변수명, 함수명 -> camelCase
 * class, id같은 속성명은 -> kebab-case
 * 
 */

/**
 * Data Type
 * 
 * 여섯개의 원시타입과 한개의 Object타입이 있다,
 * 
 * 1) Number
 * 2) String
 * 3) boolean
 * 4) undifined
 * 5) null
 * 6) Symbol
 * 7) Object
 *  - Function
 *  - Array
 *  - object
 *  ...
 */

//Number
const age2 = 55;
const temp = -10.5;
const pi= 3.14;
console.log(age2);
console.log(temp);
console.log(pi);
console.log(typeof age2);
console.log(typeof temp);
console.log(typeof pi);

console.log(Infinity)
console.log(typeof Infinity)

//string
const name3 = "ggg";
const age3 = 55;
console.log(typeof name3);
console.log(age3 == "55");
console.log(age3 === "55");

//boolean 타입
const isTrue2 = true;
const itFalse = false;
console.log(typeof isTrue2);

/**
 * undefined
 * 
 * 개발자가 직접 값을 초기화하지 않았을 때.
 * 즉, 변수는 선언하고 사용하지 않았을때 지정되는 깂. 
 */
let num2;
console.log(num2)
console.log(typeof num2)

/**
 * null
 * undefined와 동일하게 값이 없음을 표시
 * 다만 js에서는 개발자가 직접 명시적으로 없는 값이라 표기.
 */
let init = 10;
init = null;
console.log(init);

/**
 * Symbol타입
 * 
 * 유일무이한 값을 생성하는 타입.
 * 다른 원시값들과 다르게 Symbol함수를 호출해서 생성
 */
const tmp1 = '1';
const tmp2 = '1';
console.log(tmp1 === tmp2);

const symbol1 = Symbol('1');
const symbol2 = Symbol('1');
console.log(symbol1);
console.log(symbol2);

console.log(symbol1 === symbol2);

/**
 * Object - > 프로토타입체인의 최상위 object가 Object
 * Object 타입
 * 
 * 키 : 밸류
 * key : value -> map 구조
 * 
 * 
 * {
 *      element : input,
 *      type: text,
 *      style : color
 * }
 */

const test = {
    name: "ddd",
    age: 47,
    address:"서울",
    job: "test"
}

console.log(test.name);
test.age= 20;
console.log(test.age);

console.log(typeof test);

/**
 * Array 타입
 * 값을 리스트로 나열할 수 있는 타입
 */

const arr = ["초록","노랑"]
//push -> 타입에 상관없이 배열의 맨뒤에 값을 추가한다.
arr.push("빨강");
arr.push(50);

console.log(arr);
// pop -> 맨 마지막에 추가된 요소를 제거하고 반환한다.
console.log(arr.pop());
console.log(arr);

console.log(arr[0])
