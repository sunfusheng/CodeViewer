package com.sunfusheng.code.viewer

import android.content.Context
import android.webkit.MimeTypeMap

/**
 * @author sunfusheng
 * @since 2020-01-03
 */
object CodeHtmlGenerator {

    fun generate(context: Context?, codeFilePath: String?, sourceCode: String?): String? {
        if (context == null || sourceCode?.length == 0) return null

        val extension = MimeTypeMap.getFileExtensionFromUrl(codeFilePath)
        return generateCodeHtml(sourceCode!!, extension, true, false, false)
    }

    private fun generateCodeHtml(
        sourceCode: String,
        extension: String?,
        isNight: Boolean,
        wrap: Boolean,
        lineNums: Boolean
    ): String? {
        val backgroundColor = if (isNight) "#373a41" else "#ffffff"
        return """
            <html>
                <head>
                    <meta charset="utf-8" />
                    <title>Code Viewer</title>
                    <meta name="viewport" content="width=device-width; initial-scale=1.0;"/>
                    <script src="./run_prettify.js?autoload=true&amp;skin=${if (isNight) "desert" else "prettify"}&amp;lang=$extension&amp;" defer></script>
                    <style>
                        body {background: $backgroundColor;}
                        .prettyprint {background: $backgroundColor;}
                        pre.prettyprint {
                            word-wrap: ${if (wrap) "break-word" else "normal"};
                            white-space: ${if (wrap) "pre-wrap" else "no-wrap"};
                        }
                    </style>
                </head>
                <body>
                    <?prettify lang=$extension linenums=$lineNums?>
                    <pre class="prettyprint">
${sourceCode.replace("<", "&lt;").replace(">", "&gt;")}
                    </pre>
                </body>
            </html>
        """
    }
}