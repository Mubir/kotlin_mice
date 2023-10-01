package mubir.htmltag

fun areHtmlTagsValid(html: String): Boolean {
    val tags = Regex("<[^>]+>").findAll(html).map { it.value }

    val stack = mutableListOf<String>()

    for (tag in tags) {
        if (tag.startsWith("</")) {
            // Closing tag
            val openTag = stack.lastOrNull()
            if (openTag == null) {
                return false  // Unmatched closing tag
            }
            if (tag.substring(2, tag.length - 1) != openTag.substring(1)) {
                return false  // Mismatched opening and closing tags
            }
            stack.removeAt(stack.size - 1)
        } else if (tag.endsWith("/>")) {
            // Self-closing tag
            // Do nothing for self-closing tags
        } else if (!tag.endsWith("/>")) {
            // Opening tag (ignore self-closing tags)
            stack.add(tag)
        }
    }

    return stack.isEmpty()  // If the stack is empty, all tags are matched
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

    val isValid = areHtmlTagsValid(html)
    if (isValid) {
        println("All HTML tags are properly closed.")
    } else {
        println("Some HTML tags are not properly closed.")
    }
}

