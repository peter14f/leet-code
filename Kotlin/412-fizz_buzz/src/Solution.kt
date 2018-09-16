import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val ans = ArrayList<String>(n)
        for (i in 1..n) {
            when {
                i % 3 == 0 && i % 5 == 0 -> ans.add("FizzBuzz")
                i % 3 == 0 -> ans.add("Fizz")
                i % 5 == 0 -> ans.add("Buzz")
                else -> ans.add(i.toString())
            }
        }
        return ans
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.fizzBuzz(15))
}