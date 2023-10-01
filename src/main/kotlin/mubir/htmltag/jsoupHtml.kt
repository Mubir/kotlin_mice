package mubir.htmltag

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun isValidHtml(html: String): Boolean {
    try {
        // Attempt to parse the HTML using Jsoup
        val document: Document = Jsoup.parse(html)

        // If parsing succeeds, consider it valid HTML
        return true
    } catch (e: Exception) {
        // If parsing fails, it's not valid HTML
        return false
    }
}

fun main() {
    val html = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Example HTML Page</title>
        
        <body>
            <h1>Welcome to the Example HTML Page</h1>
            <p>This is a simple HTML page.</p>
            <ul>
                <li>Item 1</li>
                <li>Item 2</li>
                <li>Item 3</li>
            </ul>
            <p><a href="https://www.example.com">Visit Example.com</a></p>
        <//body>
        </html>
    """

    val isValid = isValidHtml(html)
    if (isValid) {
        println("The provided HTML is valid.")
    } else {
        println("The provided HTML is not valid.")
    }
}
