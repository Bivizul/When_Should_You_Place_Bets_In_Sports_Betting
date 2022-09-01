package com.bivizul.whenshouldyouplacebetsinsportsbetting.repository

import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Resspliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Spliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.network.RequestApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class SpliskaRepository() {

    private val requestApi = RequestApi()

    private val _resspliska = MutableSharedFlow<Resspliska>()
    val resspliska : SharedFlow<Resspliska> = _resspliska.asSharedFlow()

    suspend fun getResspliska(spliska: Spliska){
        val response = requestApi.getResspliska(spliska)
        _resspliska.emit(response)
    }

}