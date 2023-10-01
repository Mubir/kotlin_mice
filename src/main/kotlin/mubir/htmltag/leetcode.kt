package mubir.htmltag

val VALID_TAG_NAME_REGEX = Regex("^[A-Z]{1,9}$")

fun isValid(code: String): Boolean {
    val tagStack: MutableList<String> = mutableListOf()
    var i = 0
    while (i < code.length) {
        when {
            matchPrefix(code, i, "</") -> {
                getEndOfTag(code, i)?.let {
                    val tagName = code.slice(i + 2 until it)
                    if (tagStack.isEmpty() || tagStack.last() != tagName) return false
                    tagStack.removeAt(tagStack.size - 1)
                    if (tagStack.isEmpty() && it + 1 < code.length) return false
                    it + 1
                }
            }
            matchPrefix(code, i, "<!") -> {
                getEndOfCDATA(code, i)?.let {
                    if (tagStack.isEmpty() || !matchPrefix(code, i, "<![CDATA[")) return false
                    it + 3
                }
            }
            code[i] == '<' -> {
                getEndOfTag(code, i)?.let {
                    val tagName = code.slice(i + 1 until it)
                    if (!tagName.matches(VALID_TAG_NAME_REGEX)) return false
                    tagStack.add(tagName)
                    it + 1
                }
            }
            else -> {
                if(tagStack.isEmpty()) return false
                i + 1
            }
        }?.let { i = it } ?: return false
    }
    return tagStack.isEmpty()
}

fun matchPrefix(code: String, i: Int, pref: String): Boolean =
    code.slice(i..code.length.coerceAtMost(i + pref.length)-1).startsWith(pref)

fun getEndOfTag(code: String, i: Int): Int? =
    when {
        i >= code.length -> null
        matchPrefix(code, i, "<!") -> getEndOfCDATA(code, i)?.let { getEndOfTag(code, it + 3) }
        code[i] == '>' -> i
        else -> getEndOfTag(code, i + 1)
    }

fun getEndOfCDATA(code: String, s: Int): Int? = code.indexOf("]]>", s).takeIf { it >= 0 }

fun main(array:Array<String>)
{
    val html = """
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
val html2 = """<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"""
    print(isValid(html))
}