fun main() {
    fizzBuzzInput.forEach { (input, answer: List<String>) ->
        val result: List<String> = fizzBuzz(input )
        val isCorrect = result == answer
        if (!isCorrect) {
            throw Error("Wrong!\nInput: ${input} \t Answer: ${result}")
        } else {
            println("Correct!\nInput: ${input} \t Answer: ${result}")
        }
    }
}

fun fizzBuzz(n: Int): List<String> {
    val result = mutableListOf<String>()
    for(pos in 1..n){
        if(pos % 3 == 0 && pos % 5 == 0) {
            result.add("FizzBuzz")
        }else if(pos%3==0) {
            result.add("Fizz")
        }else if(pos%5==0){
            result.add("Buzz")
        }else{
            result.add(pos.toString())
        }
    }
    return result
}
private val fizzBuzzInput = listOf(
    15 to listOf(
        "1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"
    )
)

