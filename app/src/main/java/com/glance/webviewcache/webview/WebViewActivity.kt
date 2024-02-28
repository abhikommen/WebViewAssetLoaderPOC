package com.glance.webviewcache.webview

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.glance.webviewcache.R
import com.glance.webviewcache.WebViewType
import com.glance.webviewcache.webview.fragments.AssetWebViewFragment
import com.glance.webviewcache.webview.fragments.SimpleWebViewFragment
import com.glance.webviewcache.webview.fragments.StorageWebViewFragment

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val webViewType = intent.extras?.get("type") as WebViewType

        val fragmentManager = supportFragmentManager


        fragmentManager.beginTransaction()
            .add(R.id.webcontainer_one, getFragmentInstance(webViewType)).commit()
        fragmentManager.beginTransaction()
            .add(R.id.webcontainer_two, getFragmentInstance(webViewType)).commit()
        fragmentManager.beginTransaction()
            .add(R.id.webcontainer_three, getFragmentInstance(webViewType))
            .commit()
        fragmentManager.beginTransaction()
            .add(R.id.webcontainer_four, getFragmentInstance(webViewType))
            .commit()

    }

    // function that takes the type of class and create its instance
    private fun getFragmentInstance(webViewType: WebViewType): Fragment {
        return when (webViewType) {
            WebViewType.ASSET_SOURCE -> AssetWebViewFragment()
            WebViewType.WITHOUT_CACHE -> SimpleWebViewFragment()
            WebViewType.STORAGE_SOURCE -> StorageWebViewFragment()
        }
    }

}