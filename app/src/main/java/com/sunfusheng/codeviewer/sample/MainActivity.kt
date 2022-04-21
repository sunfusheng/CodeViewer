package com.sunfusheng.codeviewer.sample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.sunfusheng.codeviewer.CodeHtmlGenerator
import com.sunfusheng.codeviewer.CodeView
import com.sunfusheng.codeviewer.CodeViewUtil

/**
 * 代码查看器示例
 *
 * @author sunfusheng
 * @since 2020-02-19
 */
class MainActivity : AppCompatActivity() {

  private var vCodeView: CodeView? = null

  private val mAssetsFilePath = "source_code/MainActivity.kt"
  private var mSourceCode: String? = null

  private var isNightMode: Boolean = true
  private var showLineNums: Boolean = false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    vCodeView = findViewById(R.id.vCodeView)
    loadSampleCode()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    menu.getItem(0).isChecked = isNightMode
    menu.getItem(1).isChecked = showLineNums
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.item_night_mode -> {
        isNightMode = !isNightMode
        item.isChecked = isNightMode
        loadSampleCode()
        return true
      }
      R.id.item_show_linenums -> {
        showLineNums = !showLineNums
        item.isChecked = showLineNums
        loadSampleCode()
        return true
      }
    }
    return super.onOptionsItemSelected(item)
  }

  // 加载Assets下的示例代码
  private fun loadSampleCode() {
    if (mSourceCode == null) {
      mSourceCode = CodeViewUtil.getStringFromAssetsFile(
        applicationContext,
        mAssetsFilePath
      )
    }
    val sourceCodeHtml = CodeHtmlGenerator.generate(
      mAssetsFilePath,
      mSourceCode,
      isNightMode,
      showLineNums
    )
    vCodeView?.loadCodeHtml(sourceCodeHtml)
  }
}
