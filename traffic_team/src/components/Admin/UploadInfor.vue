<template>
  <el-form label-width="80px">
    <el-form-item label="标题">
      <el-input v-model="title" placeholder="标题无法二次修改,请核对"></el-input>
    </el-form-item>
    <el-form-item label="院校">
      <el-select v-model="author">
        <el-option label="中原工学院" value="中原工学院"></el-option>
        <el-option label="郑州铁路职业技术学院" value="郑州铁路职业技术学院"></el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="时间">
      <el-input v-model="inforTime" placeholder="如:2017/3/20"></el-input>
    </el-form-item>

    <el-form-item label="内容">
      <el-input type="textarea" v-model="conent"></el-input>
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
        title: '',
        conent: '',
        inforTime: '',
        author: '',
        name: '',
      }
    },
    methods: {
      onSubmit() {
        this.$http({
          method: 'get',
          url: 'http://localhost:9527/traffic/admin/uploadinfo?title=' + this.title + '&conent=' + this.conent + '&inforTime=' + this.inforTime + '&author=' + this.author,
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
