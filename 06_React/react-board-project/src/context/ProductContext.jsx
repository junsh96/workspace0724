import { createContext, useContext } from "react";
import useProductList from "../customHook/useProductList";

const ProductContext = createContext();

export const ProductProvider = ({ children }) => {
    const {value, productAdd, productRemove, productUpdate} = useProductList([]);

    return (
        <ProductContext.Provider value={{value, productAdd, productRemove, productUpdate}}>
            {children}
        </ProductContext.Provider>
    );

};

export const useProduct = () => useContext(ProductContext);