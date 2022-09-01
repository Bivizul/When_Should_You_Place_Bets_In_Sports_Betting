package com.bivizul.whenshouldyouplacebetsinsportsbetting.android

import android.app.Application
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.Conspliska.ONESIGNAL_APP_ID
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.ConticRepository
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.SpliskaRepository
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App:Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

    }
}