import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '../views/HomePage.vue'
import JournalList from '../views/JournalList.vue'
import JournalDetails from '../views/JournalDetails.vue'
import JournalEntry from '../views/JournalEntry.vue'


Vue.use(Router)

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home-page',
            component: HomePage,
            meta: {
            // Will need changed later if authorization implemented
            requiresAuth: false
            }
        },
        //TODO
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
            path: '/journal-list',
            name: 'journal-list',
            component: JournalList,
            meta: {
              requiresAuth: false
            }
          },
          {
            path: '/journal/:id',
            name: 'journal-details',
            component: JournalDetails,
            meta: {
              requiresAuth: false
            }
          },
          {
            path: '/journal-entry',
            name: 'journal-entry',
            component: JournalEntry,
            meta: {
              requiresAuth: false
            }
          }
    ]
})
  
export default router;