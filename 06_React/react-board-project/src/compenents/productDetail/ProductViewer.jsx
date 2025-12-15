import { ImageBox, InfoRow, Input, Label, Section, SellSpan, TextArea } from "../../styled/ProductDetail.styled";

const ProductViewer = ({ product }) => (
    <>
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

          <Section>
            <Label>제목</Label>
            {product.status === "complete" && <SellSpan >판매완료</SellSpan>}
            <Input readOnly value={product.title} />

            <Label>판매액</Label>
            <Input readOnly value={product.price} />

            <Label>내용</Label>
            <TextArea readOnly value={product.content} />
        </Section>
        </InfoRow>
    </>

);

export default ProductViewer;