<template>
  <el-container>
    <el-header>
      <el-menu
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#4a4c4f"
        text-color="#FFD700"
        active-text-color="#ffd04b">
        <el-menu-item index="1">
          <router-link :to="{name:'aintroducesys'}">关于联盟</router-link>
        </el-menu-item>
        <el-submenu index="2">
          <template slot="title">教育研究中心</template>
          <el-menu-item index="2-1">
            <router-link :to="{name:'aorganizationsys'}">组织机构</router-link>
          </el-menu-item>
          <el-menu-item index="2-2">
            <router-link :to="{name:'atest'}">师资力量</router-link>
          </el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">专业委员会</template>
          <el-menu-item index="3-1">
            <router-link :to="{name:'atest'}">入会资格</router-link>
          </el-menu-item>
          <el-menu-item index="3-2">
            <router-link :to="{name:'atest'}">评判标准</router-link>
          </el-menu-item>
        </el-submenu>
        <el-menu-item index="4">
          <router-link :to="{name:'amessage'}">公告</router-link>
        </el-menu-item>
        <el-menu-item index="5">
          <router-link :to="{name:'amactivity'}">活动</router-link>
        </el-menu-item>
      </el-menu>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-radio-group v-model="isCollapse">
          <el-radio-button :label="false">展开</el-radio-button>
          <el-radio-button :label="true">收起</el-radio-button>
        </el-radio-group>
        <el-menu default-active="1-6-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                 :collapse="isCollapse">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-s-custom"></i>
              <span slot="title">信息管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">
                <router-link :to="{name:'a_pim'}">个人信息</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span slot="title">用户管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1">
                <router-link :to="{name:'ausercontrol'}">用户管理</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-document"></i>
              <span slot="title">文件管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1">
                <router-link :to="{name:'uploadinfor'}">上传文件</router-link>
              </el-menu-item>
              <el-menu-item index="3-2">
                <router-link :to="{name:'findinfor'}">查找文件</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-reading"></i>
              <span slot="title">活动</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="4-1">
                <router-link :to="{name:'uploadactivity'}">活动添加</router-link>
              </el-menu-item>
              <el-menu-item index="4-2">
                <router-link :to="{name:'aactivity'}">活动管理</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="5">
            <template slot="title">
              <i class="el-icon-message-solid"></i>
              <span slot="title">私信</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="5-1">
                <router-link :to="{name:'asmsessage'}">私信</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="6">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span slot="title">设置</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="6-1">
                <router-link :to="{name:'ahelpyou'}">请求和帮助</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>
<script>
  export default {
    data() {
      return {
        isCollapse: true,
        error: {
          name: '',
        }
      }
    },
  }
</script>
<style>
  a {
    color: #FFD700;
    text-decoration: none;
  }

  a:hover {
    color: yellow;
  }

  a:active {
    color: red;
  }

  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    line-height: 100px;
  }

  .el-main {
    background: url("/static/img/background1.jpg") no-repeat;
    height: 650px;
    width: 100%;
    text-align: center;
    background-size: cover;
  }

  .el-aside {
    background-color: #4a4c4f;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
</style>
