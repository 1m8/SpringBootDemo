### API文档：

https://codecentric.github.io/spring-boot-admin/2.2.3/#getting-started

### spring boot Admin 简介

codecentric’s Spring Boot Admin is a community project to manage and monitor your Spring Boot ® applications. The applications register with our Spring Boot Admin Client (via HTTP) or are discovered using Spring Cloud ® (e.g. Eureka, Consul). The UI is just a Vue.js application on top of the Spring Boot Actuator endpoints.

### 快速使用

spring boot admin 分为客户端和服务端，服务端用于图形化界面显示所有client的状态。

1、创建服务端

```
dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-server</artifactId>
    <version>2.2.3</version>
</dependency>

```

启动类需增加注解

@EnableAdminServer

```
@EnableAdminServer
@SpringBootApplication
public class AdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}

```

2、创建客户端

```
 <dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
    <version>2.2.3</version>
</dependency>
<!--权限验证-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

```

修改配置文件，8090为服务端端口

```
server:
  port: 8080

spring:
  security:
    user:
      name: user
      password: 123456
  boot:
    admin:
      client:
        # 服务端地址
        url: http://localhost:8090/
        instance:
          metadata:
            user.name: ${spring.security.user.name}
            user.password: ${spring.security.user.password}

management:
  endpoint:
    health:
      show-details: always
      roles: user
  # 设置端点暴露的哪些内容，默认["health","info"]，设置"*"代表暴露所有可访问的端点
  endpoints:
    web:
      exposure:
        include: '*'


```

启动项目，访问 http://localhost:8090/
