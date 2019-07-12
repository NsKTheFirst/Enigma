const axios = require("axios");

export default {
  //create user
  createUser(userData) {
    return axios.post("http://localhost:8080/users", userData)
  },

  //loge user
  async logUser(userPassword, userName) {
    // creating base64 encoded String from user name and password
    let base64Credential = btoa(userName + ':' + userPassword);
    return axios.get("http://localhost:8080/security/login", {
      headers: {
        'Authorization': 'Basic ' + base64Credential,
        'Accept': 'application/json'
      }
    })
  },

  fetchUser(name) {
    return axios.get('http://localhost:8080/users/userProfile?name=' + name)
  },
  deleteUser(id_user) {
    axios.delete('http://localhost:8080/users/' + id_user)
  },
  updatePassword(userId ,pass){
    let userObj = {
        id: userId,
        password: pass
    }

    axios.put('http://localhost:8080/users', userObj)
  }
}