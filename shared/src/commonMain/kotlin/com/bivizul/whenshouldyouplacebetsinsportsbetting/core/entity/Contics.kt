package com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contics(
    @SerialName("intro") val intro: String,
    @SerialName("conticItem") val conticItem: List<ConticItem>,
)