import useCommentList from "../../customHook/useCommentList";
import Comments from "./Comments";

const CommentList = ({ productId ,list, commentRemove}) => {

  return (
    <div>
      {list.map(c => (
        <Comments key={c.id} proComments={c} commentRemove={commentRemove} />
      ))}
    </div>
  );
};

export default CommentList;