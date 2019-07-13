<template>
  <div>
    <el-form :inline="true">
      <el-form-item>
        <el-input v-model="p_school" placeholder="请输入:学生姓名/学校名称"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit1">学生查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit2">显示所有</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="stuId" label="学号"></el-table-column>
      <el-table-column prop="stuName" label="姓名"></el-table-column>
      <el-table-column prop="tel" label="联系方式"></el-table-column>
      <el-table-column prop="profession" label="职位"></el-table-column>
      <el-table-column prop="school" label="学校"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small">
            <router-link :to="{name:'deleteuser'}">删除</router-link>
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
  import * as scope from "element-ui";

  export default {
    data() {
      return {
        p_school: '',
        tableData: [],
      }
    },
    methods: {
      onSubmit1() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/onlyfind?stuname=' + this.p_school,
        }).then(response => {
          const data = response.data;
          console.log(data);
          //var list=[];
          for (var i = 0; i < data.length; i++) {
            this.tableData = response.data;
            //list[i]=tableData[i]['data'];
          }
        }).catch(function (error) {
          alert(error);
        })
      },
      onSubmit2() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/findstudent?school=' + this.p_school,
        }).then(response => {
          const data = response.data;
          console.log(data);
          //var list=[];
          for (var i = 0; i < data.length; i++) {
            this.tableData = response.data;
            //list[i]=tableData[i]['data'];
          }
        }).catch(function (error) {
          alert(error);
        })
      }
    }
  }
</script>
