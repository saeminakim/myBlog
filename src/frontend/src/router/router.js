import Vue from 'vue'
import VueRouter from "vue-router";

Vue.use(VueRouter)

const routes = [
    {
        path: '/about',
        name: 'about',
        component: () => import('../view/About.vue')
    }
]

const router = new VueRouter({
    base: process.env.BASE_URL,
    routes
})

export default router