<template>
  <el-form label-width="80px">
    <el-form-item label="发送人">
      <el-input v-model="sendname"></el-input>
    </el-form-item>
    <el-form-item label="收件人">
      <el-input v-model="messagename"></el-input>
    </el-form-item>
    <el-form-item label="时间">
      <el-input v-model="sendtime" placeholder="如:2017/3/20"></el-input>
    </el-form-item>
    <el-form-item label="内容">
      <el-input type="textarea" v-model="messagecontent"></el-input>
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
        sendname:'',
        messagename:'',
        sendtime:'',
        messagecontent:'',
        ifexist:'0'
      }
    },
    methods: {
      onSubmit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/sendmessage?messagename='+this.messagename+'&sendtime='+this.sendtime+'&sendname='+this.sendname+'&messagecontent='+this.messagecontent+'&ifexist='+this.ifexist,
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
