import axios from 'axios';
import authHeader from './auth-header';

const http = axios.create({
  baseURL: 'http://localhost:8080'
});

export default {

  //user methods below

  getAllUsers() {
    return axios.get('/user')
  },

  getUserById(userId) {
    return axios.get(`/user/${userId}`)
  },

  register(newUser) {
    return http.post(`/user/register`, user)
  },
  findIdByUsername(username) {
    return http.get(`/user/userId/${username}`)
  },

  //

  getRecipes() {
    return http.get(`/recipes/all`);
  },
  addRecipe(recipe) {
    return http.post(`/recipes/add`, recipe, {headers: authHeader()})
  },
  editRecipe(recipe){
    return http.put(`/recipes/edit`, recipe, {headers: authHeader()})
  },
  searchRecipe(id) {
    return http.get(`/recipes/search/${id}`, {headers: authHeader()})
  },
  deleteRecipe(recipe) {
    return http.delete(`/recipes/delete`, {headers: authHeader(), data: recipe})
  }
}