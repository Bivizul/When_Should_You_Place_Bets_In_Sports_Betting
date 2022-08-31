package com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.network

import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Feed
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

internal class FeedLoader(
    private val httpClient: HttpClient,
    private val feedParser: FeedParser
) {

    suspend fun getFeed(url: String, isDefault: Boolean): Feed {
        val xml = httpClient.get(url).bodyAsText()
        return feedParser.parse(url, xml, isDefault)
    }

}