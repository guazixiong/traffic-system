<template>
  <div>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="title" label="标题" width="300"></el-table-column>
      <el-table-column prop="conent" label="内容" width="800"></el-table-column>
      <el-table-column prop="inforTime" label="发布时间" width="190"></el-table-column>
      <el-table-column prop="author" label="发布院校" width="190"></el-table-column>
    </el-table>
  </div>
</template>
<script>
  import * as scope from "element-ui";

  export default {
    data() {
      return {
        tableData: [],
      }
    },
    created() {
      this.showinfor();
    },
    methods: {
      showinfor: function () {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/showinfor',
        }).then(response => {
          const data = response.data;
          console.log(data);
          for (var i = 0; i < data.length; i++) {
            this.tableData = response.data;
          }
        }).catch(function (error) {
          alert(error);
        })
      }
    }
  }
</script>
