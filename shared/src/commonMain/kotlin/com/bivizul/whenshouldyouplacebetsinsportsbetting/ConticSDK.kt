//package com.bivizul.whenshouldyouplacebetsinsportsbetting
//
//import com.bivizul.whenshouldyouplacebetsinsportsbetting.cash.ConticDatabase
//import com.bivizul.whenshouldyouplacebetsinsportsbetting.cash.ConticDatabaseDriverFactory
//import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
//import com.bivizul.whenshouldyouplacebetsinsportsbetting.network.ConticsApi
//
//class ConticSDK (conticDatabaseDriverFactory: ConticDatabaseDriverFactory) {
//    private val database = ConticDatabase(conticDatabaseDriverFactory)
//    private val api = ConticsApi()
//
//    @Throws(Exception::class) suspend fun getLaunches(forceReload: Boolean): Contics {
//        val cachedLaunches = database.getAllLaunches()
////        return if (cachedLaunches.isNotEmpty() && !forceReload) {
//        return if (!forceReload) {
//            cachedLaunches
//        } else {
//            api.getContics().also {
//                database.clearDatabase()
//                database.createLaunches(it)
//            }
//        }
//    }
//}