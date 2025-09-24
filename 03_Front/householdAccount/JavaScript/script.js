//======전역 변수
let accountDos = JSON.parse(localStorage.getItem("accountDos")) || [];
let kind = "plus";
let filterState = 'all';

//===DOM 요소

const accountInput = document.querySelectorAll(".account-input input");


const accountList = document.getElementById("account-list");

const accountBtn = document.querySelectorAll(".account-btn > button");

const filterBtns = document.querySelectorAll(".filter-button > button");

//===화면 실행 함수

function init() {
    render();
    bindEvent();
}
//클릭 이벤트
function bindEvent() {
    //추가 버튼
    const addBtn = document.getElementById("add-btn");
    addBtn.addEventListener('click',addAccount);

    //수입, 지출 버튼
    for (let actBtn of accountBtn) {
        actBtn.addEventListener('click', plusMinus);
    }

    //필터 버튼
    filterBtns.forEach(function(btn) {
        btn.addEventListener('click',function(ev) {
            setFilter(ev.target.dataset.filter);
        })
    })

}

//=====랜더링 요소
function render() {
    accountList.innerHTML = "";
    //필터 적용
    const getAccountDos = getFilteredActdos();
    //내역이 없는경우 초기화
    if (getAccountDos.length === 0) {
        emptyUi();
    } else {
        //내역 출력
        getAccountDos.forEach(function(actDo) {
            actItemRender(actDo);
        })
    }
    //금액 집계 표시
    accountSum();

}

//화면 비우기
function emptyUi() {
    const emptyEl = document.createElement("div")
    emptyEl.className = 'empty-state';
    emptyEl.innerHTML = '내역이 없습니다.';
    accountList.appendChild(emptyEl);
}

//리스트 추가
function actItemRender(actDo) {
    const actItem = document.createElement('li');
    actItem.className = 'accout-item';
    const spanClass = (actDo.kind === 'plus') ? 'item-plus' : 'item-minus';
    const sign = (actDo.kind === 'plus') ? '+' : '-';
    actItem.innerHTML = `<div>
                            <span class="account-date">${actDo.date}</span>
                            <span>${actDo.comment}</span>
                        </div>
                        <span class="${spanClass}">${sign}${actDo.price}원</span>
                        <button class="delete-btn">삭제</button>`



    //리스트 내 삭제 버튼
    const deleteBtn = actItem.querySelector(".delete-btn");
    deleteBtn.addEventListener('click', function() {
        deleteActdo(actDo.id);
    })

    

    accountList.appendChild(actItem);
}

//총 수입, 총 지출, 잔액
function accountSum() {
    const account = document.querySelectorAll('.account .sum');
    const sum = document.querySelector('.all-acount-sum');
    let plusAccount = 0;
    let minusAccount = 0;
    let sumAccount = 0;
    for (let acdo of accountDos) {

        if (acdo.kind === "plus") {
            plusAccount = plusAccount + parseInt(acdo.price.replaceAll(',',''));
        } else {
            minusAccount = minusAccount - parseInt(acdo.price.replaceAll(',',''));
        }

    }

    sumAccount = plusAccount + minusAccount;

    for (let act of account) {
        act.innerHTML ="";
        if (act.className === "all-plus sum") {
            act.innerHTML = plusAccount.toLocaleString()+"원";
        } else if(act.className === "all-minus sum") {
            act.innerHTML = minusAccount.toLocaleString()+"원";
        } else {
            act.innerHTML = sumAccount.toLocaleString()+"원";
        }
    }

    sum.innerHTML = "";
    sum.innerHTML += sumAccount.toLocaleString()+"원";


}


//==데이터 조작 함수
//필터링
function getFilteredActdos() {
    let filterActDos = [];

    if (filterState == 'plus') {
        filterActDos = filterDos('plus');
    } else if(filterState == 'minus') {
        filterActDos = filterDos('minus');
    } else {
        return accountDos;
    }

    return filterActDos;
}
//필터링
function filterDos(kind) {
    let filterActDos = [];
    for (let actdo of accountDos) {
            if(actdo.kind === kind) {
                filterActDos.push(actdo);
            }
        }
    return filterActDos;
}

//추가 버튼
function addAccount() {
    let text = "";
    let price = 0;
    for (let inputVal of accountInput) {
        if (inputVal.id === "account") {
            if (inputVal.value === '') {
                alert("금액을 입력해주세요.");
                return;
            }
            price = inputVal.value   
        }else {
            if (inputVal.value === '') {
                alert("내용을 입력해주세요.");
                return;
            }
            text = inputVal.value
        }

        inputVal.value = "";
        
    }
    const toDay = new Date();
    const day = toDay.getDate();
    const mon = toDay.getMonth() + 1;
    const year = toDay.getFullYear();


    const addDos = {
        id : Date.now(),
        date : year+ "년 "+ mon + "월 "+ day + "일",
        comment : text,
        price : parseInt(price).toLocaleString(),
        kind : kind
    }

    accountDos.push(addDos);
    saveAccountDos();
    
    //UI에 적용
    render();


}

//리스트내 데이터 삭제
function deleteActdo(id) {
    let newActdo = [];

    for (let acdo of accountDos) {
        if (acdo.id !== id) {
            newActdo.push(acdo);
        }
    }

    accountDos = newActdo;
    saveAccountDos();
    render();
}

//수입, 지출 버튼
function plusMinus() {

    for (let actBtn of accountBtn) {
        actBtn.className = (actBtn.className.indexOf('checked')) ? actBtn.className.replace(" checked","") : actBtn.className;
    }

    this.className = this.className + " checked";
    
    kind = (this.className === 'plus-btn' || this.className === 'plus-btn checked') ? "plus" : "minus";


}


//======필터 영역 함수
function setFilter(filter) {
    filterState = filter;

    
    filterBtns.forEach(function(btn) {
        btn.className = (btn.dataset.filter === filter ? "active" : "");
    }) 

    
    render();
}


//할일 목록을 로컬스트리지 영역에 저장
function saveAccountDos() {
    localStorage.setItem('accountDos',JSON.stringify(accountDos));
}



//=====================load 이벤트 함수===============

//html이 전부 로드되어 dom트리가 완성되면 실행
document.addEventListener('DOMContentLoaded' , init);