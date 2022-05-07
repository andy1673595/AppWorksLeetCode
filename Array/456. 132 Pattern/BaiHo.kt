/**
Time O(n)
Space O(n)
 */
class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        val stack = Stack<Int>()
        var n3 = Int.MIN_VALUE
        for (i in nums.size -1 downTo 0) {
            val n = nums[i]
            if (n < n3) {
                return true
            }
            
            while (stack.isNotEmpty() && stack.peek()!! < n) {
                n3 = maxOf(stack.pop()!!, n3)
            }
            stack.add(n)
        }
        
        return false
    }
}