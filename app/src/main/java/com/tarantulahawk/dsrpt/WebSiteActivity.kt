package com.tarantulahawk.dsrpt

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_web_site.*

class WebSiteActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_site)

        webViewSetup()

    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        wbViking.webViewClient = WebViewClient()
        wbViking.apply {
            loadUrl("https://www.ubisoft.com/pt-br/game/assassins-creed/valhalla")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true

        }
    }

    override fun onBackPressed() {
        if(wbViking.canGoBack()) wbViking.goBack() else super.onBackPressed()
    }
}