import axios from "axios";

export const addProduct = (productBoard) => {
    console.log(productBoard);
    return axios.post("/api/product/addProduct",productBoard);
}