package com.fenio;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-07-15
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 项目根目录
//        String projectPath = System.getProperty("user.dir");
        // 用于多个模块下生成到精确的目录下（我设置在桌面）
        String projectPath = System.getProperty("modules.flow");
        gc.setOutputDir(/*StringUtils.isEmpty(projectPath) ? "" :*/ projectPath + "/jianzhuj");
        // 代码生成目录
//        gc.setOutputDir(projectPath + "/src/main/java");
        // 开发人员
        gc.setAuthor("xushengbin@hqwx.com");
        // 是否打开输出目录(默认值：null)
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        // 是否覆盖已有文件(默认值：false)
        gc.setFileOverride(true);
        //去掉接口上的I
        gc.setServiceName("%Service");
        // 配置时间类型策略（date类型），如果不配置会生成LocalDate类型
        gc.setDateType(DateType.ONLY_DATE);
        //把全局配置添加到代码生成器主类
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://101.200.178.45:6301/cms_common?useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("plat2_manage");
        dsc.setPassword("xTBJMGPgcJtTiiNmwl37GKM8");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

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

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 添加这个后 会以一个实体为一个模块 比如user实体会生成user模块 每个模块下都会生成三层
        // pc.setModuleName(scanner("模块名"));
        // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("com.xxgg.blog");
        // Service包名
        pc.setService("service");
        // Entity包名
        pc.setEntity("model");
        // ServiceImpl包名
        pc.setServiceImpl("service.impl");
        // Mapper包名
        pc.setMapper("mapper");
        // Controller包名
        pc.setController("controller");
        // Mapper.xml包名
        pc.setXml("mapper");
        // 把包配置添加到代码生成器主类
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

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 数据库表配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略:下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 实体是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        // 生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        // 实体类主键名称设置
        strategy.setSuperEntityColumns("id");
        // 需要包含的表名，允许正则表达式
        // 这里做了输入设置
        strategy.setInclude(dbTables);
        // 需要排除的表名，允许正则表达式
        //strategy.setExclude("***");
        // 是否生成实体时，生成字段注解 默认false;
//        strategy.setEntityTableFieldAnnotationEnable(true);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 表前缀
        strategy.setTablePrefix(pc.getModuleName() + "_");

        // 把数据库配置添加到代码生成器主类
        mpg.setStrategy(strategy);
        // 在代码生成器主类上配置模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 生成
        mpg.execute();
    }
}
