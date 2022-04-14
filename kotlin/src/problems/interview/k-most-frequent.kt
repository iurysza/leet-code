package problems.interview/*
 * On backend, menu of a restaurant is stored like this -
 *
 * "ItemName: Ingredient1 Ingredient2 Ingredient3 ...\n
 *  ItemName: Ingredient1 Ingredient2 Ingredient3 ...\n
 *  ItemName: Ingredient1 Ingredient2 Ingredient3 ...\n"
 *
 * Extract top k ingredients used in a given restaurant
 */

fun main(args: Array<String>) {
    val words = getKMostFrequentIngredients(
        "margharita: cheese oliveOil wheat\n" +
            "chickenBbq: chicken tomato cheese\n" +
            "salami: pork cheese wheat", 2
    )
    println(words)
}

fun getKMostFrequentIngredients(response: String, k: Int): List<String> {
    val wordMap = hashMapOf<String, Int>()
    response
        .replace("\n", " ")
        .split(" ")
        .forEach { word ->
            if (wordMap.containsKey(word)) {
                val currentValue: Int = wordMap[word]!!
                wordMap[word] = currentValue + 1
            } else {
                wordMap[word] = 1
            }
        }

    return wordMap
        .toList()
        .sortedBy { (_, occurrences) -> occurrences }
        .reversed()
        .take(k)
        .map { (word, _) -> word }
}
