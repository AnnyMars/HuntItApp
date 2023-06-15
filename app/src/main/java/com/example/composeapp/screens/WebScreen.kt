package com.example.composeapp.screens

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.composeapp.utils.Constants
import com.onesignal.OneSignal
import kotlinx.coroutines.launch
import org.json.JSONObject


@Composable
fun WebScreen() {


    val context = LocalContext.current
    val webView = WebView(context)
    webView.settings.javaScriptEnabled = true
    webView.webViewClient = WebViewClient()
    webView.loadUrl("https://vk.com")



    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { webView }
    )

}

//    OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
//    OneSignal.initWithContext(LocalContext.current)
//    OneSignal.setAppId(Constants.ONE_SIGNAL_KEY)