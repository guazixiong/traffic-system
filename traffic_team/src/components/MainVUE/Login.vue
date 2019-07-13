<template>
  <div class="paper">
    <h3 class="login_title">系统登录</h3>
    <!--账号-->
    <!--<el-form :inline="true">
      <el-form-item>
        <el-select v-model="people" placeholder="请选择登录方式">
          <el-option label="普通用户" value="普通用户"></el-option>
          <el-option label="管理员" value="管理员"></el-option>
        </el-select>
      </el-form-item>
    </el-form>-->
    <div style="margin-top:70px;margin-bottom:50px;">
      账号<input type="text" v-model="stuId"/>
      <span v-if="error.name" class="err-msg">{{error.name}}</span>
    </div>
    <div style="margin-bottom:50px;">
      密码<input type="password" v-model="password"/>
      <span v-if="error.pwd" class="err-msg">{{error.pwd}}</span>
    </div>
    <div style="margin-bottom:50px;">
      <label><input @click="getRadioVal" type="radio" name="type" value=1 v-model="cradio">普通用户</label>
      <label><input @click="getRadioVal" type="radio" name="type" value=2 v-model="cradio">管理员</label>
    </div>
    <div>
      <button @click="login">登录</button>
      <button @click="dialogFormVisible = true">注册</button>
      <el-dialog title="编辑个人信息" :visible.sync="dialogFormVisible" :modal-append-to-body='false'>
        <el-form label-width="80px">
          <el-form-item label="院校">
            <el-select v-model="school1" placeholder="不能为空">
              <el-option label="中原工学院" value="中原工学院"></el-option>
              <el-option label="郑州铁路职业技术学院" value="郑州铁路职业技术学院"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="学号">
            <el-input v-model="stuId1" placeholder="无法二次修改,请核对"></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="stuName1" placeholder="不能为空"></el-input>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="tel1" placeholder="不能为空"></el-input>
          </el-form-item>
          <el-form-item label="职位">
            <el-select v-model="profession1" placeholder="不能为空">
              <el-option label="教师" value="教师"></el-option>
              <el-option label="学生" value="学生"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="password1" type="password" placeholder="不能为空"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="onSubmit">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>

  import $router from "element-ui/packages/col/src/col";

  export default {
    data() {
      return {
        activeName:'first',
        cradio: '',

        stuId: '',
        password: '',
        stuName: '',

        dialogFormVisible: false,
        school1:'',
        stuId1:'',
        stuName1:'',
        tel1:'',
        profession1:'',
        password1:'',

        error: {
          name: '',
          password: ''
        }
      }
    },

    methods: {
      getRadioVal(event) {
        var x1 = event.target.value;
        console.log(x1);
      },
      login() {
        var obj=this.stuId;
        var infostr=JSON.stringify(obj);
        sessionStorage.obj=infostr;
        console.log(obj);
        if (this.cradio == 1) {
          this.$http({
            method: 'get',
            url: 'http://localhost:9527/traffic/student/login?stuId=' + this.stuId + '&password=' + this.password,
          }).then(response => {
            const data = response.data;
            this.stuName = data['stuId'];
            console.log(data['stuName']);
            if (this.stuName != null) {
              /*            sessionStorage.setItem("setname",response.data().res.stuName);
                          this.$store.dispatch("username",response.data().res.stuName);*/
              const {$router} = this;
              $router.push({name: "user"});
            }
            else {
              this.error.name = "请重新输入";
            }
          })
        }
        else if (this.cradio == 2) {
          this.$http({
            method: 'get',
            url: 'http://localhost:9527/traffic/admin/login?stuId=' + this.stuId + '&password=' + this.password,
          }).then(response => {
            const data = response.data;
            this.stuName = data['schoolName'];
            console.log(this.stuName);
            if (this.stuName != null) {
              const {$router} = this;
              $router.push({name: "admin"})
            }
            else {
              this.error.name = "请核对你的账号和密码";
            }
          })
        }
        else if (this.cradio == 3) {
          //
        }
      },
      onSubmit(){
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/regedit?school1=' + this.school1 + '&stuId1=' + this.stuId1 + '&stuName1=' + this.stuName1 + '&tel1=' + this.tel1 + '&profession1=' + this.profession1 + '&password1=' + this.password1,
        }).then(response => {
          const data = response.data;
          console.log(data);
          if (data == 0) {
            this.error.password = "用户已存在,请重新输入";
          }
          else if(data==-1)
            this.error.password = "用户已存在,请重新输入";
          else {
            const {$router} = this
            $router.push({name: "user"})
          }
        })
      }
    }
  }
</script>

<style>
  .paper {
    height: 600px;
    width: 100%;
    background-size: cover;
    text-align: center;
    /*position: fixed;*/
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

</style>
