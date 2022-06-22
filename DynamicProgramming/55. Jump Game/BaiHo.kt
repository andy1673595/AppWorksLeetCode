/**
Time  : O(n)
Space : O(1) 
 */
class Solution {
    fun canJump(nums: IntArray): Boolean {
        var reachAble = nums.first()
        nums.forEachIndexed { i, n ->
            if (i > reachAble) return false
            reachAble = maxOf(reachAble, i+n)
        }
        return true
    }
}