<template>
  <div class="u3">
    <el-form :inline="true">

      <el-form-item>
        <el-select v-model="author" placeholder="请选择院校">
          <el-option label="中原工学院" value="中原工学院"></el-option>
          <el-option label="郑州铁路职业技术学院" value="郑州铁路职业技术学院"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="title" label="标题" width="300"></el-table-column>
      <el-table-column prop="conent" label="内容" width="700"></el-table-column>
      <el-table-column prop="inforTime" label="发布时间" width="140"></el-table-column>
      <el-table-column prop="author" label="发布院校" width="139"></el-table-column>
    </el-table>
  </div>
</template>
<script>
  import * as scope from "element-ui";

  export default {
    data() {
      return {
        author: '',
        tableData: [],
      }
    },
    methods: {
      onSubmit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/selectinfor?author=' + this.author,
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
