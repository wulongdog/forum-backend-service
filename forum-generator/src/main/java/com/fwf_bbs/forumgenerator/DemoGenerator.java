package com.fwf_bbs.forumgenerator;

import com.fwf_bbs.forumgenerator.generators.Generator;

/**
 * @className DemoGenerator
 * @description demo 代码生成器
 * @auther wulongdog
 * @date 2022/10/3  19:57
 */
public class DemoGenerator {

    public static void main(String[] args) {

        new Generator("jdbc:mysql://120.25.125.57:3306/blog?useUnicode=true&useSSL=false&characterEncoding=utf8","root","1346798520lhy","forum-demo",new String[]{"t_note"}).action();
    }
}
