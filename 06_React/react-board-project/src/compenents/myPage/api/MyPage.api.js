import axios from "axios";

export const myInfo = (userId) => {
    console.log(userId);
    return axios.get("/api/myPage/myInfo",{params:{userId}});
}

export const myProduct = (userId) => {
    console.log(userId);
    return axios.get("/api/myPage/myProduct",{params:{userId}});
}

export const myComment = (userId) => {
    console.log(userId);
    return axios.get("/api/myPage/myComment",{params:{userId}});
}

