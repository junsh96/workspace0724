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

const ProductDetail = ({userUpdate}) => {
  const { value } = useProduct();
  const { users } = useUsers();
  const { productId } = useParams();
  const { toggleFavorite, getUserFavorites } = useFavoriteList();
  
  const selProduct = value.find(v => v.id === Number(productId));
  
  const { comments, commentAdd ,commentRemove } = useCommentList();
  const list = comments.filter(c => c.productId === Number(productId));

  if (!selProduct) return <div>존재하지 않는 상품입니다.</div>;
  const isFavorite = getUserFavorites(users.id).includes(selProduct.id);
  const isOwner = users.id === selProduct.userId;
  const isComplete = selProduct.status === "complete";

  return (
    <>

        
        <DetailContainer>
        <FavoriteWrapper>
            <button onClick={() => toggleFavorite(users.id, selProduct.id)}>
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
            <CommentWriter productId={selProduct.id} disabled={!users?.id || isComplete} commentAdd={commentAdd}/>
            <CommentList productId={selProduct.id} list={list} commentRemove={commentRemove}/>
        </div>
    </>

  );
};
export default ProductDetail;