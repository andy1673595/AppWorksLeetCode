/**
Time : O(n^2)
Space: O(n)
 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = 1
        
        var realMax = 1
        for(i in 1 until nums.size) {
            var max = 1
            for(j in 0 until i) {
                if(nums[i] > nums[j]) {
                    max = Math.max(max, 1 + dp[j])
                }
            }
            dp[i] = max
            realMax = Math.max(realMax, max)
        }
        return realMax
    }
}
