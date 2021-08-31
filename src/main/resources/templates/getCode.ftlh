<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Code</title>
        <link rel="stylesheet" href="/css/main.css">
        <link rel="stylesheet"
              href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
        <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
    </head>
    <body>
        <span id="load_date">${date}</span>
        <#if views gt 0>
            <span id="views_restriction">${views} more views allowed</span>
        </#if>
        <#if time gt 0>
            <span id="time_restriction">The code will be available for ${time} seconds</span>
        </#if>
        <pre id="code_snippet"><code>${code}</code></pre>
    </body>
</html>