import java.lang.Integer.min

/**
 Time O(n)
 Space O(1)
 */
class Solution189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        // 參考同學的
        val tmp = nums.copyOf()
        tmp.forEachIndexed { index, i ->
            val j = (index + k) % nums.size
            nums[j] = i
        }
    }
}

fun main() {
    val arry = intArrayOf(1,2,3)
    println(Solution189().rotate(arry,2))
}