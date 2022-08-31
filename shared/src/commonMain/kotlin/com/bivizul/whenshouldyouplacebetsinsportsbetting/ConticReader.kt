package com.bivizul.whenshouldyouplacebetsinsportsbetting

import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.network.ConticsLoader
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.storage.ConticStorage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Feed
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class ConticReader internal constructor(
//    private val feedLoader: FeedLoader,
//    private val conticStorage: FeedStorage,
    private val conticsLoader: ConticsLoader,
    private val conticStorage: ConticStorage,
//    private val settings: Settings = Settings(setOf("https://blog.jetbrains.com/kotlin/feed/"))
    private val settings: Settings = Settings(setOf("https://google.com"))
) {
    @Throws(Exception::class)
    suspend fun getAllFeeds(
        forceUpdate: Boolean = false
    ): List<Contics> {
        var feeds = conticStorage.getAllFeeds()

        if (forceUpdate || feeds.isEmpty()) {
            val feedsUrls = if (feeds.isEmpty()) settings.defaultConticsUrls else feeds.map { it.sourceUrl }
            feeds = feedsUrls.mapAsync { url ->
                val new = conticsLoader.getContics(url, settings.isDefault(url))
                conticStorage.saveFeed(new)
                new
            }
        }

        return feeds
    }

    @Throws(Exception::class)
    suspend fun addContic(url: String) {
        val contics = conticsLoader.getContics(url)
        conticStorage.saveFeed(contics)
    }

    @Throws(Exception::class)
    suspend fun deleteContic(url: String) {
        conticStorage.deleteFeed(url)
    }

    private suspend fun <A, B> Iterable<A>.mapAsync(f: suspend (A) -> B): List<B> =
        coroutineScope { map { async { f(it) } }.awaitAll() }

    companion object
}
