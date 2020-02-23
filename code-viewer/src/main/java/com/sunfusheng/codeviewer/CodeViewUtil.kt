package com.sunfusheng.codeviewer

import android.content.Context
import android.text.TextUtils
import android.webkit.MimeTypeMap
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @author sunfusheng
 * @since 2020-02-18
 */
object CodeViewUtil {
    var DAY_MODE_COLOR = "#ffffff"
    var NIGHT_MODE_COLOR = "#373a41"

    fun getFileExtension(filePath: String?): String? {
        return MimeTypeMap.getFileExtensionFromUrl(filePath)
    }

    fun getRealSourceCode(sourceCode: String?): String {
        return if (TextUtils.isEmpty(sourceCode)) {
            "No Data!"
        } else {
            sourceCode!!.replace("<", "&lt;").replace(">", "&gt;")
        }
    }

    fun getBackgroundColor(isNightMode: Boolean): String {
        return if (isNightMode) NIGHT_MODE_COLOR else DAY_MODE_COLOR
    }

    fun getStringFromAssetsFile(context: Context, fileName: String): String {
        val bufferedReader =
            BufferedReader(InputStreamReader(context.assets.open(fileName), "UTF-8"))
        val content = StringBuffer()
        var line: String? = null
        while (bufferedReader.readLine()?.also { line = it } != null) {
            content.append(line)
            content.append("\n")
        }
        return content.toString()
    }
}