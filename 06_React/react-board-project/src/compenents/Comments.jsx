import React from 'react'
import { useUsers } from '../context/UserContext';
import { CommentBox, CommentContent, CommentHeader, DeleteBtn } from './Comments.styled';

const Comments = ({proComments, commentRemove}) => {

    const {users} = useUsers();
    const deleteComment = {
        id : proComments.id,
        userId : users.id
    }
    return (
        <CommentBox>
            <CommentHeader>
                작성자 : {proComments.userId}
            </CommentHeader>
            <CommentContent>
                {proComments.comment} <DeleteBtn  onClick={() => commentRemove(deleteComment)}>삭제</DeleteBtn>
            </CommentContent>
        </CommentBox>
    )
}

export default Comments