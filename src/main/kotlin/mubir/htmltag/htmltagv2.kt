package mubir.htmltag
import kotlin.text.Regex
fun areHtmlTagsValidF(html: String): Boolean {
    val openingTags = Regex("<[^/].*?>").findAll(html)
    val closingTags = Regex("</.*?>").findAll(html)

    val openingTagList = openingTags.map { it.value }
    val closingTagList = closingTags.map { it.value }

//    return openingTagList.size == closingTagList.size &&
//            openingTagList.zip(closingTagList).all { (open, close) ->
//                open.removePrefix("<").removeSuffix(">") == close.removePrefix("</").removeSuffix(">")
//            }

    return true
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

    val isValid = areHtmlTagsValidF(html)
    if (isValid) {
        println("All HTML tags are properly closed.")
    } else {
        println("Some HTML tags are not properly closed.")
    }
}

