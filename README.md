# naga
基于cola架构风格的springboot框架，集成了常见的组件。在确保兼容的情况下，各个组件尽可能采用最新版本。

给自己用的基础框架，怎么方便怎么来。
前期先简单集成各种开发中常见的框架，工具， 后续会考虑分类，并以starter的方式简化各种配置，以方便有需要的裁减,尽量做到 out-of-box .


虽然尽量地确认了各个组件的依赖情况和版本，但不可避免可能会有些遗漏，欢迎提issue。

当前组件及列表:


|组件|版本|最新版本|说明
-|-|-|-
jdk | 17 | 21 |-
springboot | 3.1.6 | 3.2.0 |-
lombok  | 1.18.30 | 1.18.30 | - 
mybatis-plus  | 3.5.4.1 | 3.5.4.1 | 简单orm框架 
 jakarta.el-api | 5.0.1 | 5.0.1 |  -
fastjson  | 2.0.42 | 2.0.42 |  |
 junit-jupiter | 5.10.1 | 5.10.1 | 测试框架  
 junit-platform-suite-engine | 1.10.1 | 1.10.1 | 测试套件
testcontainers  | 1.19.3 | 1.19.3 | 跑测试用例很爽 
 flyway | 10.0.1 | 10.0.1 | 数据库维护用 
 commons-lang3 | 3.14.0 | 3.14.0 | -
druid  | 1.2.20 | 1.2.20 | jdbc连接池 
 jakarta.xml.bind-api | 4.0.1 | 4.0.1 | -
 swagger-starter | 2.2.0 | 2.2.0 | api doc |
 swagger-ui | 1.7.0 | 1.7.0 |  |
 shardingsphere | 5.4.2-SNAPSHOT | 5.4.1 | 修改了官方的版本 |
