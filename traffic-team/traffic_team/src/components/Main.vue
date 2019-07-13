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
          <router-link :to="{name:'introducesys'}">关于联盟</router-link>
        </el-menu-item>
        <el-submenu index="2">
          <template slot="title">教育研究中心</template>
          <el-menu-item index="2-1">
            <router-link :to="{name:'organizationsys'}">组织机构</router-link>
          </el-menu-item>
          <el-menu-item index="2-2">
            <router-link :to="{name:'test'}">师资力量</router-link>
          </el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">专业委员会</template>
          <el-menu-item index="3-1">
            <router-link :to="{name:'test'}">入会资格</router-link>
          </el-menu-item>
          <el-menu-item index="3-2">
            <router-link :to="{name:'test'}">评判标准</router-link>
          </el-menu-item>
        </el-submenu>
        <el-menu-item index="4">
          <router-link :to="{name:'message'}">公告</router-link>
        </el-menu-item>
        <el-menu-item index="5">
          <router-link :to="{name:'mactivity'}">活动</router-link>
        </el-menu-item>
        <el-menu-item index="6">
          <router-link :to="{name:'login'}">登录</router-link>
        </el-menu-item>
      </el-menu>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>
<script>

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
    height: 600px;
    width: 100%;
    text-align: center;
    background-size: cover;
  }

  /*
    body > .el-container {
      margin-bottom: 100px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
      line-height: 40px;
    }

    .el-container:nth-child(7) .el-aside {
      line-height: 40px;
    }*/
</style>
