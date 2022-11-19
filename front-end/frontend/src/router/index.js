import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Journals from '../views/Journals.vue'
import JournalDetails from '../views/JournalDetails.vue'


Vue.use(Router)

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
            meta: {
            // Will need changed later if authorization implemented
            requiresAuth: false
            }
        },
        // {
        //     path: "/login",
        //     name: "login",
        //     component: Login,
        //     meta: {
        //       requiresAuth: false
        //     }
        //   },
        //   {
        //     path: "/logout",
        //     name: "logout",
        //     component: Logout,
        //     meta: {
        //       requiresAuth: false
        //     }
        //   },
          {
            path: '/journals',
            name: 'journals',
            component: Journals,
            meta: {
              requiresAuth: false
            }
          },
          {
            path: '/journaldetails',
            name: 'journal-details',
            component: JournalDetails,
            meta: {
              requiresAuth: false
            }
          }
    ]
})
  
export default router;