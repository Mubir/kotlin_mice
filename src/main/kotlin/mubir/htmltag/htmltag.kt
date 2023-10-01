fun isValidHtml(html: String): Boolean {
    val tagStack = mutableListOf<String>()

    val regex = "<\\s*([^\\s>/]+)(.*?)>".toRegex()
    val matches = regex.findAll(html)

    for (match in matches) {
        val tag = match.groupValues[1]
        val attributes = match.groupValues[2]

        if (!attributes.endsWith("/")) {
            // Opening tag
            tagStack.add(tag)
        }

        if (attributes.startsWith("/")) {
            // Self-closing tag, remove it from the stack if present
            if (tagStack.contains(tag)) {
                tagStack.remove(tag)
            } else {
                return false  // Unmatched self-closing tag
            }
        }
    }

    return tagStack.isEmpty()  // If the stack is empty, all tags are matched
}

fun main() {
    val html = """
        <!DOCTYPE html>
<html
    lang="ja"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:ex="http://www.thymeleaf.org"
></html>
    """

    val isValid = isValidHtml(html)
    if (isValid) {
        println("The provided HTML is valid.")
    } else {
        println("The provided HTML is not valid.")
    }
}
