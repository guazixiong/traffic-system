<template>
  <div class="text5">
    <el-form :inline="true">
      <el-form-item>
        <el-select v-model="school" placeholder="请选择院校">
          <el-option label="中原工学院" value="中原工学院"></el-option>
          <el-option label="郑州铁路职业技术学院" value="郑州铁路职业技术学院"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="title" label="标题" width="200"></el-table-column>
      <el-table-column prop="conent" label="内容" width="700"></el-table-column>
      <el-table-column prop="inforTime" label="发布时间" width="100"></el-table-column>
      <el-table-column prop="author" label="发布院校" width="100"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="dialogFormVisible = true">编辑</el-button>
          <el-dialog title="编辑文件" :visible.sync="dialogFormVisible" :modal-append-to-body='false'>
            <el-form label-width="80px">
              <el-form-item label="标题">
                <el-input v-model="title"></el-input>
              </el-form-item>
              <el-form-item label="时间">
                <el-input v-model="inforTime" placeholder="如:2017/3/20"></el-input>
              </el-form-item>
              <el-form-item label="内容">
                <el-input type="textarea" v-model="conent"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="onSubmit2">确 定</el-button>
            </div>
          </el-dialog>
          <el-button type="text" size="small">
            <router-link :to="{name:'deleteinfor'}">删除</router-link>
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
        school: '',
        tableData: [],
        /*dialogTableVisible: false,*/
        dialogFormVisible: false,
        title: '',
        conent: '',
        inforTime: '',
        formLabelWidth: '120px',
      }
    },
    methods: {
      onSubmit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/findInforByInforSchool?author=' + this.school,
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
          url: 'http://localhost:9527/traffic/admin/updateInfor?title=' + this.title + '&conent=' + this.conent + '&inforTime=' + this.inforTime,
        }).then(response => {
          const data = response.data;
          console.log(data);
          if (data == 0 || data == -1) {      //失败
            const {$router} = this;
            $router.push({name: "defeat1"})
          }
          else {   //成功
            const {$router} = this;
            $router.push({name: "findinfor"})
          }
        })
      },
    }
  }
</script>
