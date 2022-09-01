package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.R
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.Conspliska.DEF_SPLISKA
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.Conspliska.KEY_SPLISKA
import im.delight.android.webview.AdvancedWebView

class SpliskaActivity : ComponentActivity(), AdvancedWebView.Listener {

    lateinit var spliska: AdvancedWebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spliska)

        val url = intent.getStringExtra(KEY_SPLISKA) ?: DEF_SPLISKA

        spliska = findViewById<View>(R.id.spliska) as AdvancedWebView

        spliska.webViewClient = WebViewClient()
        spliska.webChromeClient = MyChromeClient()

        spliska.setListener(this, this)
        spliska.setMixedContentAllowed(false)

        setSettings()

        if (savedInstanceState == null) {
            spliska.post {
                kotlin.run { spliska.loadUrl(url) }
            }
        }

        spliska.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                spliska.canGoBack()
            ) {
                spliska.goBack()
                return@OnKeyListener true
            }
            false
        })

    }

    @SuppressLint("NewApi")
    override fun onResume() {
        super.onResume()
        spliska.onResume()
        // ...
    }

    @SuppressLint("NewApi")
    override fun onPause() {
        spliska.onPause()
        // ...
        super.onPause()
    }

    override fun onDestroy() {
        spliska.onDestroy()
        // ...
        super.onDestroy()
    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
//        if (requestCode == REQUEST_CODE) {
//            filePathCallback!!.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(
//                resultCode,
//                intent))
//            filePathCallback = null
//        }
        spliska.onActivityResult(requestCode, resultCode, intent)
    }

    override fun onBackPressed() {
        if (!spliska.onBackPressed()) {
            return
        }
        finishAndRemoveTask()
        System.exit(0)
    }


    override fun onPageStarted(url: String?, favicon: Bitmap?) {}

    override fun onPageFinished(url: String?) {}

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {}

    override fun onDownloadRequested(
        url: String?,
        suggestedFilename: String?,
        mimeType: String?,
        contentLength: Long,
        contentDisposition: String?,
        userAgent: String?,
    ) {
    }

    override fun onExternalPageRequest(url: String?) {}


    // NotePad

    @SuppressLint("SetJavaScriptEnabled")
    private fun setSettings() {
        val spliskaSettings = spliska.settings
        spliskaSettings.javaScriptEnabled = true
        spliskaSettings.loadWithOverviewMode = true
        spliskaSettings.allowFileAccess = true
        spliskaSettings.domStorageEnabled = true
        spliskaSettings.builtInZoomControls = true
        spliskaSettings.displayZoomControls = false
        spliskaSettings.useWideViewPort = true
        spliskaSettings.setSupportZoom(true)
//        webSettings.setAppCacheEnabled(true)
        spliskaSettings.userAgentString = spliskaSettings.userAgentString.replace("; wv", "")
    }

    var filePathCallback: ValueCallback<Array<Uri>>? = null
    private val REQUEST_CODE = 100

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        spliska.saveState(outState)
    }


    inner class MyChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams,
        ): Boolean {
            filePathCallback = filePath
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            startActivityForResult(intent, REQUEST_CODE)
            return true
        }

        private var spliskaCustomView: View? = null
        private var spliskaCustomViewCallback: CustomViewCallback? = null
        private var spliskaOriginalOrientation = 0
        private var spliskaOriginalSystemUiVisibility = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (spliskaCustomView == null) {
                null
            } else BitmapFactory.decodeResource(
                this@SpliskaActivity.applicationContext.resources,
                2130837573
            )
        }

        override fun onHideCustomView() {
            (this@SpliskaActivity.window.decorView as FrameLayout).removeView(spliskaCustomView)
            spliskaCustomView = null
            this@SpliskaActivity.window.decorView.systemUiVisibility =
                spliskaOriginalSystemUiVisibility
            this@SpliskaActivity.requestedOrientation = spliskaOriginalOrientation
            spliskaCustomViewCallback!!.onCustomViewHidden()
            spliskaCustomViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?,
        ) {
            if (spliskaCustomView != null) {
                onHideCustomView()
                return
            }
            spliskaCustomView = paramView
            spliskaOriginalSystemUiVisibility =
                this@SpliskaActivity.window.decorView.systemUiVisibility
            spliskaOriginalOrientation = this@SpliskaActivity.requestedOrientation
            spliskaCustomViewCallback = paramCustomViewCallback
            (this@SpliskaActivity.window.decorView as FrameLayout).addView(
                spliskaCustomView,
                FrameLayout.LayoutParams(-1, -1)
            )
            this@SpliskaActivity.window.decorView.systemUiVisibility =
                3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }
}