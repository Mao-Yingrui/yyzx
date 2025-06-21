package com.neutech.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Coding {
    static final String URL = "jdbc:mysql://192.168.75.130:3306/db?serverTimezone=Asia/Shanghai";
    static final String USER = "root";
    static final String PASSWORD = "root";
    public static void main(String[] args) {
        // 项目目录
        String basePath = System.getProperty("user.dir");
        // 生成的表名
        String table = "admin";
        FastAutoGenerator.create(URL, USER, PASSWORD)
                // 全局配置
                // lambda表达式
                .globalConfig(builder -> {
                    // 设置项目路径
                    builder.outputDir(basePath + "/src/main/java")
                            // 配置作者
                            .author("Morrien")
                            .disableOpenDir();
                    // 包配置
                }).packageConfig(builder -> {
                    // 配置父包
                    builder.parent("com.neutech");
                    // 自定义xml生成路径
                    Map<OutputFile, String> PathInfo = new HashMap<>();
                    PathInfo.put(OutputFile.xml, basePath + "/src/main/resources/com/neutech/mapper");
                    builder.pathInfo(PathInfo);
                }).strategyConfig(builder -> {
                    // 配置表名
                    builder.addInclude(table)
                            // 配置entity策略
                            .entityBuilder()
                            // 所有entity 都加lombok注解
                            .enableLombok()
                            // entity类名要从下划线转驼峰
                            .naming(NamingStrategy.underline_to_camel)
                            // 属性名也要下划线转驼峰
                            .columnNaming(NamingStrategy.underline_to_camel)
                            // 配置controller策略
                            .controllerBuilder()
                            // 每一个controller都加@RestController注解
                            .enableRestStyle()
                            // 配置service策略
                            .serviceBuilder()
                            // 去掉service接口前面的I
                            .formatServiceFileName("%sService");
                    // 配置模板引擎
                }).templateEngine(new FreemarkerTemplateEngine())
                // 执行代码生成
                .execute();
        // java中 无法将方法 或者 一段代码 当参数传递， 但是可以利用接口做变体写法
        // 接口和抽象类其实是可以用 new关键词的 ，创建出来的叫做匿名内部类
        // lambda 表达式 是 匿名内部类的简写 要求接口中只能有一个抽象方法 (参数列表) -> { 代码实现 }
        // 如果不加大括号 表示直接return
    }
}