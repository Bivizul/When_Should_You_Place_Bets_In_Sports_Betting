package com.bivizul.whenshouldyouplacebetsinsportsbetting.core

import android.content.Context
import com.bivizul.whenshouldyouplacebetsinsportsbetting.ConticReader
import com.bivizul.whenshouldyouplacebetsinsportsbetting.RssReader
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.network.ConticsLoader
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.network.FeedLoader
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.storage.ConticStorage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.storage.FeedStorage
import com.russhwolf.settings.AndroidSettings
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.serialization.json.Json

fun ConticReader.Companion.create(ctx: Context, withLog: Boolean) = ConticReader(
    ConticsLoader(
        AndroidHttpClient(withLog)
    ),
    ConticStorage(
        AndroidSettings(ctx.getSharedPreferences("contic_reader_pref", Context.MODE_PRIVATE)),
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
    )
).also {
    if (withLog) Napier.base(DebugAntilog())
}