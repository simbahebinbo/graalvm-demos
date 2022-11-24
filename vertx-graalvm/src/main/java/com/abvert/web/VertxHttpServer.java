package com.abvert.web;


import com.abvert.web.verticle.MainVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;


public class VertxHttpServer {
    public static void main(String[] args) {
        VertxOptions vertxOptions = new VertxOptions();
        Vertx vertx = Vertx.vertx(vertxOptions);

        //部署http服务器
        vertx.deployVerticle(MainVerticle.class.getName(),
                new DeploymentOptions().setInstances(VertxOptions.DEFAULT_EVENT_LOOP_POOL_SIZE), res -> {
                    if (res.succeeded()) {
                        System.out.println("服务端部署成功----");
                    } else {
                        System.out.println("服务端部署失败---" + res.cause());
                    }
                });
    }
}
