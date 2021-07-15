package com.fenio;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class Fn_AutoGenerator {

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("/templates-generator/controller.java.vm")
                .setService("/templates-generator/service.java.vm")
                .setServiceImpl("/templates-generator/serviceImpl.java.vm")
                .setEntity("/templates-generator/entity.java.vm")
                .setMapper("/templates-generator/mapper.java.vm")
                .setXml("/templates-generator/mapper.xml.vm");
    }

    /**
     * MyBatis-Plus 官网教程
     * https://baomidou.com
     * https://baomidou.com/guide/
     * <p>
     * 代码生成器
     * https://baomidou.com/guide/generator.html#使用教程
     *
     * @param args
     */
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplate(getTemplateConfig());

        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("modules.flow");
        gc.setOutputDir(/*StringUtils.isEmpty(projectPath) ? "" :*/ projectPath + "/jianzhuj");
        gc.setAuthor("xushengbin@hqwx.com");
        gc.setOpen(false);
        gc.setFileOverride(false);
        // 是否覆盖
        gc.setServiceName("%sService");
        // 去Service的I前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://101.200.178.45:6301/cms_common?useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("plat2_manage");
        dsc.setPassword("xTBJMGPgcJtTiiNmwl37GKM8");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("blog");
        pc.setParent("cn.huanju.edu100.cms.siteapp.infrastructure.repository");
        pc.setEntity("model");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名
        String[] dbTables = new String[]{
                "banner",
                "channel",
                "label",
                "resource_article",
                "resource_article_content",
                "resource_information",
                "resource_relate_channel",
                "resource_relate_label",
                "resource_stat",
                "user_action_agree",
                "resource_stat", //热度值、点赞数等统计数据
                "user_action_agree", //点赞记录 (资源类型 1文章，2视频，3问答，4资料，5招聘)
                "user_action_collect", //收藏记录 (资源类型 1文章，2视频，3问答，4资料，5招聘)
                "user_action_download", //下载记录 (资源类型 1文章，2视频，3问答，4资料，5招聘)
                "user_action_forward", //分享转发记录 (资源类型 1文章，2视频，3问答，4资料，5招聘)
                "user_action_look", //浏览记录 (资源类型 1文章，2视频，3问答，4资料，5招聘)
                "user_relate_channel"//, //用户频道顺序保存
//                "v9_video",
//                "v9_video",
//                "v9_video",
//                "v9_video"
        };
        strategy.setInclude(dbTables);
        //设置要映射的表名
//        strategy.setInclude("hrpt_dataset");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok；
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("deleted");

        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 表前缀
        strategy.setTablePrefix(pc.getModuleName() + "_");

//        // 数据库表配置
//        StrategyConfig strategy = new StrategyConfig();
//        // 数据库表映射到实体的命名策略:下划线转驼峰
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        // 实体是否为lombok模型（默认 false）
//        strategy.setEntityLombokModel(true);
//        // 生成 @RestController 控制器
//        strategy.setRestControllerStyle(true);
//        // 实体类主键名称设置
//        strategy.setSuperEntityColumns("id");
//        // 需要排除的表名，允许正则表达式
//        //strategy.setExclude("***");
//        // 是否生成实体时，生成字段注解 默认false;
//        strategy.setEntityTableFieldAnnotationEnable(true);
//        // 驼峰转连字符
//        strategy.setControllerMappingHyphenStyle(true);
//        // 表前缀
//        strategy.setTablePrefix(pc.getModuleName() + "_");

        // 自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        // 乐观锁
//        strategy.setVersionFieldName("version");
//        strategy.setRestControllerStyle(true);
//        strategy.setControllerMappingHyphenStyle(true); // localhost:8080/hello_id_2
        mpg.setStrategy(strategy);
        //执行
        mpg.execute();
    }
}
