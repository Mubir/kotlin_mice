package mubir.htmltag

fun areHtmlTagsProperlyClosed(html: String): Boolean {
    val tagStack = mutableListOf<String>()
    val regex = "<(/?[^>]+)>".toRegex()

    for (matchResult in regex.findAll(html)) {
        val tag = matchResult.groupValues[1]
        if (tag.startsWith("/")) {
            // Closing tag
            val expectedOpeningTag = tag.substring(1)
            if (tagStack.isEmpty() || tagStack.last() != expectedOpeningTag) {
                return false  // Mismatched closing tag
            }
            tagStack.removeAt(tagStack.size - 1)
        } else if (!tag.endsWith("/")) {
            // Opening tag (ignore self-closing tags)
            tagStack.add(tag)
        }
    }

    return tagStack.isEmpty()  // If the stack is empty, all tags are matched
}

fun main() {
    val html = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Example HTML Page</title>
        </head>
        <body>
            <h1>Welcome to the Example HTML Page</h1>
            <p>This is a simple HTML page.</p>
            <ul>
                <li>Item 1</li>
                <li>Item 2</li>
                <li>Item 3</li>
            </ul>
            <p><a href="https://www.example.com">Visit Example.com</a></p>
        </body>
        </html>
    """

    val isValid = areHtmlTagsProperlyClosed(html)
    if (isValid) {
        println("All HTML tags have matching closing tags.")
    } else {
        println("Some HTML tags do not have matching closing tags.")
    }
}
