package com.bivizul.whenshouldyouplacebetsinsportsbetting.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contics(
    @SerialName("intro") val intro: String,
    @SerialName("contic") val conticItem: List<ConticItem>,
)