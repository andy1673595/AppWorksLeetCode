/**
nums = [10, 9, 2, 5, 3, 7, 101, 18]
dp   = [1,  1, 1, 1, 1, 1, 1  , 1]

dp   = [1,  1, 1, 2, 2, 3, 2  , 4]

Time : O(n^2)
Space: O(n)
 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }
        
        nums.forEachIndexed { i, n ->
            for (j in 0 until i) {
                if (n > nums[j]) {
                    dp[i] = maxOf(dp[i], dp[j]+1)
                }
            }
        }
        
        return dp.max()!!
    }
}

/**
 Follow up : Time : O(nLog(n))  -> binary search
 
 Example : [10,9,2,5,3,7,101,18]

 Progress of dp :
 [0, 0, 0, 0, 0, 0, 0, 0]
 [10, 0, 0, 0, 0, 0, 0, 0]
 [9, 0, 0, 0, 0, 0, 0, 0]
 [2, 0, 0, 0, 0, 0, 0, 0]
 [2, 5, 0, 0, 0, 0, 0, 0]
 [2, 3, 0, 0, 0, 0, 0, 0]
 [2, 3, 7, 0, 0, 0, 0, 0]
 [2, 3, 7, 101, 0, 0, 0, 0]
 [2, 3, 7, 18, 0, 0, 0, 0]

 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        
        fun binarySearchLargeThan(s: Int, e: Int, goal: Int): Int {
            if (s >= e) {
                return e
            }
            val mid = (s+e)/2
            
            return if (goal > dp[mid]) binarySearchLargeThan(mid+1, e, goal)
            else binarySearchLargeThan(s, mid, goal)
        }
        
        var maxLen = 0
        for (n in nums) {
            val indexForInsert = binarySearchLargeThan(0, maxLen, n)
            dp[indexForInsert] = n
            if (indexForInsert == maxLen) {
                maxLen ++
            }
        }
        return maxLen
    }
}

