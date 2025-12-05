import React, { useContext } from "react";

const UserContext = React.createContext();

export const UserProVider = ({chlidren}) => {

    const user = {
        name : "TEST",
        age : 45,
        role : "관리자"
    }

    return (
        <UserContext.Provider value={user}>
            {chlidren}
        </UserContext.Provider>
    )
}

// export const useUser = () => {
//     return useContext(UserContext);s
// }