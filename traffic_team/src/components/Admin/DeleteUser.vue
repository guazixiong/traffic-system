<template>
  <el-form label-width="80px">
    <el-form-item label="姓名">
      <el-input v-model="stuName"></el-input>
    </el-form-item>
    <el-form-item label="学校">
      <el-input v-model="School"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即删除</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
  export default {
    data() {
      return {
        stuName: '',
        School: '',
      }
    },
    methods: {
      onSubmit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/deletestudent?stuName=' + this.stuName + '&School=' + this.School,
        }).then(response => {
          const data = response.data;
          console.log(data);
          const {$router} = this;
          $router.push({name: 'ausercontrol'})
        })
      }
    }
  }
</script>
