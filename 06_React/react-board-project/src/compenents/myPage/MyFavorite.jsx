import React from 'react'
import { useProduct } from '../../context/ProductContext';
import { useUsers } from '../../context/UserContext';
import useFavoriteList from '../../customHook/useFavoriteList';
import { ListItem, Section, SectionTitle, SellSpan } from '../../styled/MyPage.styled';
import { useNavigate } from 'react-router-dom';


const MyFavorite = () => {
    const { value: allProducts } = useProduct();
    const { users } = useUsers();
    const { getUserFavorites } = useFavoriteList();
    const navigate = useNavigate();

    const favoriteIds = getUserFavorites(users.id);

    const favoriteProducts = allProducts.filter(p => favoriteIds.includes(p.id)).slice(0, 5);
    console.log(favoriteProducts)
  return (
    <>
        <Section>
            <SectionTitle>찜 목록(5개)</SectionTitle>
            {favoriteProducts.length === 0 ? (
                <div>찜한 게시글이 없습니다.</div>
            ) : (
                favoriteProducts.map(p => (
                    <ListItem key={p.id}>
                        <span className='title' onClick={() => navigate(`/productDetail/${p.id}`)}>
                            {p.title}
                            {p.status === "complete" && <SellSpan>판매완료</SellSpan>}
                        </span>
                        <span className='date'>{p.createDate}</span>
                    </ListItem>
                ))
            )}
        </Section>
        
    </>
  )
}

export default MyFavorite