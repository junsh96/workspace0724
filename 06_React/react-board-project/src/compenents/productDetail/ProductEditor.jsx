import { useNavigate } from "react-router-dom";
import { useProduct } from "../../context/ProductContext";
import { useUsers } from "../../context/UserContext";
import useBase64FileInput from "../../customHook/useBase64FileInput";
import useInput from "../../customHook/useInput";
import { update,deleteProduct,updateStatus } from "./api/ProductDetail.api"

import {
  Btn,
  ButtonGroup,
  Section,
  Label,
  TextArea,
  Input,
  ImageBox,
  InfoRow,
} from "../../styled/ProductDetail.styled";
import useUserList from "../../customHook/useUserList";

const ProductEditor = ({ product,userUpdate }) => {
  const navigate = useNavigate();
  const { productUpdate, productRemove } = useProduct();
  const { users, setUsers } = useUsers();

  const { value:userList} = useUserList();
  // 이미지 처리 훅
  const { base64, preview, onChange } = useBase64FileInput();

  // 입력 훅
  const title = useInput(product.title);
  const price = useInput(product.price);
  const content = useInput(product.content);

  // 판매 완료
  const onComplete = async() => {
    // productUpdate({ ...product, status: "complete" });

    // const newAmount = users.amount + Number(product.price);
    // userUpdate({ ...users, amount: newAmount });

    // setUsers({ ...users, amount: newAmount });

    try {
      await updateStatus(users.user_id, product.id);
      alert("판매 처리가 완료되었습니다.");
      navigate("/productList");
    } catch(e) {
      alert("오류가 발생하였습니다.")
      console.log(e)
    }

  };

  // 게시글 수정
  const onSave = async () => {
    console.log("ASDASD",product);
    try {
      await update({
        ...product,
        title: title.value,
        price: price.value,
        content: content.value,
        image: base64 || product.image,
      });
      // productUpdate({
        
      // });

      alert("수정이 완료되었습니다.");
      navigate("/productList");
    } catch(e) {
       alert("수정에 실패하였습니다.");
      console.log(e)
    }

  };

  // 삭제
  const onDelete = async() => {
    if (confirm("정말 삭제하시겠습니까?")) {
      try {
        await deleteProduct(product.id);
        //productRemove(product);
        alert("삭제되었습니다.");
        navigate("/productList");
      } catch(e) {
        console.log(e)
      }

    }
  };

  return (
    <form
      onSubmit={(e) => {
        e.preventDefault();
        onSave();
      }}
    >
    <InfoRow>
        {product.image ? (
            <ImageBox>
                <img src={product.image} alt="상품" />
            </ImageBox>
            ) : (
            <ImageBox>
                <img alt="이미지가 없습니다" />
            </ImageBox>
            )}
      <div>
        <Section>
            <Label>제목</Label>
            <Input type="text" {...title} />
        </Section>

        <Section>
            <Label>판매액</Label>
            <Input type="number" {...price} />
        </Section>

        <Section>
            <Label>내용</Label>
            <TextArea {...content} />
        </Section>

        <Section>
            <Label>이미지 수정</Label>
            <input type="file" accept="image/*" onChange={onChange} />
        </Section>

        <ButtonGroup>
            <Btn type="button" onClick={onComplete}>
            판매완료
            </Btn>
            <Btn type="submit">수정</Btn>
            <Btn type="button" onClick={onDelete}>
            삭제
            </Btn>
        </ButtonGroup>
      </div>

    </InfoRow>
    </form>
  );
};

export default ProductEditor;


