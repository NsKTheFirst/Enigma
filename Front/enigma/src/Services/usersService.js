const axios = require("axios");

export default {
    //create user
    createUser(userData) {
        return axios.post("http://localhost:8080/users", userData)
        // .then(response => {
        //   console.log(response);
        // })
        // .catch(error => {
        //   console.log(error);
        // });
    },

    //loge user
    async logUser(userPassword, userName) {
        let details = {
            username: userName,
            password: userPassword
        };

        let formBody = [];
        for (let property in details) {
            let encodedKey = encodeURIComponent(property);
            let encodedValue = encodeURIComponent(details[property]);
            formBody.push(encodedKey + "=" + encodedValue);
        }
        formBody = formBody.join("&");
        console.log("formBody ", JSON.stringify(formBody));
        fetch("http://localhost:8080/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: formBody,
            mode: "no-cors",
            withCredentials: true,
            credentials: "include"
        })
    },
    fetchUser(name){
        return axios.get('http://localhost:8080/users/userProfile?name=' + name)
    },
    deleteUser(id_user){
        axios.delete('http://localhost:8080/users/' +id_user, {
            
        })
    }
};
