//1. for문
for (let i=0; i<5; i++) {
    console.log("for in i : ",i);
}

//2. while문
let j=0;
while(j < 5) {
    console.log("for in j : ", j);
    j++;
}

//3. do - while문
j=0;
do {
    console.log("for in j : ", j);
    j++;
} while(j < 5);

//4.for ... of
let fruits = ["사과", "배", "딸기", "바나나"];
for (const fruit of fruits) {
    console.log(fruit);
}

fruits = [{
    id : 1,
    name : "바나나",
    price : 2000
},
{
    id : 2,
    name : "사과",
    price : 2000
} , 
{
    id : 3,
    name : "배",
    price : 3000
}, 
{
    id : 4,
    name : "딸기",
    price : 3500
}];

for (const fruit of fruits) {
    console.log(fruit.id);
}

//4. for ...in
const apple = {
    id : 4,
    name : "사과",
    price : 3500
}

for (let k in apple) {
    console.log(apple[k]);
}

//5. forEach
// -배열 순회 전용 메서드
fruits.forEach((data,index) => {
    console.log(`forEach: ${index} -> ${data.name}`)
})

const numbers = [1,3,5,7,9];
//6. map()
//기존 배열을 가지고 새로운 배열을 만들고 싶을때 변형된 새로운 배열을 반환
// const squared = numbers.map(function(num) {
//     return num* num;
// });

//서버로 부터 받은 데이터를 통해서 대칭되는 ui를 만들어 낼때 사용.
//[1,9,25,49,81]
const squared = numbers.map((num) => num*num); //내부 함수의 리턴값을 통한 새로운 배열을 반환
console.log(`map의 결과 : ${squared}`);

//7. fillter()
//조건에 맞는 요소만 추출하고 싶을때 -> 조건에 맞는 값만 모아서 세로운 배열을 반환.
//서버로부터 데이터를 삭제하고 이를 ui 상태에 반영해 줄때 많이 사용함.
//[3,9]
const squared2 = numbers.filter((num) => num % 3 === 0); //내부 함수의 리턴값이 true인것만 모아서 반환
console.log(squared2)

//8. find()
//조건에 맞는 첫번째 요소만 추출하고 싶을 때 -> 조건에 맞는 값 하나만 출력
const squared3 = numbers.find((num) => num % 3 ===0);
console.log(squared3);

//9. some()
//하나라도 조건을 만족하면 true;
const hasSquared = numbers.some((num) => num % 3 ===0);
console.log(hasSquared);

//10. every()
//모두 조건이 일치해야.
const allSquared = numbers.every((num)=> num % 3 === 0);

//11. reduce()
//배열의 값을 누적하여 하나의 결과값 도출
//배열.reduce((누적값, 배열 요소) => {실행할 코드 return 누적값;}, 누적값의 초기값);

const result = numbers.reduce((sum,num) => {
    console.log(sum + " : " +num)
    sum.push(num);
    return sum;
}, 0);

console.log(result);


const stdList = [{
    name: "test",
    age : 17,
    score : 80
},
{
    name: "test2",
    age : 18,
    score : 70
},
{
    name: "test",
    age : 15,
    score : 60
}]

stdList.reduce((scoreMap, std) => {
    scoreMap[std.name] = std.score;
    return scoreMap;
}, {});