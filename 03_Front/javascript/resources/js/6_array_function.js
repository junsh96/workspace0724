//자료형 / 목적에 따라 가장 간결하고 명확하게 구현하기 위한 다양한 반복문이 존재
//일기/변환/필터링/검색... 목적에 맞는 반복문을 골라 사용해야 가독성이 높아짐.

let members = [
    "aaa",
    "bbb",
    "ccc",
    "ddd",
    "eee",
    "fff"
]

console.log(members.push("ggg"));
console.log(members);

//원본영향 ㅇ
//splice(인덱스 ,몇개) -> 원본에서 특정 인덱스부터 n개를 잘라냄.
console.log(members.splice(1,3));
console.log(members);

//원본영향 x
//slice(인덱스, 마지막인덱스 -1) -> 원본에서 특정 인덱스부터 마지막인덱스 -1개를 추출
console.log(members.slice(0,3));
console.log(members);

members = [
    "aaa",
    "bbb",
    "ccc",
    "ddd",
    "eee",
    "fff"
]

//...배열 ... 객체 -> spread연산자
//배열이나 객체의 요소를 개별적으로 펼져서 복사하거나 전달할때 사용한다.

let members2 = [
    ...members,
    "ggg"
]

console.log(members2);

let choi = {
    name : "dd",
    age : 25,
    gender : "M"
};

//값을 수정할때
choi = {
    ...choi,
    gender : "W"
};

//값 추가.
choi = {
    ...choi,
    addreaa : "seoul"
}
//choi.gender = "W";

//비구조 할당
//배열이나 객체에서 값을 추출할때 개별변수에 할당해서 추출하는 문법.
members = [
    "aaa",
    "bbb",
    "ccc"
];

// const cho = members[0];
// const kim = members[1];
// const lee = members[2];

const [cho, lee, kim] = members;
console.log(cho,lee,kim);

choi = {
    name : "dd",
    age : 25,
    gender : "M"
};

const {name, age} = choi;
console.log(name);

// const userName = choi.name;
const {name: userName} = choi;
console.log(userName);

//join(구분자) -> 배열을 문자열로 변경해줌.
console.log(members.join());
console.log(members.join("/"));

//sort()
console.log(members2);
members2.sort(); // 오름차순
console.log(members2);
members2.reverse(); // 역순
console.log(members2);


const stdList = [
                {name : "ooo", java : 75, db: 80, front: 90},
                {name : "aaa", java : 60, db: 50, front: 60},
                {name : "bbb", java : 75, db: 70, front: 70},
                {name : "ccc", java : 80, db: 90, front: 65},
                {name : "ddd", java : 90, db: 75, front: 75},
                {name : "eee", java : 65, db: 85, front: 90}
            ]   


/**
 * 정렬 기준이 없을때는 직접 콜백 함수를 통해 정렬 기준을 전달 할수 있다.
 * 
 *  a,b를 비교
 *  1)a를 b보다 나중에 정렬하고 싶다면 0보다 큰수 반환
 *  2)a를 b보다 먼저 정렬하고 싶다면 0보다 작은수 반환
 *  3)원래 순서를 유지하고 싶다면 0 반환.
 */
stdList.sort(function(a,b) {
    return a.name > b.name ? 1 : -1; //오름차순
});

console.log(stdList);
 


//js의 반복문
for (let i=0; i<stdList.length; i++) {
    console.log(stdList[i]);
}

//for ..of
//배열 값 중심으로 순회한다. 가장 깔끔하며 인덱스가 필요없을때 사용한다.
console.log("===================for..of=====================");
for (const std of stdList) {
    console.log(std);
}

//for..in
//인덱스 중심으로 순회한다.
console.log("=====================for..if===========================")
for (const i in stdList) {
    console.log(stdList[i]);
}

//객체에 사용시 key를 전부 열거할수 있음.
const std = {name : "ooo", java : 75, db: 80, front: 90};
for (const key in std) {
    console.log(key);
}

//---------------배열의 고차 함수---------------------
//읽기 전용 + 새로운 배열/값을 반환 -> 불변성 유지를 위해 사용
//배열/객체.forEach(function(순차적요소1개 , 인덱스,전체배열))
console.log("===================forEach============================")
stdList.forEach(function(value,index,a) {
    console.log(value);
    console.log(index);
    console.log(a);
})