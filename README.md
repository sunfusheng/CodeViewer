# CodeViewer

Android 端代码查看器，支持的功能：<br/>

1、几乎加载所有格式代码，具体查看Google开源的[code-prettify](https://github.com/google/code-prettify)<br/>
2、支持白天夜晚模式，可以设置自定义颜色<br/>
3、支持是否显示代码行号<br/>

### 效果图

<img src="/resources/codeviewer_sample.png" >

<br/>

### Gradle:

    api 'com.sunfusheng:code-viewer:1.0.0'

### 使用

    <com.sunfusheng.codeviewer.CodeView
        android:id="@+id/vCodeView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    // 1、从assets文件夹下加载文件的内容
    val sourceCode = CodeViewUtil.getStringFromAssetsFile(context, filePath)
    // 2、生成html字符串
    val sourceCodeHtml = CodeHtmlGenerator.generate(filePath,sourceCode,isNightMode,showLineNums)
    // 3、在UI线程中加载源码的Html字符串，步骤1和2应该放到子线程中
    vCodeView.loadCodeHtml(sourceCodeHtml)

<br/>

### 感谢

1、[google/code-prettify](https://github.com/google/code-prettify)

2、[ThirtyDegreesRay/OpenHub](https://github.com/ThirtyDegreesRay/OpenHub)

<br/>

### 关于我

[GitHub: sunfusheng](https://github.com/sunfusheng)

[个人邮箱: sfsheng0322@126.com](https://mail.126.com/)

[个人博客: sunfusheng.com](http://sunfusheng.com/)

[简书主页](http://www.jianshu.com/users/88509e7e2ed1/latest_articles)

[新浪微博](http://weibo.com/u/3852192525)
