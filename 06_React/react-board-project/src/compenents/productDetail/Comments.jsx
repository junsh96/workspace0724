import React from 'react'
import { useUsers } from '../../context/UserContext';
import { CommentBox, CommentContent, CommentHeader, DeleteBtn } from '../../styled/Comments.styled';
import { deleteComment } from './api/ProductDetail.api';

const Comments = ({proComments, commentRemove, setComment}) => {

    const {users} = useUsers();
    const commentDelete = async (e) => {
        e.preventDefault();
        if (proComments.user_id !== users.user_id) {
            alert("권한이 없습니다.");
            return;
        }
        try {
            await deleteComment(proComments.id);
            setComment(prev => prev.filter(c => c.id !== proComments.id));
            alert("댓글이 삭제되었습니다.");
        } catch(e) {
            alert("댓글 삭제에 실패하였습니다.");
            console.log(e);
        }

    }
    return (
        <CommentBox>
            <CommentHeader>
                작성자 : {proComments.user_id}
            </CommentHeader>
            <CommentContent>
                {proComments.comment} <DeleteBtn  onClick={commentDelete}>삭제</DeleteBtn>
            </CommentContent>
        </CommentBox>
    )
}

export default Comments