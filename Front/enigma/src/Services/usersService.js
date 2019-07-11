const axios = require("axios");
import routeur from "../router";

export default {
  //create user
  createUser(userData) {
    axios.post("http://localhost:8080/users", userData).then(response => {
      if (response.status === 201) {
        routeur.push("profile");
      }
    });
  },

  //loge user
  logUser(userPassword, userName) {
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
    }).then(response => {
      console.log(response.username);
      // if (response.status != 200) {
      //   alert("Cet utilisateur n'existe pas. Merci de vous inscrire.");
      // } else {
      //   routeur.push("profile");
      // }
    });
  }
};
