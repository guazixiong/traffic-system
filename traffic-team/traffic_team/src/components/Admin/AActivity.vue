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
      <el-table-column prop="peoplename" label="参与者" width="300"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="dialogFormVisible = true">编辑</el-button>
          <el-dialog title="编辑活动信息" :visible.sync="dialogFormVisible" :modal-append-to-body='false'>
            <el-form label-width="80px">
              <el-form-item label="活动类别">
                <el-select v-model="activitytype1">
                  <el-option label="公共类" value="公共类"></el-option>
                  <el-option label="学术类" value="学术类"></el-option>
                  <el-option label="实践类" value="实践类"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="时间">
                <el-input v-model="activitytime1" placeholder="如:2000/1/1"></el-input>
              </el-form-item>
              <el-form-item label="活动人数">
                <el-select v-model="meetnumber1">
                  <el-option label="1" value="1"></el-option>
                  <el-option label="2" value="2"></el-option>
                  <el-option label="3" value="3"></el-option>
                  <el-option label="4" value="4"></el-option>
                  <el-option label="5" value="5"></el-option>
                  <el-option label="6" value="6"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="活动地点">
                <el-input v-model="acticityspace1"></el-input>
              </el-form-item>
              <el-form-item label="活动名称">
                <el-input v-model="meetname1"></el-input>
              </el-form-item>
              <el-form-item label="内容">
                <el-input type="textarea" v-model="acconnent1"></el-input>
              </el-form-item>
              <el-form-item label="参与者">
                <el-input v-model="peoplename1"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="onSubmit">确 定</el-button>
            </div>
          </el-dialog>
          <el-button type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        tableData: [],
        activitytype1: '',
        activitytime1: '',
        acticityspace1: '',
        meetnumber1: '',
        meetname1: '',
        acconnent1: '',
        peoplename1:'',
        dialogFormVisible: false,
      }
    },
    created() {
      this.showactivity();
    },
    methods: {
      showactivity: function () {
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
      },
      onSubmit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/updateactivity?activitytype1=' + this.activitytype1 + '&activitytime1=' + this.activitytime1 + '&acticityspace1=' + this.acticityspace1 + '&meetnumber1=' + this.meetnumber1 + '&meetname1=' + this.meetname1 + '&acconnent1=' + this.acconnent1+'&peoplename1='+this.peoplename1,
        }).then(response => {
          const data = response.data;
          console.log(data);
          if (data == 0 || data == -1) {
            const {$router} = this;
            $router.push({name: "defeat1"});
          }
          else {
            const {$router} = this;
            $router.push({name: "admin"});
          }
        })
      }
    }
  }
</script>
<style>
</style>
