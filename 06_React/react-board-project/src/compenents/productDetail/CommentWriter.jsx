import { useUsers } from "../../context/UserContext";
import useCommentList from "../../customHook/useCommentList";
import useInput from "../../customHook/useInput";
import { CommentBtn, CommentForm, CommentTextArea } from "../../styled/ProductDetail.styled";
import { addComment } from "../productDetail/api/ProductDetail.api";

const CommentWriter = ({ productId, disabled, setComment}) => {

  const { users } = useUsers();
  const comment = useInput("");

  const onSubmit = async e => {
    e.preventDefault();
    if (!comment.value.trim()) return alert("댓글을 입력하세요.");

    try {
      const commentBoard = {
        id: Date.now(),
        comment: comment.value,
        user_id: users.user_id,
        product_id: productId
      }
      await addComment(commentBoard);
      setComment(prev => [...prev, commentBoard])
      alert("댓글이 등록되었습니다.");
    } catch(e) {
      alert("댓글 등록에 실패하였습니다.");
      console.log(e);
    }

    // commentAdd({

    // });

    comment.setValue("");
  };

  return (
    <CommentForm onSubmit={onSubmit}>
      <CommentTextArea {...comment} readOnly={disabled} />
      <CommentBtn disabled={disabled}>등록</CommentBtn>
    </CommentForm>
  );
};

export default CommentWriter;