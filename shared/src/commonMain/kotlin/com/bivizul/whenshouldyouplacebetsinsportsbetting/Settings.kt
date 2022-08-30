package com.bivizul.whenshouldyouplacebetsinsportsbetting

class Settings(val defaultFeedUrls: Set<String>) {
    fun isDefault(feedUrl: String) = defaultFeedUrls.contains(feedUrl)
}