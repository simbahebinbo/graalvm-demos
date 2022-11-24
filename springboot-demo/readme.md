# Springboot Native

## 构建原生应用

打包和测试

``` 
$ mvn clean -Pnative package
```

打包

``` 
$ mvn clean -Pnative package -DskipTests
```

测试

```
$ mvn clean test
```

运行

```
$ ./target/springboot-demo
```

## 构建docker镜像

```
mvn clean -U -DskipTests spring-boot:build-image

[INFO]     [creator]       BellSoft Liberica NIK 17.0.5: Contributing to layer
[INFO]     [creator]         Downloading from https://download.bell-sw.com/vm/22.3.0/bellsoft-liberica-vm-core-openjdk17.0.5+8-22.3.0+2-linux-amd64.tar.gz

到这一步很慢
```

运行

```
docker run --rm -p 8080:8080 springboot-demo:1.0.0
```

