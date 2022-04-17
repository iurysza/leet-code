package problems

//fun main() {
//    countBitsInput.forEach { (input, expectedOutput) ->
//        val answer = countBits(input)
//        val isCorrect = answer.contentEquals(expectedOutput)
//        if (!isCorrect) {
//            throw Error(buildResponse(input, expectedOutput, answer))
//        } else {
//            println("Correct!${buildResponse(input, expectedOutput, answer)}\n\n")
//        }
//    }
//}

private fun buildResponse(input: Int, expectedOutput: IntArray, answer: IntArray): String {
    return """
        Input: $input
        Expected Output: ${expectedOutput.toList()}
        My Answer: ${answer.toList()}
    """.trimIndent()
}

fun countBits(n: Int): IntArray {
    var ans = intArrayOf()
    (0..n).forEach { item ->
        ans += Integer.toBinaryString(item).fold(0) { acc, c ->
            acc + c.digitToInt()
        }
    }
    return ans
}


private val countBitsInput = listOf(
    2 to intArrayOf(0, 1, 1),
    5 to intArrayOf(0, 1, 1, 2, 1, 2),
)

fun main() {

    fun hammingWeight(n: Int): Int {
        var bits = 0
        var mask = 1
        for (i in 0..31) {
            if (n and mask != 0) {
                bits++
            }
            mask = mask shl 1
        }
        return bits
    }
    var mask = "0001".toInt()
    var input = "0110".toInt()
    var result = input and mask
//    val result = mask shl 1
   println(result)
//    println(hammingWeight("0101".toInt()))
}
