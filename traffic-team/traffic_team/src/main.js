// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Main from './components/Main.vue'
import IntroduceSYS from './components/MainVUE/IntroduceSYS.vue'
import mactivity from './components/MainVUE/mactivity.vue'
import OrganizationSYS from './components/MainVUE/OrganizationSYS.vue'
import Message from './components/MainVUE/Message.vue'
import Admin from './components/Admin.vue'
import Login from './components/MainVUE/Login.vue'
import User from './components/User.vue'
import U_PIM from './components/User/U_PIM.vue'
import SMessage from './components/User/SMessage.vue'
import UFindInfor from './components/User/UFindInfor.vue'
import TakePart from './components/User/TakePart.vue'
import TakedPart from './components/User/TakedPart.vue'
import A_PIM from './components/Admin/A_PIM.vue'
import AUserControll from './components/Admin/AUserControll.vue'
import AMessage from './components/Admin/AMessage.vue'
import AActivity from './components/Admin/AActivity.vue'
import UploadActivity from './components/Admin/UploadActivity.vue'
import UploadInfor from './components/Admin/UploadInfor.vue'
import FindInfor from './components/Admin/FindInfor.vue'
import HelpYou from './components/HelpYou.vue'
import DeleteInfor from './components/Admin/DeleteInfor.vue'
import DeleteUser from './components/Admin/DeleteUser.vue'
import test from './components/MainVUE/test.vue'
import Defeat1 from './components/Defeat1.vue'
import VueRouter from "vue-router";
import VueReource from "vue-resource";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';
import {Carousel, CarouselItem} from 'element-ui'
import 'vue-easytable/libs/themes-base/index.css';
import {VTable, VPagination} from 'vue-easytable';
Vue.component(VTable.name, VTable);
Vue.component(VPagination.name, VPagination);
const Main123 = resolve => require(['@/components/Main'], resolve);
axios.defaults.withCredentials = true;
Vue.prototype.$http = axios;
Vue.config.productionTip = false;
Vue.use(VueRouter);
Vue.use(VueReource);
Vue.use(ElementUI);
Vue.use(Carousel);
Vue.use(CarouselItem);
const routes = [
  {
    name: 'main', path: '/', component: Main,
    children: [
      {name: 'login', path: '/main/login', component: Login},
      {name: 'introducesys', path: '/main/introducesys', component: IntroduceSYS},
      {name: 'organizationsys', path: '/main/organizationsys', component: OrganizationSYS},
      {name: 'message', path: '/main/message', component: Message},
      {name: 'test', path: '/main/test', component: test},
      {name: 'mactivity', path: '/main/mactivity', component: mactivity},
    ]
  },
  {
    name: 'admin', path: '/main/aloin/admin', component: Admin,
    children: [
      {name: 'a_pim', path: '/main/aloin/admin/a_pim', component: A_PIM},
      {name: 'ausercontrol', path: '/main/aloin/admin/ausercontrol', component: AUserControll},
      {name: 'uploadinfor', path: '/main/aloin/admin/uploadinfor', component: UploadInfor},
      {name: 'findinfor', path: '/main/aloin/admin/findinfor', component: FindInfor},
      {name: 'deleteinfor', path: '/main/aloin/admin/deleteinfor', component: DeleteInfor},
      {name: 'deleteuser', path: '/main/aloin/admin/deleteuser', component: DeleteUser},
      {name: 'ahelpyou', path: '/main/helpyou', component: HelpYou},
      {name: 'aintroducesys', path: '/main//aloin/introducesys', component: IntroduceSYS},
      {name: 'aorganizationsys', path: '/main/aloin/organizationsys', component: OrganizationSYS},
      {name: 'amessage', path: '/main/aloin/message', component: Message},
      {name: 'atest', path: '/main/aloin/test', component: test},
      {name: 'amactivity', path: '/main/alogin/admin/mactivity', component: mactivity},
      {name: 'asmsessage', path: '/main/aloin/admin/amsessage', component: AMessage},
      {name: 'uploadactivity', path: '/main/aloin/admin/uploadactivity', component: UploadActivity},
      {name: 'ammessage', path: '/main/ammessage', component: Message},
      {name: 'defeat1', path: '/main/alogin/admin/defeat1', component: Defeat1},
      {name: 'aactivity', path: '/main/aactivity', component: AActivity},
    ]
  },
  {
    name: 'user', path: '/main/login/user', component: User,
    children: [
      {name: 'u_pim', path: '/main/login/user/u_pim', component: U_PIM},
      {name: 'ufindinfor', path: '/main/login/user/ufindinfor', component: UFindInfor},
      {name: 'uhelpyou', path: '/main/helpyou', component: HelpYou},
      {name: 'uintroducesys', path: '/main/login/introducesys', component: IntroduceSYS},
      {name: 'uorganizationsys', path: '/main/login/organizationsys', component: OrganizationSYS},
      {name: 'umessage', path: '/main/login/user/message', component: Message},
      {name: 'utest', path: '/main/login/test', component: test},
      {name: 'umactivity', path: '/main/login/user/umactivity', component: mactivity},
      {name: 'smessage', path: '/main/login/user/smessage', component: SMessage},
      {name: 'takepart', path: '/main/login/user/takepart', component: TakePart},
      {name: 'takedpart', path: '/main/login/user/takedpart', component: TakedPart},
      {name: 'ummessage', path: '/main/ummessage', component: Message},
      {name: 'defeat1', path: '/main/login/user/defeat1', component: Defeat1},
    ]
  },


];
var router = new VueRouter({
  routes
});
var App = {
  template: '<router-view></router-view>'
};
new Vue({
  el: '#app',
  router, //等价于 router: router
  components: {App},
  template: '<App/>',
});
