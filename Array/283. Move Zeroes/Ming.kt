/**
 * Time O(n)
 * Space O(1)
 */
class Solution283 {
    fun moveZeroes(nums: IntArray): Unit {
        var nonZeroIndex = 0
        val tmpArray = IntArray(nums.size)
        nums.forEach { num ->
            if(num!=0) {
                tmpArray[nonZeroIndex] = num
                nonZeroIndex++
            }
        }
        for (i in tmpArray.indices) {
            nums[i] = tmpArray[i]
        }
    }
}

fun main() {
    val arry = intArrayOf(1,2,3)
    println(Solution283().moveZeroes(arry))
}
