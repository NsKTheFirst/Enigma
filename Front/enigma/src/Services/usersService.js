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
        let base64Credential = btoa( userName+ ':' + userPassword); 
 
        console.log(base64Credential); 
         
       
          return axios.get("http://localhost:8080/security/login" ,   { 
            headers: { 
            'Authorization': 'Basic '+base64Credential, 
            'Accept': 'application/json' 
          } 
        }) 
          .map((response) => { 
          // login successful if there's a jwt token in the response 
          let user = response.json().principal;// the returned user object is a principal object 
          if (user) { 
            // store user details  in local storage to keep user logged in between page refreshes 
            localStorage.setItem('currentUser', JSON.stringify(user)); 
          } 
        }); 
    },
    fetchUser(name){
        return axios.get('http://localhost:8080/users/userProfile?name=' + name)
    }
};
