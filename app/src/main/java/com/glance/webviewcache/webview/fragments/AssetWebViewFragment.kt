package com.glance.webviewcache.webview.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.webkit.WebViewAssetLoader
import com.glance.webviewcache.R

class AssetWebViewFragment : Fragment() {

    private lateinit var webView: WebView
    private lateinit var timeTaken: TextView
    private lateinit var assetLoader: WebViewAssetLoader


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

        var time = System.currentTimeMillis()

        // Create an unbound asset loader.
        assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireActivity()))
            .build()

        webView.webViewClient = object : WebViewClient() {

            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
                time = System.currentTimeMillis() - time
                timeTaken.text = "$time ms"
            }

            override fun shouldInterceptRequest(
                view: WebView, request: WebResourceRequest
            ): WebResourceResponse? {
                Log.d("WebViewFragment", "shouldInterceptRequest: ${request.url}")
                return assetLoader.shouldInterceptRequest(request.url)
            }
        }

        val webViewSettings = webView.settings
        webViewSettings.allowFileAccessFromFileURLs = false
        webViewSettings.allowUniversalAccessFromFileURLs = false
        webViewSettings.allowFileAccess = false
        webViewSettings.allowContentAccess = false

        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/assets.html")
    }
}