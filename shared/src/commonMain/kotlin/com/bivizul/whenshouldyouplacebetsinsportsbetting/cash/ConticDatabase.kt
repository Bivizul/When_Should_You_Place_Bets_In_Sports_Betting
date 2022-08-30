//package com.bivizul.whenshouldyouplacebetsinsportsbetting.cash
//
//import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.ConticItem
//import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
//
//internal class ConticDatabase(conticDatabaseDriverFactory: ConticDatabaseDriverFactory) {
//
//    private val database = AppDatabase(conticDatabaseDriverFactory.createDriver())
//    private val dbQuery = database.appDatabaseQueries
//
//    internal fun clearDatabase() {
//        dbQuery.transaction {
//            dbQuery.removeAllRockets()
//            dbQuery.removeAllLaunches()
//        }
//    }
//
//    internal fun getAllLaunches(): Contics {
//        return dbQuery.selectAllLaunchesInfo(::mapLaunchSelecting).executeAsList()
//    }
//
//    private fun mapLaunchSelecting(
//        intro: String,
//        conticItem: List<ConticItem>,
//    ): Contics {
//        return Contics(
//            intro = intro,
//            conticItem = conticItem,
//        )
//
//    }
//
//    internal fun createLaunches(launches: Contics) {
//        dbQuery.transaction {
//            launches.conticItem.forEach { launch ->
//                val rocket = dbQuery.selectRocketById(launch.rocket.id).executeAsOneOrNull()
//                if (rocket == null) {
//                    insertContic(launch)
//                }
//
//                insertLaunch(launch)
//            }
//        }
//    }
//
//    private fun insertContic(launch: Contics) {
//        dbQuery.insertContic(
//            id = launch.rocket.id,
//            name = launch.rocket.name,
//            type = launch.rocket.type
//        )
//    }
//
//    private fun insertLaunch(launch: Contics) {
//        dbQuery.insertLaunch(
//            flightNumber = launch.flightNumber.toLong(),
//            missionName = launch.missionName,
//            launchYear = launch.launchYear,
//            rocketId = launch.rocket.id,
//            details = launch.details,
//            launchSuccess = launch.launchSuccess ?: false,
//            launchDateUTC = launch.launchDateUTC,
//            missionPatchUrl = launch.links.missionPatchUrl,
//            articleUrl = launch.links.articleUrl
//        )
//    }
//}