<template>
  <el-form label-width="80px">
    <el-form-item label="活动类别">
      <el-select v-model="activitytype">
        <el-option label="公共类" value="公共类"></el-option>
        <el-option label="学术类" value="学术类"></el-option>
        <el-option label="实践类" value="实践类"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="时间">
      <el-input v-model="activitytime" placeholder="如:2000/1/1"></el-input>
    </el-form-item>
    <el-form-item label="活动人数">
      <el-select v-model="meetnumber">
        <el-option label="1" value="1"></el-option>
        <el-option label="2" value="2"></el-option>
        <el-option label="3" value="3"></el-option>
        <el-option label="4" value="4"></el-option>
        <el-option label="5" value="5"></el-option>
        <el-option label="6" value="6"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="活动地点">
      <el-input v-model="acticityspace"></el-input>
    </el-form-item>
    <el-form-item label="活动名称">
      <el-input v-model="meetname"></el-input>
    </el-form-item>
    <el-form-item label="内容">
      <el-input type="textarea" v-model="acconnent"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即创建</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>


</template>>
<script>
  export default {
    data() {
      return {
        activitytype:'',
        activitytime:'',
        acticityspace:'',
        meetnumber:'',
        meetname:'',
        acconnent:'',
      }
    },
    methods: {
      onSubmit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/uploadactivity?activitytype=' + this.activitytype  + '&activitytime=' + this.activitytime + '&acticityspace=' + this.acticityspace + '&meetnumber=' + this.meetnumber+'&meetname='+this.meetname+'&acconnent='+this.acconnent,
        }).then(response => {
          const data = response.data;
          console.log(data);
          if (data == 0||data==-1) {
            const {$router} = this;
            $router.push({name:"defeat1"});
          }
          else {
            const {$router} = this;
            $router.push({name:"admin"});
          }
        })
      }
    }
  }
</script>
