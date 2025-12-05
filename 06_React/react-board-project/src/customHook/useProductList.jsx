import { useEffect, useState } from "react";

const PRODUCT_KEY = "products";

const useProductList = (init = []) => {
    const [value, setValue] = useState(() => {
        try {
            const saved = localStorage.getItem(PRODUCT_KEY);
            return saved ? JSON.parse(saved) : init;
        } catch (e) {
            console.log("product 로컬스토리지 오류");
            return init;
        }
    });

    useEffect(() => {
        localStorage.setItem(PRODUCT_KEY, JSON.stringify(value));
    },[value]);

    //물품 등록
    const productAdd = (item) => {
        setValue(prev => [...prev, item]);
    }

    //물품 삭제
    const productRemove = (item) => {
        setValue(prev => {
            const target = prev.find(p=> p.id === item.id);

            if (!target) {
                alert("게시글이 없습니다.");
                return prev;
            }

            if(target.userId !== item.userId) {
                alert("권한이 없습니다.");
                return prev;
            }

            return prev.filter(p => p.id !== item.id);

        })
    }

    //물품 수정
    const productUpdate = (item) => {
        setValue(prev => {
             const target = prev.find(p=> p.id === item.id);

            if (!target) {
                alert("게시글이 없습니다.");
                return prev;
            }

            if(target.userId !== item.userId) {
                alert("권한이 없습니다.");
                return prev;
            }

            return prev.map(p=> (p.id === item.id ? item : p));

        })

    }
    return {value, productAdd, productRemove, productUpdate};
}

export default useProductList;