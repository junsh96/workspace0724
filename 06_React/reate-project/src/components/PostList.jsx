import React, { useEffect } from 'react'
import usePostStore from '../store/postStore'
import { Content, Error, Loading, PostCard, Title } from './styled/Post.styled';
import { Button, Container } from './styled/common';

const PostList = () => {

    const {posts,getPosts,loading,error,deletePost,deleteLoading} = usePostStore();

    useEffect(() => {
        console.log('di')
        getPosts();
    },[])

    if (loading) return <Loading>로딩중</Loading>
    if (error) return <Error>에러 발생 : {error}</Error>
    return (
        <Container>
            {posts.map(post =>(
                <PostCard key={post.id}>
                    <Title>{post.title}</Title>
                    <Content>{post.body}</Content>
                    <Button>수정</Button>
                    <Button
                        disabled={deleteLoading}
                        onClick={() => deletePost(post.id)}
                    >삭제</Button>
                </PostCard>
            ))}
        </Container>
    )
}

export default PostList