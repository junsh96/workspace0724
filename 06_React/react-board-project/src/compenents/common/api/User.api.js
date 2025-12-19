import axios from "axios";

export const addUser = (joinUser) => {
    console.log(joinUser);
    return axios.post("/api/user/addUser",joinUser);
}

export const idCheck = (userId) => {
    console.log(userId);
    return axios.get("/api/user/idCheck",{params:{userId}});
}

export const loginUserById = (loginUserInfo) => {
    console.log(loginUserInfo);
    return axios.post("/api/user/login",loginUserInfo);
}