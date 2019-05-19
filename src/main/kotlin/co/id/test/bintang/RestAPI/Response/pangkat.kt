package co.id.test.bintang.RestAPI.Response

import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import kotlin.math.pow

/*
* Class Pangkat
* */

class pangkat(val value: Double,val pangkat:Int){
  fun resultJson(): String {
    return json{obj("value" to value, "pangkat" to pangkat, "result" to (value.pow(pangkat))).encode()}
  }
}
