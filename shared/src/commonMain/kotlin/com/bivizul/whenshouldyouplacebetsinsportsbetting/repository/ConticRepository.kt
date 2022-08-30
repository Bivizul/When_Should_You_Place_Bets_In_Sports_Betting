package com.bivizul.whenshouldyouplacebetsinsportsbetting.repository

import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.network.ConticsApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class ConticRepository {

    private val api = ConticsApi()

    private val _contics = MutableSharedFlow<Contics>()
    val contics : SharedFlow<Contics> = _contics.asSharedFlow()

    suspend fun getContics(){
        val response = api.getContics()
        _contics.emit(response)
    }

}