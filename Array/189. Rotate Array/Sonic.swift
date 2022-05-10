// 189. Rotate Array

class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        let step = k % nums.count
        nums = Array(nums.suffix(step) + nums.prefix(nums.count - step))
    }
}