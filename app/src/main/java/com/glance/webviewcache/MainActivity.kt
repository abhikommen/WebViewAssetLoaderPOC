package com.glance.webviewcache

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.glance.webviewcache.webview.WebViewActivity
import com.glance.webviewcache.webview.WebViewActivityTwo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.cacheButton).setOnClickListener {
            Intent(this, WebViewActivity::class.java).also {
                startActivity(it)
            }
        }

        findViewById<View>(R.id.withoutCacheButton).setOnClickListener {
            Intent(this, WebViewActivityTwo::class.java).also {
                startActivity(it)
            }
        }

    }
}