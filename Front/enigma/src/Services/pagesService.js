const axios = require('axios')
export default{
    fetchPage(page){
       return axios.get('http://localhost:8080/users/page?numPage=' + page)
    }
}