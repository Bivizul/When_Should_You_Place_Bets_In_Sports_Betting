package com.bivizul.whenshouldyouplacebetsinsportsbetting

class Settings(val defaultConticsUrls: Set<String>) {
    fun isDefault(conticsUrl: String) = defaultConticsUrls.contains(conticsUrl)
}