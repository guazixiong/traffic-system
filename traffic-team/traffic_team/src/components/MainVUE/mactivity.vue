<template>
  <div>
    <div>
      <el-carousel :interval="4000" type="card" height="200px">
        <el-carousel-item v-for="item in imagesbox" :key="item.id">
          <img :src="item.src">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div>
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="id" label="序号" width="50"></el-table-column>
        <el-table-column prop="activitytype" label="活动类别" width="150"></el-table-column>
        <el-table-column prop="activitytime" label="活动时间" width="150"></el-table-column>
        <el-table-column prop="acticityspace" label="活动地点" width="150"></el-table-column>
        <el-table-column prop="meetnumber" label="活动人数" width="100"></el-table-column>
        <el-table-column prop="meetname" label="活动名称" width="300"></el-table-column>
        <el-table-column prop="connent" label="活动内容" width="600"></el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        imagesbox: [{
          id: 1,
          src: 'static/img/traffic1.png',
        }, {
          id: 2,
          src: 'static/img/traffic2.jpg',
        }, {
          id: 3,
          src: 'static/img/traffic3.png',
        }, {
          id: 4,
          src: 'static/img/traffic4.png',
        },],
        tableData:[],
      }
    },
    created(){
      this.showactivity();
    },
    methods:{
      showactivity:function() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/showactivity',
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
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>
