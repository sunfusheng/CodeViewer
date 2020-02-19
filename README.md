# CodeViewer

Android 端代码查看器，支持的功能：
1、几乎加载所有格式代码，具体查看Google开源的[code-prettify](https://github.com/google/code-prettify)
2、支持白天夜晚模式
3、支持是否显示代码行号

<br/>

### 效果图

<img src="/resources/codeviewer_sample.png" >

<br/>

### Gradle:

    api 'com.sunfusheng:CodeViewer:<latest-version>'

<br/>

### 使用

    <com.sunfusheng.codeviewer.CodeView
        android:id="@+id/vCodeView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    val sourceCode = CodeViewUtil.getStringFromAssetsFile(context, filePath)

    val sourceCodeHtml = CodeHtmlGenerator.generate(filePath,sourceCode,isNightMode,showLineNums)

    vCodeView.loadCodeHtml(sourceCodeHtml)

### 扫一扫[Fir.im](https://fir.im/GroupAdapter)二维码下载APK

<img src="/resources/fir.im.png" style="width: 30%;" alt="s">

<br/>

### 感谢

1、Google开源的[code-prettify](https://github.com/google/code-prettify)


### 个人微信公众号

<img src="http://sunfusheng.com/assets/wx_gongzhonghao.png">

<br/>

### 请作者喝杯咖啡^_^

<img src="http://sunfusheng.com/assets/wx_shoukuanma.png" >

<br/>

### 关于我

[GitHub: sunfusheng](https://github.com/sunfusheng)

[个人邮箱: sfsheng0322@126.com](https://mail.126.com/)

[个人博客: sunfusheng.com](http://sunfusheng.com/)

[简书主页](http://www.jianshu.com/users/88509e7e2ed1/latest_articles)

[新浪微博](http://weibo.com/u/3852192525)
