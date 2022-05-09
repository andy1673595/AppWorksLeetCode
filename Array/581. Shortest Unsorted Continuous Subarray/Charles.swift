/**
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

Time O(n)
Space (1)

Two pointer
*/
class Solution {
    func findUnsortedSubarray(_ nums: [Int]) -> Int {
        let n = nums.count
        var start = -1
        var end = -2

        var mx = nums[n - 1]
        var mn = nums[0]

        for i in 0 ..< nums.count {
            mn = max(mn, nums[i])
            mx = min(mx, nums[n - 1 - i])
            if (mn > nums[i]) {
                end = i
            }
            if (mx < nums[n - 1 - i]) {
                start = n - 1 - i
            }
        }

        return end - start + 1
    }
}