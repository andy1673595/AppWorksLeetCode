/**
https://leetcode.com/problems/move-zeroes/

Time O(n)
Space O(1)
*/
class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        var cursor = 0
        
        for i in 0 ..< nums.count where nums[i] != 0 {
            let temp = nums[i]
            nums[i] = nums[cursor]
            nums[cursor] = temp
            cursor += 1
        }
    }
} 