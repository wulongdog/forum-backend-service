package com.fwf_bbs.forumgenerator.generators;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @className Generation
 * @description 代码生成器
 * @auther wulongdog
 * @date 2022/10/3  22:04
 */
public class Generator {

    private String fileName="";

    private String[] tableName;

    public Generator(String url, String name, String password, String modelName, String[] tableName) {
        DB_URL = url;
        USERNAME = name;
        PASSWORD = password;
        this.tableName = tableName;
        for(String temp:modelName.split("-"))
            fileName += temp;
        XML_PATH = PARENT_DIR + "/"+modelName+"/src/main/resources/mappers";
        ENTITY_PATH = PARENT_DIR + "/"+modelName+"/src/main/java/com/fwf_bbs/"+fileName+"/entity";
        MAPPER_PATH = PARENT_DIR + "/"+modelName+"/src/main/java/com/fwf_bbs/"+fileName+"/mapper";
        SERVICE_PATH = PARENT_DIR + "/"+modelName+"/src/main/java/com/fwf_bbs/"+fileName+"/service";
        SERVICE_IMPL_PATH = PARENT_DIR + "/"+modelName+"/src/main/java/com/fwf_bbs/"+fileName+"/service/impl";
        CONTROLLER_PATH = PARENT_DIR + "/"+modelName+"/src/main/java/com/fwf_bbs/"+fileName+"/controller";
    }

    /**
     * 项目路径
     */
    private String PARENT_DIR = System.getProperty("user.dir");
    /**
     * xml路径
     */
    private String XML_PATH;
    /**
     * entity路径
     */
    private String ENTITY_PATH;
    /**
     * mapper路径
     */
    private String MAPPER_PATH;
    /**
     * service路径
     */
    private String SERVICE_PATH;
    /**
     * serviceImpl路径
     */
    private String SERVICE_IMPL_PATH;
    /**
     * controller路径
     */
    private String CONTROLLER_PATH;
    /**
     * 数据库url
     */
    private String DB_URL;
//    private String DB_URL = "jdbc:mysql://120.25.125.57:3306/blog?useUnicode=true&useSSL=false&characterEncoding=utf8";
    /**
     * 数据库用户名
     */
//    private String USERNAME = "root";
    private String USERNAME;
    /**
     * 数据库密码
     */
    private String PASSWORD;
//    private String PASSWORD = "1346798520lhy";

    public void action() {
        FastAutoGenerator.create(DB_URL, USERNAME, PASSWORD)
                // 全局配置
                .globalConfig(builder -> builder
                        .disableOpenDir()//禁止打开目录
                        .enableSwagger()
                )
                // 包配置
                .packageConfig(builder -> builder
                        .parent("")
                        .xml("mappers")//resource下mappers 需要修改的是 * 不同的模块 * 不同 com.fwf_bbs.*.entity
                        .entity("com.fwf_bbs."+fileName+".entity")
                        .mapper("com.fwf_bbs."+fileName+".mapper")
                        .service("com.fwf_bbs."+fileName+".service")
                        .serviceImpl("com.fwf_bbs."+fileName+".service.impl")
                        .controller("com.fwf_bbs."+fileName+".controller")
                        .pathInfo(getPathInfo())
                )
                // 策略配置
                .strategyConfig(builder -> builder
                        .addInclude(tableName)//包含哪些表
                        .addTablePrefix("t_")//设置过滤表前缀
                        // entity 生成
                        .entityBuilder()
                        .disableSerialVersionUID()//关闭uuid
                        .fileOverride()
                        .enableLombok()
                        .idType(IdType.ASSIGN_ID)
                        .enableTableFieldAnnotation()
                        // controller
                        .controllerBuilder()
                        .fileOverride()
                        .enableRestStyle()//生成@RestController 注解
                        .formatFileName("%sController")// 表名 + Controller
                        // service
                        .serviceBuilder()
                        .fileOverride()
                        .superServiceClass(IService.class)
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                        // mapper
                        .mapperBuilder()
                        .fileOverride()
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                        .superClass(BaseMapper.class)//设置父类
                        .formatMapperFileName("%sMapper")
                        .formatXmlFileName("%sMapper")
                        .enableMapperAnnotation()//开启@mapper注解
                )
//                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    /**
     * 获取路径信息map
     *
     * @return {@link Map <  OutputFile , String> }
     * @author MK
     * @date 2022/4/21 21:21
     */
    private Map<OutputFile, String> getPathInfo() {
        Map<OutputFile, String> pathInfo = new HashMap<>(5);
        pathInfo.put(OutputFile.entity, ENTITY_PATH);
        pathInfo.put(OutputFile.mapper, MAPPER_PATH);
        pathInfo.put(OutputFile.service, SERVICE_PATH);
        pathInfo.put(OutputFile.serviceImpl, SERVICE_IMPL_PATH);
        pathInfo.put(OutputFile.controller, CONTROLLER_PATH);
        pathInfo.put(OutputFile.xml, XML_PATH);
        return pathInfo;
    }

}
