# 基础镜像
FROM openjdk:8-jdk-alpine
# author
MAINTAINER wenbin
# 复制jar文件到路径
ADD manager.jar manager.jar
# 时间
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
# 安装应用
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories
RUN apk add fontconfig&&apk add --update ttf-dejavu&&fc-cache&&apk add curl --force
# 启动服务
ENTRYPOINT ["java","-jar","/manager.jar"]
# 暴露端口
EXPOSE 8080
