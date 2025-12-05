import React, { useEffect } from 'react'
import { useUsers } from '../context/UserContext';
import { useNavigate, useParams } from 'react-router-dom';
import useInput from '../customHook/useInput';
import useBase64FileInput from '../customHook/useBase64FileInput';
import { useProduct } from '../context/ProductContext';
import useCommentList from '../customHook/useCommentList';
import Comments from './Comments';
import { Btn, ButtonGroup, CommentBtn, CommentForm, CommentTextArea, DetailContainer, ImageBox, Input, Label, Section, SellSpan, TextArea } from './ProductDetail.styled';

const ProductDetail = ({userUpdate}) => {
    const navigate = useNavigate();
    //파일
    const { file, base64, preview, onChange, reset } = useBase64FileInput();
    //로그인한 유저
    const {users} = useUsers();
    //게시글 아이디
    const { productId } = useParams();

    const selProductId = Number(productId);

    //게시글 정보
    const {value, productRemove, productUpdate} = useProduct();
    const selectProduct = value.find(v=> v.id === selProductId);

    if (!selectProduct) {
        return <div>존재하지 않는 상품입니다.</div>;
    }
    //댓글
    const { comments, commentAdd, commentRemove } = useCommentList();
    const proComments = comments ? comments.filter(c=> c.productId === selectProduct.id) : [] ;

    const title = useInput('');
    const content = useInput('');
    const price = useInput('');
    const comment = useInput('');

    useEffect(() => {
        title.setValue(selectProduct.title);
        content.setValue(selectProduct.content);
        price.setValue(selectProduct.price);
    }, [selectProduct]);

    //판매 완료
    const proComplete = () => {
        const updatePro = {
            ...selectProduct,
            status : "complete"
        }

        const currentAmount = Number(users.amount || 0);
        const newPrice = Number(selectProduct.price || 0);
        console.log(currentAmount)
        console.log(newPrice)
        const updateAmount = {
            ...users,
            amount : currentAmount + newPrice
        }
        productUpdate(updatePro);
        userUpdate(updateAmount);
        alert("판매 처리가 완료되었습니다.");
        navigate("/productList");
        
    }

    //게시글 수정
    const proUpdate = (e) => {
        e.preventDefault();

        const updated = {
            ...selectProduct,
            title: title.value,
            price : price.value,
            content: content.value,
            image: base64 || selectProduct.image,
        };

        productUpdate(updated);
        alert("수정 완료되었습니다.");
        navigate("/productList");

    }

    //게시글 삭제
    const proDelete = () => {
        if (window.confirm("정말 삭제하시겠습니까?")) {
            productRemove(selectProduct);
            navigate("/productList");
        }
    }

    //댓글 등록
    const commetAdd = (e) => {
        e.preventDefault();
        if (!comment.value.trim()) {
            alert("댓글을 입력해주세요")
            return;
        }

        const commentData = {
            id : Date.now(),
            comment : comment.value,
            userId : users.id,
            productId : selectProduct.id
        }

        commentAdd(commentData);
        alert("댓글이 등록되었습니다.");
        comment.setValue("");
    }

    return (
        <>
            <DetailContainer>
                {users.id === selectProduct.userId && selectProduct.status !== "complete" ? 
                    <form onSubmit={proUpdate}>
                        <Section>
                            <Label>제목</Label>
                            <input type="text" {...title}/>
                        </Section>
                        <Section>
                            <Label>판매액</Label>
                            <input type="number" {...price}/>
                        </Section>
                        <Section>
                            <Label>내용</Label>
                            <TextArea  {...content} />
                        </Section>
                        <Section>
                            <Label>이미지</Label>
                            <input type="file" accept="image/*" onChange={onChange} />
                            {(preview || selectProduct.image) && (
                                <ImageBox>
                                    <img src={preview || selectProduct.image} width={150} />
                                </ImageBox>
                            )}
                        </Section>
                        <ButtonGroup>
                            <Btn type="button" onClick={proComplete}>판매완료</Btn>
                            <Btn type="submit">수정</Btn>
                            <Btn type="button" onClick={proDelete}>삭제</Btn>
                        </ButtonGroup>

                    </form>

                :
                    <Section>
                        <Label>제목</Label>
                        {selectProduct.status === "complete" && ( 
                            <SellSpan>
                                판매완료
                            </SellSpan>
                        )}
                        <Input readOnly {...title} />

                        <Label>판매액</Label>
                        <Input readOnly {...price}/>

                        <Label>내용</Label>
                        <TextArea readOnly {...content} />

                        {selectProduct.image && (
                            <ImageBox>
                                <img src={selectProduct.image} />
                            </ImageBox>
                        )}
                    </Section>
                }

                <CommentForm onSubmit={commetAdd}>
                    <CommentTextArea placeholder='댓글을 입력해주세요...' readOnly={selectProduct.status === 'complete'} {...comment}/>
                    <CommentBtn type="submit" disabled={selectProduct.status === 'complete'}>등록</CommentBtn>
                </CommentForm>
                <div>
                    {proComments.map(p => <Comments key={p.id} proComments={p} commentRemove={commentRemove} />)}
                </div>
            </DetailContainer>
        </>
    )
}

export default ProductDetail