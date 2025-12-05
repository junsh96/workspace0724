import React from 'react'
import useProductList from '../customHook/useProductList'
import ProductBody from './ProductBody';
import { Link } from 'react-router-dom';
import { useProduct } from '../context/ProductContext';
import { ProductTable, ProductWrapper, WriteButton } from './Product.styled';

const Product = () => {

    const {value} = useProduct();

    return (
        <>
        <ProductWrapper>
            <h2>상품 목록</h2>
        </ProductWrapper>
            <ProductTable>
                <thead>
                    <tr>
                        <th>게시글 번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    {value.map(v => <ProductBody key={v.id} productList={v} />)}
                </tbody>
            </ProductTable>
            <WriteButton>
                <Link to="/productEnroll">글쓰기</Link>
            </WriteButton>
        </>
    )
}

export default Product