

启动 zipkin server
```shell
$ docker run -d \
  -e RABBIT_ADDRESSES=192.168.163.41:5672 \
  -e RABBIT_USER=admin \
  -e RABBIT_PASSWORD=123456 \
  -e RABBIT_VIRTUAL_HOST=/dev \
  -e RABBIT_QUEUE=zipkin \
  -p 9411:9411 openzipkin/zipkin:2.15.0
```

使用 ES 作为存储
```shell
$ docker run -d \
  -e RABBIT_ADDRESSES=192.168.163.41:5672 \
  -e RABBIT_USER=admin \
  -e RABBIT_PASSWORD=123456 \
  -e RABBIT_VIRTUAL_HOST=/dev \
  -e RABBIT_QUEUE=zipkin \
  -e STORAGE_TYPE=elasticsearch \
  -e ES_HOSTS=192.168.163.41:9200 \
  -p 9411:9411 openzipkin/zipkin:2.15.0
```

> TIPS：指定 ES 用户名和密码的环境变量分别为 ES_USERNAME 和 ES_PASSWORD

浏览器访问

<http://192.168.163.41:9411/zipkin/>

再启动微服务查看效果