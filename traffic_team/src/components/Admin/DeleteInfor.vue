<template xmlns="">
  <el-form label-width="80px">
    <el-form-item label="标题">
      <el-input v-model="title"></el-input>
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
        title: '',
      }
    },
    methods: {
      onSubmit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/deleteinfor?title=' + this.title,
        }).then(response => {
          const data = response.data;
          console.log(data);
          const {$router} = this;
          $router.push({name: 'findinfor'})
        })
      }
    }
  }
</script>
