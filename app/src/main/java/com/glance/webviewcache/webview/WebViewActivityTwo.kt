package com.glance.webviewcache.webview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.glance.webviewcache.R

class WebViewActivityTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.webcontainer_one, WebViewFragment()).commit()
        fragmentManager.beginTransaction().add(R.id.webcontainer_two,  WebViewFragment()).commit()
        fragmentManager.beginTransaction().add(R.id.webcontainer_three, WebViewFragment()).commit()
        fragmentManager.beginTransaction().add(R.id.webcontainer_four, WebViewFragment()).commit()

    }

}