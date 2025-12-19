import React from 'react'
import useInput from '../customHook/useInput';
import useBase64FileInput from '../customHook/useBase64FileInput';
import { useUsers } from '../context/UserContext';
import { useNavigate } from 'react-router-dom';
import { useProduct } from '../context/ProductContext';
import { EnrollContainer, EnrollTitle, FileInput, FormGroup, PreviewBox, SubmitBtn } from '../styled/ProductEnroll.styled'
import { addProduct } from "../compenents/productEnroll/api/productEnroll.api"

const ProductEnroll = () => {

    const navigate = useNavigate();

    const { file, base64, preview, onChange, reset } = useBase64FileInput();
    const {users} = useUsers();
    const {value, productAdd} = useProduct();

    const productEnroll = async (e) => {
        e.preventDefault();
        if (!title.value.trim()) {
            alert("제목을 입력해주세요.")
            return
        }
        if(!content.value.trim()) {
            alert("내용을 입력해주세요.")
            return
        }

        if(!price.value.trim()) {
            alert("가격을 입력해주세요.")
            return
        }
        console.log(users);
        const productBoard = {
            id : Date.now(),
            user_id : users.user_id,
            title : title.value,
            content : content.value,
            image : base64,
            count : 0,
            price : Number(price.value),
            status : "progress"
        }

        try {

            await addProduct(productBoard);
            alert("게시글 등록이 완료되었습니다.");

            title.setValue('');
            content.setValue('');
            reset(); // 파일 관련 초기화

            navigate("/productList");
        } catch(e) {
            alert("게시글 등록에 실패하였습니다.")
            console.log(e);
        }


    }

    const title = useInput('');
    const content = useInput('');
    const price = useInput('');

    return (
        <>
            <EnrollContainer>
                <EnrollTitle>상품 등록</EnrollTitle>
                <form onSubmit={productEnroll}>
                    <FormGroup>
                        <label>제목</label>
                        <input type="text" placeholder='제목을 입력해주세요...' {...title}/>
                    </FormGroup>
                    <FormGroup>
                        <label>내용</label>
                        <textarea placeholder='내용을 입력해주세요...' {...content}/>
                    </FormGroup>
                    <FormGroup>
                        <label>희망 판매액</label>
                        <input type="number" placeholder='가격을 입력해주세요.' {...price}/>
                    </FormGroup>
                    <FormGroup>
                        <label>파일 첨부</label>
                        <FileInput  type="file" accept='image/*' onChange={onChange} />
                        {preview && 
                        <PreviewBox>
                            <img src={preview} width={150} />
                        </PreviewBox>}
                    </FormGroup>
                    <SubmitBtn  type="submit">등록</SubmitBtn>
                </form>
            </EnrollContainer>
        </>
    )
}

export default ProductEnroll