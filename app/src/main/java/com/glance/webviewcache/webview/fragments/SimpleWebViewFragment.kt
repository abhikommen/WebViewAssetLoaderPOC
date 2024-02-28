package com.glance.webviewcache.webview.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.glance.webviewcache.R

class SimpleWebViewFragment : Fragment() {

    private lateinit var webView: WebView
    private lateinit var timeTaken: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.webView)

        timeTaken = view.findViewById(R.id.timeTaken)

        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.setInitialScale(1)
        webView.settings.useWideViewPort = true
        var time = System.currentTimeMillis()
        webView.webViewClient = object : WebViewClient() {
            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
                time = System.currentTimeMillis() - time
                timeTaken.text = "$time ms"
            }
        }
        webView.loadUrl("file:///android_asset/simple.html")
    }
}