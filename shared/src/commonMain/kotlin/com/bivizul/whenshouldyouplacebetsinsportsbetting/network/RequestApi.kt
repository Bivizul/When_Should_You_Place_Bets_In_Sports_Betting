package com.bivizul.whenshouldyouplacebetsinsportsbetting.network

import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Resspliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Spliska
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.ContentDisposition.Companion.File
import io.ktor.http.content.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.reflect.*
import io.ktor.utils.io.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.json.Json

class RequestApi {

    val a = ContentType.Application.Any

    val httpClient = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO

        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getContics(): Contics {
        val url = "http://65.109.10.118/26WhenShouldYouPlaceBetsInSportsBetting/contics.json"
        val response = httpClient.get(url)
//        val status = response.status
        val body = response.body<Contics>()
        return body
    }

    suspend fun getResspliska(spliska: Spliska): Resspliska {
        println("print spliska : $spliska")
        val url = "http://65.109.10.118/26WhenShouldYouPlaceBetsInSportsBetting/spliska.php"
        val response = httpClient.post(url) {
            contentType(ContentType.Application.Json)
            setBody(spliska)
        }
        val status = response.status
        println("api status : $status")
        val body = response.body<Resspliska>()
        println("body : $body")
        return body
    }

    /*suspend fun getImage(urlImage: String) {
        val url = Url(urlImage)
//        val file = File.parameter(url.pathSegments.last())
//        val a = url.pathSegments.last()
        val file = File(url.pathSegments.last())
        httpClient.get(url).bodyAsChannel().copyAndClose(file.writeChannel())
        println("Finished downloading..")
    }*/

    /*suspend fun getImage() {
        val url = "http://65.109.10.118/26WhenShouldYouPlaceBetsInSportsBetting/v.jpg"
        val response = httpClient.get(url)
//        val status = response.status
        val body = response.body()
        println("Finished downloading..")
    }

    suspend fun HttpClient.downloadFile(file: File, url: String, callback: suspend (boolean: Boolean) -> Unit) {
        val call = call {
            url(url)
            method = HttpMethod.Get
        }
        if (!call.response.status.isSuccess()) {
            callback(false)
        }
        call.response.content.copyAndClose(file.writeChannel())
        return callback(true)
    }*/

}