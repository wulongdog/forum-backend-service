```
项目结构：
forum-backend-service
├─ .gitignore
├─ document
│    └─ dev.md
├─ forum-backend-service.iml
├─ forum-common                                                             -公共模块
│    ├─ .gitignore
│    ├─ forum-common.iml
│    ├─ pom.xml
│    ├─ src
│    │    └─ main
│    │           ├─ java
│    │           │    └─ com
│    │           │           └─ fwf_bbs
│    │           │                  └─ forumcommon 
│    │           │                         ├─ api                           --接口返回的数据结构
│    │           │                         ├─ config 
│    │           │                         ├─ entity
│    │           │                         ├─ exception
│    │           │                         └─ service
│                │                                └─ impl
│                └─ resources
│                       ├─ application.yml
│                       └─ logback-spring.xml
├─ forum-config
│    ├─ forum-config.iml
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    │    ├─ java
│    │    │    │    └─ com
│    │    │    │           └─ fwf_bbs
│    │    │    │                  └─ forumconfig
│    │    │    │                         └─ ForumConfigApplication.java
│    │    │    └─ resources
│    │    │           ├─ application.yml
│    │    │           └─ bootstrap.yml
├─ forum-eureka                                                               -注册中心
│    ├─ forum-eureka.iml
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    │    ├─ java
│    │    │    │    └─ com
│    │    │    │           └─ fwf_bbs
│    │    │    │                  └─ forumeureka
│    │    │    │                         └─ ForumEurekaApplication.java
│    │    │    └─ resources
│    │    │           ├─ application.yml
│    │    │           ├─ bootstrap.yml
│    │    │           └─ logback-spring.xml
├─ forum-gateway                                                               -路由中心
│    ├─ forum-gateway.iml
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    │    ├─ java
│    │    │    │    └─ com
│    │    │    │           └─ fwf_bbs
│    │    │    │                  └─ forumgateway
│    │    │    │                         ├─ ForumGatewayApplication.java
│    │    │    │                         ├─ config
│    │    │    │                         └─ filter
│    │    │    │                                └─ TokenFilter.java
│    │    │    └─ resources
│    │    │           ├─ application.yml
├─ forum-generator                                                               -代码生成器
│    ├─ .gitignore
│    ├─ forum-generator.iml
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    │    ├─ java
│    │    │    │    └─ com
│    │    │    │           └─ fwf_bbs
│    │    │    │                  └─ forumgenerator
│    │    │    │                         ├─ DemoGenerator.java
│    │    │    │                         └─ generators
│    │    │    │                                └─ Generator.java
│    │    │    └─ resources
│    │    │           └─ application.yaml
├─ forum-provider                                                               -对外接口
│    ├─ forum-provider-admin                                                    -管理员对外接口
│    │    ├─ forum-provider-admin.iml
│    │    ├─ pom.xml
│    │    └─ src
│    │           ├─ main
│    │           │    ├─ java
│    │           │    │    └─ com
│    │           │    │           └─ fwf_bbs
│    │           │    │                  └─ forumprovideradmin
│    │           │    │                         └─ ForumProviderAdminApplication.java
│    │           │    └─ resources
│    │           │           └─ application.properties
│    ├─ forum-provider-comment                                                   -评论对外接口
│    │    ├─ forum-provider-comment.iml
│    │    ├─ pom.xml
│    │    └─ src
│    │           ├─ main
│    │           │    ├─ java
│    │           │    │    └─ com
│    │           │    │           └─ fwf_bbs
│    │           │    │                  └─ forumprovidercomment
│    │           │    │                         └─ ForumProviderCommentApplication.java
│    │           │    └─ resources
│    │           │           └─ application.properties
│    ├─ forum-provider-demo                                                      -demo 测试
│    │    ├─ forum-provider-demo.iml
│    │    ├─ pom.xml
│    │    ├─ src
│    │    │    ├─ main
│    │    │    │    ├─ java
│    │    │    │    │    └─ com
│    │    │    │    │           └─ fwf_bbs
│    │    │    │    │                  └─ forumproviderdemo
│    │    │    │    │                         ├─ ForumProviderDemoApplication.java
│    │    │    │    │                         ├─ annotation
│    │    │    │    │                         ├─ config
│    │    │    │    │                         ├─ mapper
│    │    │    │    │                         ├─ model
│    │    │    │    │                         ├─ service
│    │    │    │    │                         └─ web
│    │    │    │    │                             ├─controller                 - 对外controller层
│    │    │    │    │                             └─rpc                        - 微服务rpc调用接口实现
│    │    │    │    └─ resources
│    │    │    │           ├─ application.yml
│    │    │    │           └─ bootstrap.yml
│    ├─ forum-provider-topic                                                   -主题对外接口
│    │    ├─ forum-provider-topic.iml
│    │    ├─ pom.xml
│    │    └─ src
│    │           ├─ main
│    │           │    ├─ java
│    │           │    │    └─ com
│    │           │    │           └─ fwf_bbs
│    │           │    │                  └─ forumprovidertopic
│    │           │    │                         └─ ForumProviderTopicApplication.java
│    │           │    └─ resources
│    │           │           └─ application.properties
│    ├─ forum-provider-user                                                   -用户对外接口
│    │    ├─ forum-provider-user.iml
│    │    ├─ pom.xml
│    │    ├─ src
│    │    │    ├─ main
│    │    │    │    ├─ java
│    │    │    │    │    └─ com
│    │    │    │    │           └─ fwf_bbs
│    │    │    │    │                  └─ forumprovideruser
│    │    │    │    │                         ├─ ForumProviderUserApplication.java
│    │    │    │    │                         ├─ config
│    │    │    │    │                         └─ web
│    │    │    │    └─ resources
│    │    │    │           ├─ application.yml
│    │    │    │           └─ bootstrap.yml
│    └─ pom.xml
├─ forum-provider-api                                                         -远程调用接口
│    ├─ forum-provider-admin-api
│    │    ├─ forum-provider-admin-api.iml
│    │    ├─ pom.xml
│    │    └─ src
│    │           ├─ main
│    │           │    ├─ java
│    │           │    │    └─ com
│    │           │    │           └─ fwf_bbs
│    │           │    │                  └─ forumprovideradminapi
│    │           │    │                         └─ ForumProviderAdminApiApplication.java
│    │           │    └─ resources
│    │           │           └─ application.properties
│    ├─ forum-provider-api.iml
│    ├─ forum-provider-comment-api
│    │    ├─ forum-provider-comment-api.iml
│    │    ├─ pom.xml
│    │    └─ src
│    │           ├─ main
│    │           │    ├─ java
│    │           │    │    └─ com
│    │           │    │           └─ fwf_bbs
│    │           │    │                  └─ forumprovidercommentapi
│    │           │    └─ resources
│    │           │           └─ application.properties
│    ├─ forum-provider-demo-api
│    │    ├─ forum-provider-demo-api.iml
│    │    ├─ pom.xml
│    │    ├─ src
│    │    │    └─ main
│    │    │           └─ java
│    │    │                  └─ com
│    │    │                         └─ fwf_bbs
│    │    │                                └─ forumproviderdemoapi
│    │    │                                       ├─ exceptions
│    │    │                                       ├─ model
│    │    │                                       └─ service             -远程调用接口
│    │    │                                           └─hystrix          -远程调用接口熔断/降级类
│    ├─ forum-provider-topic-api
│    │    ├─ forum-provider-topic-api.iml
│    │    ├─ pom.xml
│    │    └─ src
│    │           ├─ main
│    │           │    ├─ java
│    │           │    │    └─ com
│    │           │    │           └─ fwf_bbs
│    │           │    │                  └─ forumprovidertopicapi
│    │           │    └─ resources
│    │           │           └─ application.properties
│    ├─ forum-provider-user-api
│    │    ├─ forum-provider-user-api.iml
│    │    ├─ pom.xml
│    │    └─ src
│    │           └─ main
│    │                  └─ java
│    │                         └─ com
│    │                                └─ fwf_bbs
│    │                                       └─ forumprovideruserapi
│    └─ pom.xml
├─ forum-shiro
│    ├─ .gitignore
│    ├─ forum-shiro.iml
│    ├─ pom.xml
│    ├─ src
│    │    ├─ main
│    │    │    ├─ java
│    │    │    │    └─ com
│    │    │    │           └─ fwf_bbs
│    │    │    │                  └─ forumshiro
│    │    │    │                         ├─ config
│    │    │    │                         │    └─ ShiroConfig.java
│    │    │    │                         ├─ entity
│    │    │    │                         │    ├─ JwtMeg.java
│    │    │    │                         │    └─ ShiroAuthToken.java
│    │    │    │                         ├─ filter
│    │    │    │                         │    └─ ShiroAuthFilter.java
│    │    │    │                         ├─ matcher
│    │    │    │                         │    └─ ShiroMatcher.java
│    │    │    │                         ├─ realm
│    │    │    │                         │    └─ ShiroRealm.java
│    │    │    │                         └─ utils
│    │    │    │                                └─ JwtTokenUtil.java
│    │    │    └─ resources
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
   



