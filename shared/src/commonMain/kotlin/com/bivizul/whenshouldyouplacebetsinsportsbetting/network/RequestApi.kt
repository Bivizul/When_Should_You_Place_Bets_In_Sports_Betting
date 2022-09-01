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
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class RequestApi {

    val client = HttpClient(CIO) {
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
        val response = client.get(url)
        val body = response.body<Contics>()
        return body
    }

    suspend fun getResspliska(spliska: Spliska): Resspliska {
        val url = "http://65.109.10.118/26WhenShouldYouPlaceBetsInSportsBetting/spliska.php"
        val response = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(spliska)
        }
        val body = response.body<Resspliska>()
        return body
    }

}