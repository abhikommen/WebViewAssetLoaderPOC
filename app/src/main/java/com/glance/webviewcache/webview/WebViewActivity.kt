package com.glance.webviewcache.webview

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.glance.webviewcache.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.webcontainer_one, WebViewFragmentTwo()).commit()
        fragmentManager.beginTransaction().add(R.id.webcontainer_two,  WebViewFragmentTwo()).commit()
        fragmentManager.beginTransaction().add(R.id.webcontainer_three, WebViewFragmentTwo()).commit()
        fragmentManager.beginTransaction().add(R.id.webcontainer_four, WebViewFragmentTwo()).commit()

    }

}