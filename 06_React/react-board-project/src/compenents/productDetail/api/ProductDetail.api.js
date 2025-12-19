import axios from "axios";

export const getProduct = (productId) => {
    return axios.get("/api/product/getProduct",{params: {productId} });
}

export const update = (updateInfo) => {
    return axios.put("/api/product/updateProduct",updateInfo);
}


export const deleteProduct = (productId) => {
    return axios.delete("/api/product/deleteProduct",{params: {productId} });
}

export const updateStatus = (userId,productId) => {
    return axios.patch("/api/product/updateStatus",null,{params: {userId,productId} });
}

export const addComment = (commentBoard) => {
    console.log(commentBoard);
    return axios.post("/api/comment/addComment",commentBoard);
}

export const deleteComment = (commentId) => {
    return axios.delete("/api/comment/deleteComment",{params: {commentId}});
}

export const getComment = (productId) => {
    return axios.get("/api/comment/getComment",{params: {productId}});
}

export const addFavorite = (favoriteBody) => {
    return axios.post("/api/product/addFavorite",favoriteBody);
}
