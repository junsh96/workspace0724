//기존 콜백 함수
const getTest = (data, callback) => {
    console.log("서버로 값 전달")
    setTimeout(() => {
        console.log("서버에서 응답 도착")
        callback("성공")
    },1000)
} 

console.log("시작")
getTest({id:30}, (result) => {
    console.log(result)
    getTest({id:30}, (result) => {
        console.log(result)
        getTest({id:30}, (result) => {
            console.log(result)
        })
    })
})
console.log("끝")


const getTest2 = (data) => {
    return new Promise((resolve, reject) => {
        console.log("서버로 값 전달",data)
        setTimeout(() => {
            console.log("서버에서 응답 도착")
            callback("성공")
        },1000)
    })
} 

getTest2({id : 20})
    .then(result => {
        console.log(result)
        return getTest2({id : 21})
    })
    .then(result => {
        console.log(result)
    })
    .finally(() => {
        console.log("끝")
    })



const asyncTest = async () => {
    try {

        const result = await getTest2({id: 1})
        console.log("1",result);
        const result2 = await getTest2({id: 2})
        console.log("2",result2);
        const result3 = await getTest2({id: 3})
        console.log("3",result3);

    } catch(e) {
        console.log("에러")
    }

}