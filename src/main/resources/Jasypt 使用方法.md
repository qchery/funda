# Jasypt 使用方式

使用 java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="encrypt-data" password=funda algorithm=PBEWithMD5AndDES


- input : 需要加密的数据
- password : 加密 salt，需要与 application.yml 配置
- algorithm : 加密算法

执行上面命令后，会输出类似如下内容：
```
----ENVIRONMENT-----------------

Runtime: Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 25.111-b14



----ARGUMENTS-------------------

algorithm: PBEWithMD5AndDES
input: root
password: funda



----OUTPUT----------------------
```

<font color=#ff0000 >OnpwLOwQKN22SYtNhFtR1g==</font>

红色部分为加密输出，将其配置到 application.yml(或 application.properties)

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8
    username: ENC(OnpwLOwQKN22SYtNhFtR1g==)
    password: ENC(76GTvcCwJQyM+b+Y4e7PUg==)
    driver-class-name: com.mysql.jdbc.Driver
    show-sql: true
```

注意：ENC 这个关键字是必须的。用来标识该数据值是加密的。

配置 jasypt 的加密方式及加密 salt。

```
jasypt:
  encryptor:
    password: funda
    algorithm: PBEWithMD5AndDES
```

参考链接： http://www.ru-rocker.com/2017/01/13/spring-boot-encrypting-sensitive-variable-properties-file/