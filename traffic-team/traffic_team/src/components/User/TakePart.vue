<template>
  <el-form label-width="80px">
    <el-form-item label="活动名称">
      <el-input v-model="meetname"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即报名</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>


</template>>
<script>
  export default {
    data() {
      return {
        meetname: '',
        obj:'',
      }
    },
    methods: {
      onSubmit() {
        var infostr=sessionStorage.obj;
        this.obj=JSON.parse(infostr);
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/student/takepart?meetname='+this.meetname+'&obj='+this.obj,
        }).then(response => {
           const data=response.data;
           console.log(data);
           if(data==0){
             const {$router}=this;
             $router.push({name:'defeat1'})
           }
           else{
             const {$router}=this;
             $router.push({name:'user'})
           }
        }).catch(function () {
          alert(error.error);
        })
      }
    }
  }
</script>
