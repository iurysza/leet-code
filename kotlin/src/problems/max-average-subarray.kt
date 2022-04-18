package problems

fun main() {
    maxAverageSubarrayInput.forEach { (input, expectedOutput) ->
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

fun findMaxAverage(nums: IntArray, k: Int): Double {
    nums.copyOfRange()

}

private val maxAverageSubarrayInput = listOf(
    "xyzzaz" to 1,
    "aababcabc" to 4,
)

