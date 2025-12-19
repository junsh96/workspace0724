import useCommentList from "../../customHook/useCommentList";
import Comments from "./Comments";

const CommentList = ({ productId ,list,setComment}) => {

  return (
    <div>
      {list.map(c => (
        <Comments key={c.id} proComments={c} setComment={setComment}/>
      ))}
    </div>
  );
};

export default CommentList;