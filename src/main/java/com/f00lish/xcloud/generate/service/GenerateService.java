package com.f00lish.xcloud.generate.service;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.f00lish.xcloud.generate.task.GenerateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author f00lish
 * @version 2018/4/26
 * Created By IntelliJ IDEA.
 * Qun:530350843
 */
@Service
public class GenerateService {

    private GlobalConfig globalConfig;

    private DataSourceConfig dataSourceConfig;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    private StrategyConfig strategyConfig;

    private PackageConfig packageConfig;

    private EntityNameRewriter entityNameRewriter;

    @PostConstruct
    public void init(){

        globalConfig= new GlobalConfig();
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(false);
        // XML 二级缓存
        globalConfig.setEnableCache(false);
        // XML ResultMap
        globalConfig.setBaseResultMap(true);
        // XML columList
        globalConfig.setBaseColumnList(true);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");

        // 数据源配置
        dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName(dataSourceProperties.getDriverClassName());
        dataSourceConfig.setUsername(dataSourceProperties.getUsername());
        dataSourceConfig.setPassword(dataSourceProperties.getPassword());
        dataSourceConfig.setUrl(dataSourceProperties.getUrl());

        // 策略配置
        strategyConfig = new StrategyConfig();
        // 表名生成策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        // 自定义 service 父类
        strategyConfig.setSuperServiceClass("com.f00lish.xcloud.common.base.service.SuperService");
        // 自定义 service 实现类父类
        strategyConfig.setSuperServiceImplClass("com.f00lish.xcloud.common.base.service.impl.SuperServiceImpl");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityBuilderModel(true);

        packageConfig = new PackageConfig();
        packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setXml("mapper.xml");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");

        entityNameRewriter = new EntityNameRewriter();

    }


    /**
     * 生成代码
     * @param generateTask
     */
    public void generate(GenerateTask generateTask){
        AutoGenerator autoGenerator = new AutoGenerator();
        //只生成实体类
        if(generateTask.getOnlyGenerateEntity() != null && generateTask.getOnlyGenerateEntity()){
            TemplateConfig templateConfig = new TemplateConfig();
            templateConfig.setXml(null);
            templateConfig.setController(null);
            templateConfig.setMapper(null);
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
            autoGenerator.setTemplate(templateConfig);
        }else{
            // 关闭默认 xml 生成，调整生成 至 根目录
            TemplateConfig templateConfig = new TemplateConfig();
//            templateConfig.setXml(null);
            autoGenerator.setTemplate(templateConfig);
        }

        // 全局配置
        globalConfig.setOutputDir(generateTask.getProjectLocation() + "/src/main/java");
        globalConfig.setAuthor(generateTask.getDeveloper());
        // 此处可以修改为您的表前缀
        strategyConfig.setTablePrefix(new String[] { generateTask.getTablePrefix()});
        strategyConfig.setInclude(new String[] { generateTask.getTableName() });
        // 包配置
        packageConfig.setParent(generateTask.getPackageName());
        packageConfig.setModuleName(generateTask.getModule());
        entityNameRewriter.setEntityName(generateTask.getEntityName());
        // 执行生成
        autoGenerator.setCfg(entityNameRewriter);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setPackageInfo(packageConfig);

        autoGenerator.execute();
    }
}
