<template>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column prop="stuId" label="学号"></el-table-column>
    <el-table-column prop="stuName" label="姓名"></el-table-column>
    <el-table-column prop="tel" label="联系方式"></el-table-column>
    <el-table-column prop="profession" label="职业"></el-table-column>
    <el-table-column prop="school" label="院校"></el-table-column>
    <el-table-column fixed="right" label="操作">
      <template slot-scope="scope">
        <el-button type="text" size="small" icon="el-icon-edit" @click="dialogFormVisible = true">编辑</el-button>
        <el-dialog title="编辑个人信息" :visible.sync="dialogFormVisible" :modal-append-to-body='false'>
          <el-form label-width="80px">
            <el-form-item label="旧密码">
              <el-input type="password" v-model="password1"></el-input>
            </el-form-item>
            <el-form-item label="新密码">
              <el-input type="password" v-model="password2"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
              <el-input v-model="stuname1"></el-input>
            </el-form-item>
            <el-form-item label="联系方式">
              <el-input v-model="tel1"></el-input>
            </el-form-item>
            <el-form-item label="职位">
              <el-select v-model="profession1" placeholder="不能为空">
                <el-option label="教师" value="教师"></el-option>
                <el-option label="学生" value="学生"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="院校">
              <el-select v-model="school1" placeholder="不能为空">
                <el-option label="中原工学院" value="中原工学院"></el-option>
                <el-option label="郑州铁路职业技术学院" value="郑州铁路职业技术学院"></el-option>
              </el-select>
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
        StuId1: '',
        password1: '',
        password2: '',
        stuname1: '',
        tel1: '',
        profession1: '',
        school1: '',
        obj:'',
      }
    },
    /*mounted:function(){
      this.ushow();
    },*/
    created(){
      this.ushow();
    },
    methods: {
      ushow:function() {
        var infostr = sessionStorage.obj;
        this.obj = JSON.parse(infostr);
        console.log(this.obj);
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/showuser?obj='+this.obj,
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
        console.log(this.obj);
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/update?school1=' + this.school1 + '&StuId1=' + this.obj+ '&stuname1=' + this.stuname1 + '&tel1=' + this.tel1 + '&profession1=' + this.profession1 + '&password2=' + this.password2,
        }).then(response => {
          const data = response.data;
          console.log(data);
          if (data == 0 || data == -1) {
            const {$router} = this;
            $router.push({name: 'defeat1'})
          }
          else {
            const {$router} = this;
            $router.push({name: 'user'})
          }
        })
      }
    },
  }
</script>
