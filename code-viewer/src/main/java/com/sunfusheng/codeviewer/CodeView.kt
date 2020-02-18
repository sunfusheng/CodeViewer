package com.sunfusheng.codeviewer

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView

/**
 * @author sunfusheng
 * @since 2020-02-18
 */
@SuppressLint("SetJavaScriptEnabled")
class CodeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {

    companion object {
        const val CODE_PRETTIFY_ASSETS_PATH = "file:///android_asset/code_prettify/"
        const val MIME_TYPE = "text/html"
        const val ENCODING = "UTF-8"
    }

    init {
        settings.javaScriptEnabled = true
        settings.setAppCachePath(context.cacheDir.path)
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        settings.defaultTextEncodingName = ENCODING
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
        scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false
        setInitialScale(25)
    }

    fun loadCodeHtml(codeHtml: String?) {
        loadDataWithBaseURL(CODE_PRETTIFY_ASSETS_PATH, codeHtml, MIME_TYPE, ENCODING, null)
    }
}