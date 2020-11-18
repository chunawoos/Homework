import Vue from "vue";
import VueRouter from "vue-router";
import Index from '@/page/index.vue';
import List from '@/page/list.vue';
import Create from '@/page/create.vue';
import Detail from '@/page/detail.vue';
import Update from '@/page/update.vue';
import Delete from '@/page/delete.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'index',
    component: Index,
  },
  {
    path: '/list',
    name: 'list',
    component: List,
  },
  {
    path: '/create',
    name: 'create',
    component: Create,
  },
  {
    path: '/detail',
    name: 'detail',
    component: Detail,
  },
  {
    path: '/update',
    name: 'update',
    component: Update,
  },
  {
    path: '/delete',
    name: 'delete',
    component: Delete,
  },
];

const router = new VueRouter({
  mode: "history",
  routes
});

export default router;
