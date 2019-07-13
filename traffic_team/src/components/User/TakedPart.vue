<template>
  <div>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="id" label="序号" width="50"></el-table-column>
      <el-table-column prop="activitytype" label="活动类别" width="150"></el-table-column>
      <el-table-column prop="activitytime" label="活动时间" width="150"></el-table-column>
      <el-table-column prop="acticityspace" label="活动地点" width="150"></el-table-column>
      <el-table-column prop="meetnumber" label="活动人数" width="100"></el-table-column>
      <el-table-column prop="meetname" label="活动名称" width="300"></el-table-column>
      <el-table-column prop="connent" label="活动内容" width="600"></el-table-column>
      <el-table-column prop="peoplename" label="活动内容" width="600"></el-table-column>
    </el-table>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        tableData: [],
        obj: ''
      }
    },
    created() {
      this.showactivity();
    },
    methods: {
      showactivity: function () {
        var infostr = sessionStorage.obj;
        this.obj = JSON.parse(infostr);
        console.log(this.obj);;
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/takedpart?obj=' + this.obj,
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
<style>
</style>
