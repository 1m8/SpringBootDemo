# 通过Maven搭建第一个springboot项目

### 知识点

1、***父工程*** pom.xml 文件配置

 pom = 使用maven分模块管理 都会有一个父级项目
 
 Maven POM POM( Project Object Model,项目对象模型 ) 是 Maven 工程的基本工作单元。
 
 packaging ： 打包类型，默认类型jar类型，如果不做配置，maven会将该项目打成jar包
 
 multi-modules ： Maven 3支持Maven项目的多模块（multi-modules）结构。这样的Maven项目也被称为聚合项目，通常由一个父模块和若干个子模块构成。
 
 其中，父模块必须以pom打包类型，同时以<modules>给出所有的子模块。
   
···

    <packaging>pom</packaging>
    <!--统一Jar包版本管理-->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <junit.version>4.12</junit.version>
        <lombok.version>1.16.18</lombok.version>
        <log4j.version>1.2.17</log4j.version>
        <mysql.version>5.1.47</mysql.version>
        <hutool.version>5.3.5</hutool.version>
        <mybatis.spring.boot.version>1.3.0</mybatis.spring.boot.version>
    </properties>
    
···

dependencyManagement 子模块集成后，锁定版本，子module不用写groupID 和 version

dependencyManagement中的依赖只是锁定版本，不会引用依赖，实际依赖以子模块的pom定义为准

```
    <dependencyManagement>
        <dependencies>
                    <!--spring boot 2.2.2-->
                    <dependency>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-dependencies</artifactId>
                        <version>2.2.2.RELEASE</version>
                        <type>pom</type>
                        <scope>import</scope>
                    </dependency>
        </dependencies>
    </dependencyManagement>
```

2、application.yml 配置服务器默认端口。

3、编写第一个启动类
