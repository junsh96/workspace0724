import { useUsers } from "../../context/UserContext";
import useCommentList from "../../customHook/useCommentList";
import useInput from "../../customHook/useInput";
import { CommentBtn, CommentForm, CommentTextArea } from "../../styled/ProductDetail.styled";

const CommentWriter = ({ productId, disabled, commentAdd }) => {

  const { users } = useUsers();
  const comment = useInput("");

  const onSubmit = e => {
    e.preventDefault();
    if (!comment.value.trim()) return alert("댓글을 입력하세요.");

    commentAdd({
      id: Date.now(),
      comment: comment.value,
      userId: users.id,
      productId,
    });

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