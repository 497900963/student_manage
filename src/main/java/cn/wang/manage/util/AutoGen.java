//package cn.wang.manage.util;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
///**
// * @Program: k9_tms
// * @Description: 自动生成代码
// * @Author: wei.wang
// * @Date: 2021-04-05 17:32
// **/
//public class AutoGen {
//    public static void main(String[] args) {
//        //1，创建一个生成器
//        AutoGenerator autoGenerator = new AutoGenerator();
//
//        //2，配置生成器全局信息
//        GlobalConfig globalConfig = new GlobalConfig();
//
//        globalConfig.setAuthor("wangwei");//作者
//        globalConfig.setMapperName("%sDao");//mapper接口的后缀
//        globalConfig.setServiceName("%sService");//server接口的后缀
//        globalConfig.setServiceImplName("%sServiceImpl");//ServerImpl接口的后缀
//        globalConfig.setControllerName("%sController");//Controller接口的后缀
//        globalConfig.setOutputDir("/Users/wangwei/myp");//导出位置
//        globalConfig.setFileOverride(true);//是否覆盖
//
//        autoGenerator.setGlobalConfig(globalConfig);
//
//        //3，数据源配置
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//
//        dataSourceConfig.setDbType(DbType.MYSQL);
//        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
//        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
//        dataSourceConfig.setUsername("root");
//        dataSourceConfig.setPassword("java");
//
//        autoGenerator.setDataSource(dataSourceConfig);
//
//        //4，生成策略配置
//        StrategyConfig strategyConfig = new StrategyConfig();
//
//        strategyConfig.setTablePrefix("stu");//表前缀
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//命名方式，下划线转驼峰法
//        strategyConfig.setEntityLombokModel(true);//配置Lombok
//        strategyConfig.setRestControllerStyle(true);//配置RestController
//
//        autoGenerator.setStrategy(strategyConfig);
//
//        //5，包的生成策略
//
//        PackageConfig packageConfig = new PackageConfig();
//
//        packageConfig.setParent("cn.wang.manage");
//        packageConfig.setEntity("entity");
//        packageConfig.setMapper("dao");
//        packageConfig.setController("controller");
//        packageConfig.setService("service");
//        packageConfig.setServiceImpl("service.impl");
//
//        autoGenerator.setPackageInfo(packageConfig);
//
//        //6，执行
//        autoGenerator.execute();
//    }
//}
