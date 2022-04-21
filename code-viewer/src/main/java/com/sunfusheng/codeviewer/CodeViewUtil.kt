package com.sunfusheng.codeviewer

import android.content.Context
import android.webkit.MimeTypeMap
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * @author sunfusheng
 * @since 2020-02-18
 */
object CodeViewUtil {
  private var DAY_MODE_BACKGROUND_COLOR = "#ffffff"
  private var NIGHT_MODE_BACKGROUND_COLOR = "#373a41"

  /**
   * 根据【白天黑夜模式】设置背景色
   * @param isNightMode       是否是黑夜模式
   * @param backgroundColor   "#ffffff"
   */
  fun setBackgroundColor(isNightMode: Boolean, backgroundColor: String) {
    if (isNightMode) {
      NIGHT_MODE_BACKGROUND_COLOR = backgroundColor
    } else {
      DAY_MODE_BACKGROUND_COLOR = backgroundColor
    }
  }

  /**
   * 根据【白天黑夜模式】设置背景色
   * @param isNightMode       是否是黑夜模式
   */
  fun getBackgroundColor(isNightMode: Boolean): String {
    return if (isNightMode) NIGHT_MODE_BACKGROUND_COLOR else DAY_MODE_BACKGROUND_COLOR
  }

  /**
   * 根据文件路径获得文件扩展名
   */
  fun getFileExtension(filePath: String?): String? {
    return MimeTypeMap.getFileExtensionFromUrl(filePath)
  }

  /**
   * 从assets文件夹下加载文件的内容
   */
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