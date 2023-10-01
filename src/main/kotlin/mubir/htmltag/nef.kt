package mubir.htmltag

fun isHtmlValid(html: String): Boolean {
//    val openingTags = Regex("<[^/][^>]*>").findAll(html)
    val openingTags = Regex("<[^>]*>").findAll(html)
    val closingTags = Regex("</[^>]*>").findAll(html)

    val openingTagSet = HashSet<String>()
    val closingTagSet = HashSet<String>()

    for (matchResult in openingTags) {
        val tag = matchResult.value
        println("$tag  ---")
        openingTagSet.add(tag)
    }

    for (matchResult in closingTags) {
        val tag = matchResult.value
        println("$tag  ####")
        closingTagSet.add(tag)
    }

    return openingTagSet == closingTagSet
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

    val isValid = isHtmlValid(html)
    if (isValid) {
        println("The provided HTML is valid.")
    } else {
        println("The provided HTML is not valid.")
    }
}
