package problems

import kotlin.math.max

fun main() {
    maxSubArrayInput.forEach { (input, expectedOutput) ->
        val answer = maxSubArray(input)
        val isCorrect = answer == expectedOutput
        if (!isCorrect) {
            throw Error(buildResponse(input, expectedOutput, answer))
        } else {
            println("Correct!${buildResponse(input, expectedOutput, answer)}\n\n")
        }
    }
}

private fun buildResponse(input: IntArray, expectedOutput: Any, answer: Any): String {
    return """
        Input: ${input.contentToString()}
        Expected Output: $expectedOutput
        My Answer: $answer
    """.trimIndent()
}

// O(n)
fun maxSubArray(nums: IntArray): Int {
    var maxSubarray = Int.MIN_VALUE
    var currentSubarray = 0
    for (element in nums) {
        if (max(currentSubarray + element, element) == element) {
            currentSubarray = element
        } else {
            currentSubarray += element
        }
        val currentMax = max(maxSubarray, currentSubarray)
        if (currentMax > maxSubarray) {
            maxSubarray = currentMax
        }
    }
    return maxSubarray
}

// O(n2)
//fun maxSubArray(nums: IntArray): Int {
//    var maxSubarray = Int.MIN_VALUE
//    for (i in 0 until nums.size) {
//        var currentSubarray = 0
//        for (j in i until nums.size) {
//            currentSubarray += nums[j]
//            maxSubarray = max(maxSubarray, currentSubarray)
//        }
//    }
//    return maxSubarray
//}

private val maxSubArrayInput = listOf(
    intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4) to 6,
    intArrayOf(1) to 1,
    intArrayOf(5, 4, -1, 7, 8) to 23,
    intArrayOf(5, 4, -1, 7, 8) to 23,
    intArrayOf(-2, -1) to -1
)

