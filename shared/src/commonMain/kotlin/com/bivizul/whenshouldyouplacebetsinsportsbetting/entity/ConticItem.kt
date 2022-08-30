package com.bivizul.whenshouldyouplacebetsinsportsbetting.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConticItem(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val desc: String,
)