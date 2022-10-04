```
项目结构：
forum-backend-service           ----root
├─ .gitignore
├─ document
│    └─ dev.md                  ----开发者文档
├─ forum-admin                  ---admin模块          
│    ├─ .gitignore
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    └─ test
│    └─ target
│           └─ classes
├─ forum-comment                -----评论模块
│    ├─ .gitignore
│    ├─ forum-comment.iml
│    ├─ pom.xml
│    └─ src
│           ├─ main
│           └─ test
├─ forum-common                 ----公共模块
│    ├─ .gitignore
│    ├─ forum-common.iml
│    ├─ pom.xml
│    ├─ src
│         └─ main
├─ forum-demo                   ----项目demo,大家如果不熟悉可以看着来开发
│    ├─ .gitignore
│    ├─ forum-demo.iml
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    └─ test
│    └─ target
│           ├─ classes
│           └─ generated-sources
├─ forum-generator              ----代码生成器
│    ├─ .gitignore
│    ├─ forum-generator.iml
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    └─ test
│    └─ target
│           ├─ classes
│           └─ generated-sources
├─ forum-shiro                  ----shiro安全框架
│    ├─ .gitignore
│    ├─ forum-shiro.iml
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    └─ test
│    └─ target
│           ├─ classes
│           └─ generated-sources
├─ forum-topic                  ----主题模块
│    ├─ .gitignore
│    ├─ forum-topic.iml
│    ├─ pom.xml
│    └─ src
│           ├─ main
│           └─ test
├─ forum-user                   ----用户模块
│    ├─ .gitignore
│    ├─ forum-user.iml
│    ├─ pom.xml
│    └─ src
│           ├─ main
│           └─ test
└─ pom.xml
```
# 开发须知
## 配置

- 只是写了demo的配置，如有需要自己在自己的模块分别加上即可
- 使用application.yaml格式

## 初始化

1. 初始化了common模块、generator模块、demo模块、shiro模块

   - common模块是公用模块,已经写好一部分**返回api数据**的格式(4个类,有需要和有想法可以继续加),redis基本配置,swagger基本配置(其他模块需要的话可*继承*此类),全局跨域配置(**未完善**),
   controller层的异常全局捕获(部分实现,大家可以加),一个aop日志webLog以及对RedisTemplate的封装(大家可以选择使用或不使用)
   - generator模块是mybatis-plus的代码生成器,已经简单封装成了一个类,里面需要的参数也已经标明，大家可以使用，也可以自定义自己的一个生成器,模块开发前可以先用代码生成器生成基本结构再进行开发
   - shiro模块是安全框架模块,负责认证、鉴权(不熟悉的可以先去学习),已经写好基本内容和框架了，后面权限增加再进行修改,也是全局生效的
   - demo模块是一个例子模块,只写了一些必要的例子。
   



