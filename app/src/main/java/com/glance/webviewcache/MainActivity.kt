package com.glance.webviewcache

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.glance.webviewcache.webview.WebViewActivity

enum class WebViewType {
    ASSET_SOURCE,
    WITHOUT_CACHE,
    STORAGE_SOURCE
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.assetSourceButton).setOnClickListener {
            Intent(this, WebViewActivity::class.java).also {
                it.putExtra("type", WebViewType.ASSET_SOURCE)
                startActivity(it)
            }
        }

        findViewById<View>(R.id.withoutCacheButton).setOnClickListener {
            Intent(this, WebViewActivity::class.java).also {
                it.putExtra("type", WebViewType.WITHOUT_CACHE)
                startActivity(it)
            }
        }


        findViewById<View>(R.id.internalSourceButton).setOnClickListener {
            Intent(this, WebViewActivity::class.java).also {
                it.putExtra("type", WebViewType.STORAGE_SOURCE)
                startActivity(it)
            }
        }

    }
}