import axios from "axios";


export const findAll = () => {
    return axios.get("/api/product/findAll");
}

export const updateCount = (productId) => {
    return axios.patch("/api/product/updateCount",null,{params: {productId}});
}

