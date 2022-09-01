package com.bivizul.whenshouldyouplacebetsinsportsbetting.network.repository

import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.network.RequestApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class ConticRepository() {

    private val requestApi = RequestApi()

    private val _contics = MutableSharedFlow<Contics>()
    val contics: SharedFlow<Contics> = _contics.asSharedFlow()

    suspend fun getContics() {
        val response = requestApi.getContics()
        _contics.emit(response)
    }

}