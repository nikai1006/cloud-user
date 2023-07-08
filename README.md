# cloud-user

-  项目介绍\
cloud-user

- 目录结构

|---pom.xml\
|---src\
|---|---main\
|---|---|---java\
|---|---|---resources\
|---|---|---filters\
|---|---test\
|---|---|---java\
|---|---|---resources\
|---|---|---filters\
|---|---assembly\
|---|---|---assembly.xml\
|---|---docker\
|---|---|---Dockerfile\
|---|---ops\
|---|---|---run.sh\
|---LICENSE.txt\
|---NOTICE.txt\
|---README.md  
|---Jenkinsfile

-  软件架构
软件架构说明


-  安装教程

1. 构建命令 
```shell script
mvnd clean javadoc:javadoc -Papi-doc -Ddoclint=none
```
2. 下载源码
```shell script
mvn dependency:sources
```
3. 下载文档
```shell script
mvn dependency:resolve -Dclassifier=javadoc
```

-  使用说明

1. xxxx
2. xxxx
3. xxxx

-  参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


