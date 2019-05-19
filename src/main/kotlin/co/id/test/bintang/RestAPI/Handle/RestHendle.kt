package co.id.test.bintang.RestAPI.Handle

import co.id.test.bintang.RestAPI.Response.pangkat
import co.id.test.bintang.RestAPI.Response.perkalian
import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import java.lang.NumberFormatException
import java.lang.Double.parseDouble
/**
 * Service handle saat route di panggil
 * **/
////Handle Service Untuk perkalian
val perkalianHandle = Handler<RoutingContext> { ctx ->
  try {
    val a = Integer.parseInt(ctx.request().getParam("a"))
    val b = Integer.parseInt(ctx.request().getParam("b"))
    var result = perkalian(a, b)

    ctx.response().setStatusCode(200).end(result.resultJson())
  } catch (e: Exception) {
    ctx.response().setStatusCode(500).end(json { obj("error" to e).encode() })
  }
}

//Handle Service Untuk perkalian
val pangkatHandle = Handler<RoutingContext> { ctx ->
  try {
    val value = parseDouble(ctx.request().getParam("value"))
    val pangkatValue = Integer.parseInt(ctx.request().getParam("pangkat"))
    var result = pangkat(value, pangkatValue)

    ctx.response().setStatusCode(200).end(result.resultJson())
  } catch (e: NumberFormatException) {
    ctx.response().setStatusCode(500).end(json { obj("error" to e.message).encode() })
  }
}

