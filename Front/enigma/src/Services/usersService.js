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

    // creating base64 encoded String from user name and password
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



    let formBody = [];
    for (let property in details) {
      let encodedKey = encodeURIComponent(property);
      let encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    console.log("formBody ", JSON.stringify(formBody));
    axios
    .get("http://localhost:8080/users/login", {
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json;charset=UTF-8',
        'Access-Control-Allow-Origin': '*'
      }
    }).then(responseData => {
      console.log(responseData);
    });
  },

    fetchUser(name){
        return axios.get('http://localhost:8080/users/userProfile?name=' + name)
    },
    deleteUser(id_user){
        axios.delete('http://localhost:8080/users/' +id_user, {

        })
    }
  }




};
