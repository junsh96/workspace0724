import { useEffect, useState } from "react";

const COMMENT_KEY = "comments";

const  useCommentList = (init = []) => {
    const [comments, setComments] = useState(() =>{
        try {
            const saved = localStorage.getItem(COMMENT_KEY);
            return saved? JSON.parse(saved) : init;
        } catch(e) {
            console.log("댓글 로컬스토리지 오류");
            return init;
        }
    });

    useEffect(() => {
        localStorage.setItem(COMMENT_KEY, JSON.stringify(comments));
    }, [comments]);

    //댓글 추가
    const commentAdd = (item) => {
        setComments(prev => [...prev, item]);
    }

    //댓글 삭제
    const commentRemove = (item) => {
        setComments(prev => {
            const target = prev.find(p => p.id === item.id);
            if (!target) {
                alert("존재하지 않는 댓글입니다.")
                return prev;
            }

            if (target.userId !== item.userId) {
                alert("권한이 없습니다.")
                return prev;
            }

            return prev.filter(p => p.id !== item.id);
        })
    }

    return {comments, commentAdd, commentRemove};
}

export default useCommentList;