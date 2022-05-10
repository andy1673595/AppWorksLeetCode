// 283. Move Zeroes

class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        let originalCount = nums.count
        nums = nums.filter { $0 != 0 }
        let zeroCount = originalCount - nums.count
        nums += Array(repeating: 0, count: zeroCount)
    }
}