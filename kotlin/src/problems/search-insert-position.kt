package problems

fun main() {
    searchInsertPositionInput.forEach { (input, expectedOutput) ->
        val (nums, target) = input
        val answer = searchInsert(nums, target)
        val isCorrect = answer == expectedOutput
        if (!isCorrect) {
            throw Error(buildResponse(input, expectedOutput, answer))
        } else {
            println("Correct!${buildResponse(input, expectedOutput, answer)}\n\n")
        }
    }
}

private fun buildResponse(input: Pair<IntArray, Int>, expectedOutput: Any, answer: Any): String {
    return """
        
        Input: ${input.first.contentToString()}, target: ${input.second}
        Expected Output: $expectedOutput
        My Answer: $answer
    """.trimIndent()
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size
    while (start < end) {
        val mid = start + (end - start) / 2

        if (nums[mid] == target) return mid
        if (nums[mid] > target) {
            end = mid
        } else {
            start = mid + 1
        }
    }
    return start
}

private val searchInsertPositionInput = listOf(
    (intArrayOf(1, 3, 5, 6) to 5) to 2,
    (intArrayOf(1, 3, 5, 6) to 2) to 1,
    (intArrayOf(1, 3, 5, 6) to 7) to 4,
)

