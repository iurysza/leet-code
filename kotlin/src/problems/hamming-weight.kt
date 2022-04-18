package problems

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
    println(hammingWeight("0101".toInt()))
}
