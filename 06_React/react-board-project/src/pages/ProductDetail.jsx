import { useParams } from "react-router-dom";
import CommentList from "../compenents/productDetail/CommentList";
import ProductEditor from "../compenents/productDetail/ProductEditor";
import ProductViewer from "../compenents/productDetail/ProductViewer";
import { useProduct } from "../context/ProductContext";
import { useUsers } from "../context/UserContext";
import { CommentForm, DetailContainer, FavoriteWrapper } from "../styled/ProductDetail.styled";
import CommentWriter from "../compenents/productDetail/CommentWriter";
import useCommentList from "../customHook/useCommentList";
import useFavoriteList from "../customHook/useFavoriteList";
import { getProduct,getComment,addFavorite } from "../compenents/productDetail/api/ProductDetail.api";
import { useEffect, useState } from "react";

const ProductDetail = ({userUpdate}) => {
  //const { value } = useProduct();
  const [selProduct, setProduct] = useState([]);
  const [selComment, setComment] = useState([]);
  const { users } = useUsers();
  const { productId } = useParams();
  const { toggleFavorites, getUserFavorites } = useFavoriteList();

  const toggleFavorite = async(e) => {
    e.preventDefault();
    const favoriteBody = {
        user_id : users.user_id,
        product_id : selProduct.id
    }
    try {
        await addFavorite(favoriteBody);
    } catch(e) {
        console.log(e);
    }
    
  }

  useEffect(() => {
    const fetchProduct = async () => {
        try {
            const res = await getProduct(Number(productId));
            setProduct(res.data);
        } catch (e) {
            console.error(e)
        }
    };
    fetchProduct();
  }, []);

  useEffect(() => {
    const fetchComment = async () => {
        if (!selProduct?.id) return;
        console.log("!@#!@#",selProduct);
        try {
            const res = await getComment(selProduct.id);
            setComment(res.data);
            console.log("TEST",selComment);
        } catch(e) {
            console.log(e);
        }
    };
    fetchComment();
  },[selProduct.id]);
  
  //const selProduct = value.find(v => v.id === Number(productId));
  
  const { comments, commentAdd ,commentRemove } = useCommentList();

  if (!selProduct) return <div>존재하지 않는 상품입니다.</div>;
  const isFavorite = getUserFavorites(users.user_id).includes(selProduct.id);
  const isOwner = users.user_id === selProduct.user_id;
  const isComplete = selProduct.status === "complete";

  return (
    <>

        
        <DetailContainer>
        <FavoriteWrapper>
            <button onClick={toggleFavorite}>
                {isFavorite ? "❤️ 찜" : "🤍 찜하기"}
            </button>
        </FavoriteWrapper>


        {isOwner && !isComplete ? (
            <ProductEditor product={selProduct} userUpdate={userUpdate} />
        ) : (
            <ProductViewer product={selProduct} />
        )}
        
        </DetailContainer>
        <div>
            <CommentWriter productId={selProduct.id} disabled={!users?.user_id || isComplete} setComment={setComment}/>
            <CommentList productId={selProduct.id} list={selComment} setComment={setComment}/>
        </div>
    </>

  );
};
export default ProductDetail;