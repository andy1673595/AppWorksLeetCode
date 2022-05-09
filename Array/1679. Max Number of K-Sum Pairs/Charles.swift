/**
https://leetcode.com/problems/max-number-of-k-sum-pairs/

Time O(n)
Space O(n) @ worst case
*/
class Solution {
    func maxOperations(_ nums: [Int], _ k: Int) -> Int {
        // [value: count]
        var pool: [Int: Int] = [:]
        var count = 0

        for value in nums {
            let diff = k - value
            if pool[diff, default: 0] > 0 {
                count += 1
                pool[diff, default: 0] -= 1
            } else {
                pool[value, default: 0] += 1
            }
        }

        return count
    }
}