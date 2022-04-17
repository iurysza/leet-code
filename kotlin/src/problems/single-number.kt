package problems

fun main() {
    singleNumberInput.forEach { (input, expectedOutput) ->
        val answer = singleNumber(input)
        val isCorrect = answer.equals(expectedOutput)
        if (!isCorrect) {
            throw Error(buildResponse(input, expectedOutput, answer))
        } else {
            println("Correct!${buildResponse(input, expectedOutput, answer)}\n\n")
        }
    }
}

fun singleNumber(input: IntArray): Int {
    val seen = mutableMapOf<Int, Int>()
    input.forEach {
        seen[it] = seen.getOrDefault(it, 0) + 1
    }
    seen.forEach {
        if (it.value < 2) {
            return it.key
        }
    }
    return -1
}

private fun buildResponse(input: IntArray, expectedOutput: Int, answer: Int): String {
    return """
        Input: $input
        Expected Output: ${expectedOutput}
        My Answer: ${answer}
    """.trimIndent()
}


private val singleNumberInput = listOf(
    intArrayOf(2, 2, 1) to 1,
    intArrayOf(4, 1, 2, 1, 2) to 4,
)

