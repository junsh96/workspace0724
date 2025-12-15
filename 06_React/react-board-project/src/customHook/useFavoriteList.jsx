import { useEffect, useState } from "react";

const FAV_KEY = "favorites";

const useFavoriteList = () => {
    const [favorites, setFavorites] = useState(() => {
        try {
            const saved = localStorage.getItem(FAV_KEY);
            return saved ? JSON.parse(saved) : [];
        } catch {
            return [];
        }
    });

    useEffect(() => {
        localStorage.setItem(FAV_KEY, JSON.stringify(favorites));
    }, [favorites]);

    // 찜 토글
    const toggleFavorite = (userId, productId) => {
        setFavorites(prev => {
            // 이미 존재하는지 판단
            const exists = prev.some(f => f.userId === userId && f.productId === productId);
            
            if (exists) {
                // 삭제
                return prev.filter(f => !(f.userId === userId && f.productId === productId));
            } else {
                // 추가
                return [...prev, { userId, productId }];
            }
        });
    };

    // 특정 유저의 찜 목록 얻기
    const getUserFavorites = (userId) => {
        return favorites
            .filter(f => f.userId === userId)
            .map(f => f.productId);
    };

    return { favorites, toggleFavorite, getUserFavorites };
};

export default useFavoriteList;