package com.shimaoxin.chubbyplan.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：shimaoxin
 * @date ：Created in 2022/3/4 15:38
 * @description：
 */
public class MybatisPlusGenerateUtils {


    public static void main(String[] args) {
        String[] tables = new String[] {"fd_material_category"};
        String[] tablePrefixs = new String[] {"fd"};
        executeCode("com.shimaoxin.chubbyplan",tables,tablePrefixs);
    }

    private static void executeCode(String pack,String[] tables,String[] tablePrefixs) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();


        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setActiveRecord(true);//开启activeRecord模式
        gc.setEnableCache(false);// 不开启XML 二级缓存
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");// 生成文件的输出目录
        gc.setAuthor("石茂新");// 开发人员
        gc.setSwagger2(true);// 如果数据库中字段注解含有""时会出问题，所以暂时不开启实体属性 Swagger2 注解。
        gc.setFileOverride(true);// 是否覆盖已有文件
        gc.setOpen(false);// 是否打开输出目录
        //自定义文件命名，%s会自动填充表实体属性
        //gc.setEntityName("%sModel");
        gc.setXmlName("%sMapper");
        gc.setMapperName("%sMapper");
        //gc.setServiceName("%sService");
        gc.setServiceImplName("%sService");
        //gc.setControllerName("%sController");
        gc.setBaseResultMap(true);// 开启 BaseResultMap（XML中会生成resultMap映射）
        gc.setBaseColumnList(false);// 不生成XML columList
        /**
         * 指定生成的主键的ID类型:
         * a.AUTO：数据库自增
         * b.INPUT：自行输入
         * c.ID_WORKER：分布式全局唯一ID，长整型类型
         * d.UUID：32位UUID字符串
         * e.NONE：无状态
         * f.ID_WORKER_STR：分布式全局唯一ID，字符串类型
         */
        gc.setIdType(IdType.AUTO);
//        gc.setDateType(DateType.ONLY_DATE);// 时间类型对应策略: 只使用 java.util.date 代替
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //dsc.setSchemaName("V_LAW_CAMERA");// 从试图获取
        dsc.setDbType(DbType.MYSQL);

        //自定义数据库表字段类型转换
        //MySqlTypeConvert.processTypeConvert()中存在默认类型转换，如果不是你要的效果可以继承MySqlTypeConvert重写processTypeConvert()方法。
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(globalConfig,fieldType);
            }
        });
        dsc.setUrl("jdbc:mysql://192.168.194.28:3306/chubby_plan?useSSL=false&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Aa@123456");
        mpg.setDataSource(dsc);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(pack);// 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setXml("dao.mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 数据库表映射到实体的命名策略: 下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 数据库表字段映射到实体的命名策略: 下划线转驼峰命名
        strategy.setEntityLombokModel(true);//实体是否为lombok模型（默认 false）
        strategy.setEntitySerialVersionUID(true);//实体是否设置序列化版本标识
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");//设置serviceImpl父类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");//设置mapper父类
        strategy.setInclude(tables);// 需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategy.setControllerMappingHyphenStyle(true);// 驼峰转连字符
        strategy.setTablePrefix(tablePrefixs);// 表名前缀，这样生成的bean里面 就没有前缀了



        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
