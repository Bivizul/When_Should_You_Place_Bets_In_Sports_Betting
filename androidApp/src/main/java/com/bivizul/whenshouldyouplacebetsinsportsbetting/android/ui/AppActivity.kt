package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main.MainScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.spliska.SpliskaScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.theme.WhenWhouldYouPlaceBetsInSportsBetting

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhenWhouldYouPlaceBetsInSportsBetting {

//                val sdk = ConticSDK(ConticDatabaseDriverFactory(this))
//                val sdk : ConticSDK by inject()
//                val repository : ConticRepository by inject()

//                val store: FeedStore by inject()
//                val scaffoldState = rememberScaffoldState()
//                val error = store.observeSideEffect()
//                    .filterIsInstance<FeedSideEffect.Error>()
//                    .collectAsState(null)
//                LaunchedEffect(error.value) {
//                    error.value?.let {
//                        scaffoldState.snackbarHostState.showSnackbar(
//                            it.error.message.toString()
//                        )
//                    }
//                }
                Box(
                    Modifier.padding(
                        WindowInsets.systemBars
                            .only(WindowInsetsSides.Start + WindowInsetsSides.End)
                            .asPaddingValues()
                    )
                ) {
                    Scaffold(
//                        scaffoldState = scaffoldState,
                        snackbarHost = { hostState ->
                            SnackbarHost(
                                hostState = hostState,
                                modifier = Modifier.padding(
                                    WindowInsets.systemBars
                                        .only(WindowInsetsSides.Bottom)
                                        .asPaddingValues()
                                )
                            )
                        }
                    ) {
                        Navigator(SpliskaScreen())
                    }
                }
            }
        }
    }
}
