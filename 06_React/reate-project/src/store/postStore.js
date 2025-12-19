import axios from "axios";
import { create } from "zustand";

const usePostStore = create((set, get)=> ({
    posts : [],
    loading: false,
    error: null,
    deleteLoading : false,
    getPosts : async () => {
        set({loading: true, error: null});
        try {
            await axios.get('https://jsonplaceholder.typicode.com/todos')
            
            set(state => ({
                posts : state.posts.filter(post => post.id !== id),
                deleteLoading: false,
            }))
        } catch(e) {
            set({ deleteLoading: false, error: e.message})
        }
       
    },

    deletePost : async (id) => {
        set({deleteLoading : true, error: null})
        try {
            const response = await axios.delete(`https://jsonplaceholder.typicode.com//posts/${id}`)
            console.log(response);
            set({posts : response.data, loading: false})
        } catch(e) {
            set({ loading: false, error: e.message})
        }


    }



}))

export default usePostStore;