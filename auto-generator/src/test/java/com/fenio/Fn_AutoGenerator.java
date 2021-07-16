package com.fenio;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class Fn_AutoGenerator {

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
//                .setController("/templates/controller.java.vm")
//                .setService("/templates/service.java.vm")
//                .setServiceImpl("/templates/serviceImpl.java.vm")
                .setEntity("/templates/entity.java.vm")
//                .setMapper("/templates/mapper.java.vm")
                .setXml("/templates/mapper.xml.vm");
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
        // 是否打开输出目录(默认值：null)
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        // 是否覆盖已有文件(默认值：false)
        gc.setFileOverride(true);
        // 去Service的I前缀
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ID_WORKER);
        // 配置时间类型策略（date类型），如果不配置会生成LocalDate类型
        gc.setDateType(DateType.ONLY_DATE);
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
        // Service包名
        pc.setService("service");
        // Entity包名
        pc.setEntity("model");
        // Mapper包名
        pc.setMapper("mapper");
        // ServiceImpl包名
        pc.setServiceImpl("service.impl");
        // Controller包名
        pc.setController("controller");
        // Mapper.xml包名
        pc.setXml("mapper.xml");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


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
        // 是否生成实体时，生成字段注解 默认false;
        strategy.setEntityTableFieldAnnotationEnable(true);

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
        // 在代码生成器主类上配置模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        //执行
        mpg.execute();
    }
}
