package com.bivizul.whenshouldyouplacebetsinsportsbetting.android

import android.app.Application
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.worker.RefreshWorker
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.create
import com.bivizul.whenshouldyouplacebetsinsportsbetting.app.FeedStore
import com.bivizul.whenshouldyouplacebetsinsportsbetting.RssReader
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        launchBackgroundSync()
    }

    private val appModule = module {
        single { RssReader.create(get(), BuildConfig.DEBUG) }
        single { FeedStore(get()) }
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.ERROR)

            androidContext(this@App)
            modules(appModule)
        }
    }

    private fun launchBackgroundSync() {
        RefreshWorker.enqueue(this)
    }

}