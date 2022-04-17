package problems

fun reverseString(s: CharArray): Unit {
    val mid = s.size / 2
    var p2: Int = s.size - 1

    var aux = Char(0)
    for (p1 in 0..s.size) {
        if (p1 == mid) break
        aux = s[p2]
        s[p2] = s[p1]
        s[p1] = aux
        p2--
    }
    println(s)
}

fun main() {
    reverseString(charArrayOf('h', 'e', 'l', 'l', 'o'))
}
