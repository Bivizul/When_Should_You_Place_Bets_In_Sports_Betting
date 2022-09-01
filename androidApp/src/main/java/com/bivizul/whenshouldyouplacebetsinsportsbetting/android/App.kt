package com.bivizul.whenshouldyouplacebetsinsportsbetting.android

import android.app.Application
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.ConticRepository
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.SpliskaRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App:Application() {

    /*override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private val appModule = module {
//        single { RssReader.create(get(), BuildConfig.DEBUG) }
//        single { FeedStore(get()) }
        single { ConticRepository(get()) }
        single { SpliskaRepository(get()) }
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.ERROR)

            androidContext(this@App)
            modules(appModule)
        }
    }*/

}