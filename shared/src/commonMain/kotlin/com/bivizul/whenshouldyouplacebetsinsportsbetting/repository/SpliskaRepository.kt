package com.bivizul.whenshouldyouplacebetsinsportsbetting.repository

import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Resspliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Spliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.network.ConticsApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class SpliskaRepository() {

    private val api = ConticsApi()

    private val _resspliska = MutableSharedFlow<Resspliska>()
    val resspliska : SharedFlow<Resspliska> = _resspliska.asSharedFlow()

    suspend fun getResspliska(spliska: Spliska){
        val response = api.getResspliska(spliska)
        println("SpliskaRepository response : $response")
        _resspliska.emit(response)
    }

}