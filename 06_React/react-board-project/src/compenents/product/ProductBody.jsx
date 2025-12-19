import React from 'react'
import { useNavigate } from 'react-router-dom';
import { useProduct } from '../../context/ProductContext';
import { SellSpan } from '../../styled/Product.styled';
import { updateCount } from './api/Product.api';

const ProductBody = ({productList}) => {
    const navigate = useNavigate();
    //const {productUpdate} = useProduct();
    const productDetail = async() => {

        
        try {
            await updateCount(productList.id)
        } catch(e) {
            alert("존재하지 않는 게시물 입니다.")
            console.log(e);
        }
        
        //productUpdate(updateCount);


        navigate(`/productDetail/${productList.id}`)
    }

    return (
        <tr onClick={productDetail}>
            <td>{productList.no}</td>
            <td>
                {productList.title}
                {productList.status === "complete" && ( 
                        <SellSpan>
                            판매완료
                        </SellSpan>
                )}    
            </td>
            <td>{productList.userId}</td>
            <td>{productList.createDate}</td>
            <td>{productList.count}</td>
        </tr>
    )
}

export default ProductBody