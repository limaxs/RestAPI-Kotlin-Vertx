package co.id.test.bintang.RestAPI.Response

import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj

/*
* Class Perkalian
* */

class perkalian(val a: Int,val b:Int){
  fun resultJson(): String {
      return json{obj("a" to a, "b" to b, "result" to (a*b)).encode()}
  }
}
