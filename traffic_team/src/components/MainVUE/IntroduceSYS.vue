<template>
  <div class="introducesys">
    <div>
      <el-carousel :interval="4000" type="card" height="200px">
        <el-carousel-item v-for="item in imagesbox" :key="item.id">
          <img :src="item.src">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="d1">
      <h1>河南高校交通教育联盟</h1>
      <p><span>河南省高校交通教育联盟要把开展交通类人才培养研究，推进联盟会员教育改革创新作为基础性工作，指导会员单位把握交通行业人才培养规律，
        围绕交通行业需求，加强科学发展规划，加快学科和专业结构调整。河南省高校交通教育联盟系统紧紧围绕人才培养需要、科技创新需要和社会服务需要,
        指导会员单位加强科学谋划,推动会员单位在教学工作、学生培养、教师培训、学科建设、科学研究等方面开展全方位的合作与交流,努力构建具有河南特色
        的交通教育体系。整合全省交通教育资源，建立交通行业人才培养、科学研究、社会服务、国际合作的相对稳定的合作机制，具体落实教育部和河南
        省“一带一路”教育行动计划，对服务河南省“三区一群”和“空中丝绸之路”的建设，推动交通事业更好更快发展具有重要意义。</span></p>
    </div>
  </div>

</template>
<script>
  export default {
    data() {
      return {
        imagesbox: [{
          id: 1,
          src: 'static/img/traffic1.png',
        }, {
          id: 2,
          src: 'static/img/traffic2.jpg',
        }, {
          id: 3,
          src: 'static/img/traffic3.png',
        }, {
          id: 4,
          src: 'static/img/traffic4.png',
        },]
      }
    },
  }
</script>
<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .d1 {
    color: #F0FFFF;
    text-indent: 4em;
    text-size:15px;
    /*font-color:#475669;*/
  }
</style>
