package mubir.htmltag

fun areHtmlTagsValidAbc(html: String): Boolean {
    val openingTags = Regex("<[^/][^>]*>").findAll(html).map { it.value }
    val closingTags = Regex("</[^>]*>").findAll(html).map { it.value }

    val stack = mutableListOf<String>()

    for (tag in openingTags) {
//println("$tag ====")
        stack.add(tag)
    }

    for (tag in closingTags) {
        println("$tag +++++")
        if (stack.isEmpty()) {
            return false
        }
//        val openTag = stack.removeAt(stack.size - 1)
//        if (tag != "</" + openTag.substring(1)) {
//            return false
//        }

//        val demo = """<a href="https://www.example.com">""".split(" ")
val demo = """<title>""".split(" ")
        var xterm:String
        if(demo.size>=2)
        {
            xterm = demo[0]+">"
            println(xterm)
        }else{
            xterm = demo[0]
            println(xterm)
        }
        println(demo)
        val front="<"+tag.substring(2)
        if(stack.contains(front))
        {
            print("ok")
        }
        print(front)
    }
    return stack.isEmpty()  // If the stack is empty, all tags are matched

//    val openingTag= Regex("<[^/][^>]*>").findAll(html)
//    val closingTag = Regex("</[^>]*>").findAll(html)
//    val openingTagSet = HashSet<String>()
//    val closingTagSet = HashSet<String>()
//    for (matchResult in openingTag) {
//        val tag = matchResult.value
//        println("$tag  ---")
//        openingTagSet.add(tag)
//    }
//
//    for (matchResult in closingTag) {
//        val tag = matchResult.value
//        println("$tag  ####")
//        closingTagSet.add(tag)
//    }
//   return openingTagSet.size==closingTagSet.size
}

fun main() {
    val html = """
        <html lang="en">
        <head>
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
            <p></p>
        </body>
        </html>
    """

    val isValid = areHtmlTagsValidAbc(html)
    if (isValid) {
        println("All opening and closing HTML tags match.")
    } else {
        println("Some opening and closing HTML tags do not match.")
    }
}
