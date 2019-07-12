const axios = require('axios')

export default {
    fetchBestsScores(){
        return axios.get('http://localhost/8080/users/dashboard')
    }
}