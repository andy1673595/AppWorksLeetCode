/**
Time O(n*6) = O(n)
Space O(1)
 */
class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        // Find the min value in unsorted continuous subarray
        var s = -1
        for (i in 0 until nums.size -1) {
            if (nums[i] > nums[i+1]) {
                s = i
                break
            }
        }
        if (s == -1) return 0
        
        var minInSubarray = Int.MAX_VALUE
        for (i in s until nums.size) {
            minInSubarray = minOf(minInSubarray, nums[i])
        }
        
        // Find the index of the min value we found previously
        var minIndex = 0
        for (i in s downTo 0) {
            if (nums[i] > minInSubarray) minIndex = i
        }
        
        // Find the max value in unsorted continuous subarray
        var e = -1
        for (i in nums.size-1 downTo 1) {
            if (nums[i] < nums[i-1]) {
                e = i
                break
            }
        }
        if (e == -1) return 0
        var maxInSubarray = Int.MIN_VALUE
        for (i in e downTo 0) {
            maxInSubarray = maxOf(maxInSubarray, nums[i])
        }
        
        // Find the index of the max value we found previously
        var maxIndex = 0
        for (i in e until nums.size) {
            if (nums[i] < maxInSubarray) maxIndex = i
        }
        return maxIndex - minIndex + 1
    }
}