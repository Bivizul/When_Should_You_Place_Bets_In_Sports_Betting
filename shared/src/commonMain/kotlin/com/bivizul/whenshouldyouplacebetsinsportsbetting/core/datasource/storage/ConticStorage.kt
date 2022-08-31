package com.bivizul.whenshouldyouplacebetsinsportsbetting.core.datasource.storage

import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Feed
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNull.serializer

class ConticStorage(
    private val settings: Settings,
    private val json: Json
) {
    private companion object {
        private const val KEY_CONTICS_CACHE = "key_contic_cache"
    }

    private val _contics = MutableStateFlow<Contics>(Contics("", emptyList()))
    val contics : StateFlow<Contics> = _contics.asStateFlow()



    private var diskCache: Map<String, Contics>
        get() {
            return settings.getStringOrNull(KEY_CONTICS_CACHE)?.let { str ->
                json.decodeFromString(ListSerializer(Contics.serializer()), str)
                    .associate { it.sourceUrl to it }
            } ?: mutableMapOf()
        }
        set(value) {
            val list = value.map { it.value }
            settings[KEY_CONTICS_CACHE] =
                json.encodeToString(ListSerializer(Contics.serializer()), list)
        }

    private val memCache: MutableMap<String, Contics> by lazy { diskCache.toMutableMap() }

    suspend fun getContic(url: String): Contics? = memCache[url]

//    suspend fun saveContics(contics: Contics) {
//        memCache[contics.sourceUrl] = feed
//        diskCache = memCache
//    }

    suspend fun deleteContics(url: String) {
        memCache.remove(url)
        diskCache = memCache
    }

    suspend fun getAllContics(): List<Contics> = memCache.values.toList()
}