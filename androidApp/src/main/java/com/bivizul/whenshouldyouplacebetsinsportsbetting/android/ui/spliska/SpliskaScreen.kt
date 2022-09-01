package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.spliska

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.bivizul.thebeginnersguidetobettingonformula1.util.*
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.LoadingContent
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.SpliskaActivity
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main.MainScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.Conspliska.KEY_SPLISKA
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.Conspliska.PREFSPLISKA
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Spliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.network.repository.SpliskaRepository
import com.onesignal.OneSignal

class SpliskaScreen() : Screen {

    @Composable
    override fun Content() {
        val repository = SpliskaRepository()

        val context = LocalContext.current
        val activity = LocalContext.current as Activity
        val navigator = LocalNavigator.currentOrThrow
        val prefspliska = activity.getSharedPreferences(PREFSPLISKA, Context.MODE_PRIVATE)

        LaunchedEffect(Unit) {
            try {
                repository.getResspliska(Spliska(
                    getSpliskamm(),
                    getSpliskasim(context),
                    getSpliskaid(prefspliska),
                    getSpliskal(),
                    getSpliskat()
                ))
            } catch (e: Exception) {
                getSpliskadia(context, activity)
            }
        }

        val resspliska by repository.resspliska.collectAsState(initial = null)

        Log.e("qwer", "resspliska : ${resspliska?.resspliska}")

        LoadingContent()

        resspliska?.resspliska?.let {
            if (it == "no") {
                navigator.push(MainScreen())
            } else if (it == "nopush") {
                OneSignal.disablePush(true)
                navigator.push(MainScreen())
            } else {
                val spliskantent = Intent(activity, SpliskaActivity::class.java)
                spliskantent.putExtra(KEY_SPLISKA, it)
                activity.startActivity(spliskantent)
            }
        }
    }
}
