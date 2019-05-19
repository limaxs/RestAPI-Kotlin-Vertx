package co.id.test.bintang.RestAPI

import co.id.test.bintang.RestAPI.Handle.pangkatHandle
import co.id.test.bintang.RestAPI.Handle.perkalianHandle
import co.id.test.bintang.RestAPI.Response.echo
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler

class MainVerticle : AbstractVerticle() {

  override fun start(startFuture: Future<Void>) {
      val vertx = Vertx.vertx()
      val port = 9532 //Port Server

    //Init Route Path
      val router = Router.router(vertx)
      router.route().handler(BodyHandler.create())
      router.get("/").handler({req -> req.response().end("Welcome to My First RestAPI using Kotlin and Vertx!")})
      router.get("/api/echo").handler({ctx -> ctx.response().endWithJson(echo())})
      router.post("/api/perkalian").handler(perkalianHandle)
      router.post("/api/pangkat").handler(pangkatHandle)

      vertx.createHttpServer().requestHandler(router).listen(port)

  }

  fun HttpServerResponse.endWithJson(obj: Any) {
    this.putHeader("Content-Type", "application/json; charset=utf-8").end(Json.encodePrettily(obj))
  }
}

