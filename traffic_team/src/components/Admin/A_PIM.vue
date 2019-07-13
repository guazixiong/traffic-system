<template>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column prop="schoolid" label="账号"></el-table-column>
    <el-table-column prop="adminname" label="管理人"></el-table-column>
    <el-table-column prop="tel" label="联系方式"></el-table-column>
    <el-table-column prop="schoolName" label="院校"></el-table-column>
    <el-table-column fixed="right" label="操作">
      <template slot-scope="scope">
        <el-button type="text" size="small" @click="dialogFormVisible = true">编辑</el-button>
        <!--<router-link :to="{name:'a1'}"></router-link>-->
        <el-dialog title="编辑文件" :visible.sync="dialogFormVisible" :modal-append-to-body='false'>
          <el-form label-width="80px">
            <el-form-item label="旧密码">
              <el-input type="password" v-model="password1"></el-input>
            </el-form-item>
            <el-form-item label="新密码">
              <el-input type="password" v-model="password2"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
              <el-input v-model="adminname1"></el-input>
            </el-form-item>
            <el-form-item label="联系方式">
              <el-input v-model="tel1"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="onSubmit">确 定</el-button>
          </div>
        </el-dialog>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [],
        dialogTableVisible: false,
        dialogFormVisible: false,
        tel1: '',
        adminname1: '',
        password1: '',
        password2: '',
        obj: '',
      }
    },
    created() {
      this.ashow();
    },
    methods: {
      ashow: function () {
        var infostr = sessionStorage.obj;
        this.obj = JSON.parse(infostr);
        console.log(this.obj);
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/showadmin?obj=' + this.obj,
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
      onSubmit() {
        var infostr = sessionStorage.obj;
        this.obj = JSON.parse(infostr);
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/alteradmin?tel=' + this.tel1 + '&adminname=' + this.adminname1 + '&schoolid=' + this.obj + '&password1=' + this.password1 + '&password2=' + this.password2,
        }).then(response => {
          const data = response.data;
          console.log(data);
          if (data == 0 || data == -1) {
            const {$router} = this;
            $router.push({name: 'defeat1'})
          }
          else {
            const {$router} = this;
            $router.push({name: 'admin'})
          }
        })
      }
    }
  }
</script>
