import React from 'react'
import { useNavigate } from 'react-router-dom';
import { useProduct } from '../../context/ProductContext';
import { SellSpan } from '../../styled/Product.styled';

const ProductBody = ({productList}) => {
    const navigate = useNavigate();
    const {productUpdate} = useProduct();
    const productDetail = () => {

        const updateCount = {
            ...productList,
            count : productList.count + 1
        };

        productUpdate(updateCount);


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