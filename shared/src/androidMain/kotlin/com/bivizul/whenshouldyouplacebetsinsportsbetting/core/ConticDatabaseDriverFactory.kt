//package com.bivizul.whenshouldyouplacebetsinsportsbetting.core
//
//import android.content.Context
//import com.squareup.sqldelight.android.AndroidSqliteDriver
//import com.squareup.sqldelight.db.SqlDriver
//
//actual class ConticDatabaseDriverFactory(private val context: Context) {
//    actual fun createDriver(): SqlDriver {
//        return AndroidSqliteDriver(AppDatabase.Schema, context, "test.db")
//    }
//}