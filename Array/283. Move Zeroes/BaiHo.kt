/**
 * Time O(n)
 * Space O(1)
 */
class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var nonZeroIndex = 0
        nums.forEachIndexed { i, n ->
            if (n != 0) {
                val tmp = nums[i]
                nums[i] = nums[nonZeroIndex]
                nums[nonZeroIndex] = tmp
                nonZeroIndex ++
            }
        }
    }
}
