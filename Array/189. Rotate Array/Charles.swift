/**
Time O(n)
Space O(1)
*/
class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        let k = k % nums.count
        if k == 0 { return }
        reverse(&nums, 0, nums.count)
        reverse(&nums, 0, k)
        reverse(&nums, k, nums.count - k)
    }

    private func reverse(_ nums: inout [Int], _ lower: Int, _ length: Int) {
        let upper = lower + length - 1
        let mid = (lower + upper) / 2

        for i in lower ... mid {
            let tmp = nums[i]
            nums[i] = nums[upper + lower - i]
            nums[upper + lower - i] = tmp
        }
    }
}