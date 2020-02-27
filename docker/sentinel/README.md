# sentinel-dashboard-docker
*Sentinel控制台docker制作*
### 构建镜像
```
docker build -t sentinel:1.7.0 .
```
### 运行
```
docker run --name sentinel -v 宿主机路径/start.sh:/root/start.sh --restart always --privileged=true -p 8099:8099 -d sentinel:1.7.0
```
##### 可自行修改start.sh文件,传递自定义参数,如-Dsentinel.dashboard.auth.password=123456自定义密码
### Sentinel官方文档
> https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D

> https://github.com/spring-cloud-incubator/spring-cloud-alibaba/wiki/Sentinel
