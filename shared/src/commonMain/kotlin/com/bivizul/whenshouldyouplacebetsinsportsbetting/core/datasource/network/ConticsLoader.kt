package com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.network

import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Feed
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

internal class ConticsLoader(
    private val httpClient: HttpClient,
) {

    /*suspend fun simpleCase() {
        val client = HttpClient()
        val data = client.get<String>(GET_UUID)
        Log.i("$BASE_TAG Simple case", data)
    }

    suspend fun bytesCase() {
        val client = HttpClient()
        val data = client.call(GET_UUID).response.readBytes()
        Log.i("$BASE_TAG Bytes case", data.joinToString(" ", "[", "]") { it.toString(16).toUpperCase() })
    }*/

    suspend fun getContics(url: String): Contics {
        val response = httpClient.get(url)
        val status = response.status
        val body = response.body<Contics>()
        return body
    }

}