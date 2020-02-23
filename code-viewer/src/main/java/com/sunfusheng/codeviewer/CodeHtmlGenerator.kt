package com.sunfusheng.codeviewer

/**
 * @author sunfusheng
 * @since 2020-02-18
 */
object CodeHtmlGenerator {

    fun generate(
        filePath: String?,
        sourceCode: String?,
        isNightMode: Boolean = false,
        showLineNums: Boolean = false
    ): String? {
        val fileExtension = CodeViewUtil.getFileExtension(filePath)
        val backgroundColor = CodeViewUtil.getBackgroundColor(isNightMode)
        val skin = if (isNightMode) "desert" else "prettify"

        return """
            <html>
                <head>
                    <meta charset="utf-8" />
                    <title>Code Viewer</title>
                    <meta name="viewport" content="width=device-width; initial-scale=1.0;"/>
                    <script src="./run_prettify.js?autoload=true&amp;skin=$skin&amp;lang=$fileExtension&amp;" defer></script>
                    <style>
                        body {background: $backgroundColor;}
                        pre.prettyprint {background-color: $backgroundColor !important;}
                        pre.prettyprint {word-wrap: "normal";white-space: "no-wrap";}
                    </style>
                </head>
                <body>
                    <?prettify lang=$fileExtension linenums=$showLineNums?>
                    <pre class="prettyprint">
${CodeViewUtil.getRealSourceCode(sourceCode)}
                    </pre>
                </body>
            </html>
        """
    }
}