package com.abvert.web.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;

import java.util.concurrent.TimeUnit;


public class MainVerticle extends AbstractVerticle {

    private HttpServer httpServer;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        HttpServerOptions options = new HttpServerOptions()
                .setIdleTimeout(10000)
                .setIdleTimeoutUnit(TimeUnit.MILLISECONDS)
                .setTcpKeepAlive(true);

        httpServer = vertx.createHttpServer(options);


        Router router = Router.router(vertx);

        router.route("/hello").handler(rc -> {
            System.out.println("Got hello request");
            rc.response().end("World");
        });

        httpServer.requestHandler(router).listen(8080, "0.0.0.0", res -> {
            if (res.succeeded()) {
                System.out.println("start server success!");
                startPromise.complete();
            } else {
                System.out.println("start server failed! " + res.cause());
                startPromise.fail(res.cause());
            }
        });

    }
}
