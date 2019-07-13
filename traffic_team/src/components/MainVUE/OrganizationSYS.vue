<template>
  <div class="organization">
    <h2>理事位单位</h2>
    <span>中原工学院</span>
    <el-image :src="src1" style="width: 100px; height: 100px;"></el-image>
    <h2>常务副理事长单位</h2>
    <span>xxxx大学</span>
    <el-image :src="src2" style="width: 100px; height: 100px;"></el-image>
    <h2>副理事长单位</h2>
    <span>xxxx大学</span>
    <el-image :src="src3" style="width: 100px; height: 100px;"></el-image>
    <h2>理事单位提名</h2>
    <span>xxxx大学</span>
    <el-image :src="src4" style="width: 100px; height: 100px;"></el-image>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        src1: 'static/img/中原工学院.jpg',
        src2: 'static/img/默认头像.jpg',
        src3: 'static/img/默认头像.jpg',
        src4: 'static/img/默认头像.jpg',
      }
    }
  }
</script>
<style>

</style>
