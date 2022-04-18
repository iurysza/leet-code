package problems

fun main() {
    goodSubStringInput.forEach { (input, expectedOutput) ->
        val answer = countGoodSubstrings(input)
        val isCorrect = answer == expectedOutput
        if (!isCorrect) {
            throw Error(buildResponse(input, expectedOutput, answer))
        } else {
            println("Correct!${buildResponse(input, expectedOutput, answer)}\n\n")
        }
    }
}

private fun buildResponse(input: String, expectedOutput: Any, answer: Any): String {
    return """
        Input: ${input}
        Expected Output: $expectedOutput
        My Answer: $answer
    """.trimIndent()
}

fun countGoodSubstrings(s: String): Int {
    val subStrings = mutableListOf<Map<Char, Int>>()
    for (i in 0..s.length - 3) {
        subStrings.add(
            mapOf(
                s[i] to i,
                s[i + 1] to i,
                s[i + 2] to i,
            )
        )
    }
    return subStrings.count { it.size == 3 }
}

private val goodSubStringInput = listOf(
    "xyzzaz" to 1,
    "aababcabc" to 4,
)

