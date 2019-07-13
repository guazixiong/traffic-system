<template>
  <div>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="messagecontent" label="内容" width="700"></el-table-column>
      <el-table-column prop="sendtime" label="发送时间" width="300"></el-table-column>
      <el-table-column prop="sendname" label="发送人" width="250"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <el-button type="text" size="small" @click="onsumbit">已读</el-button>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
  import * as scope from "element-ui";

  export default {
    data() {
      return {
        tableData: [],
        obj: '',
      }
    },
    created() {
      this.showinfor();
    },
    methods: {
      showinfor: function () {
        var infostr = sessionStorage.obj;
        this.obj = JSON.parse(infostr);
        console.log(this.obj);
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/smessage?obj=' + this.obj,
        }).then(response => {
          const data = response.data;
          console.log(data);
          for (var i = 0; i < data.length; i++) {
            this.tableData = response.data;
          }
        }).catch(function (error) {
          alert(error);
        })
      },
      onsumbit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/trueexist',
        }).then(response => {
          const data = response.data;
          console.log(data);
          if (data == 0) {
            const {$router} = this;
            $router.push({name: 'defeat1'});
          }
          else {
            const {$router} = this;
            $router.push({name: 'user'})
          }
        }).catch(function (error) {
          alert(error);
        })
      }

    }
  }
</script>
