import axios from 'axios';
import authHeader from './auth-header';

const http = axios.create({
  baseURL: 'http://localhost:8080'
});

export default {

  //user methods below

  getAllUsers() {
    return axios.get(`/user`)
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

  //symptom methods below

  getAllSymptoms() {
    return http.get(`/symptom`);
  },

  getAllSymptomsByJournalId(journalId) {
    return http.get(`/symptom/all/${journalId}`)
  },

  getSymptomById(symptomId) {
    return http.get(`/symptom/${symptomId}`)
  },

  insertSymptomIntoJournalSymptom(journalId, symptomList) {
    return http.post(`/symptom/journalId/${journalId}`, symptomList)
  },

  //journal methods below

  getJournalByJournalId() {
    return http.get(`/symptom`);
  },

  getJournalByUserId(journalId) {
    return http.get(`/symptom/all/${journalId}`)
  },

  updateJournalEntry(symptomId) {
    return http.get(`/symptom/${symptomId}`)
  },

  createJournalEntry(journalId, symptomList) {
    return http.post(`/symptom/journalId/${journalId}`, symptomList)
  },

  



}

// getAllSymptomsByJournalId(journalId) {
//   return http.post(`/recipes/add`, recipe, {headers: authHeader()})
// },
// getSymptomById(symptomId){
//   return http.put(`/recipes/edit`, recipe, {headers: authHeader()})
// },
// insertSymptomIntoJournalSymptom(recipe) {
//   return http.delete(`/recipes/delete`, {headers: authHeader(), data: recipe})
// }