/**
https://leetcode.com/problems/intersection-of-two-arrays-ii/

Time O(m+n)
Space O(n) where n == nums1.count
*/
class Solution {
    func intersect(_ nums1: [Int], _ nums2: [Int]) -> [Int] {
        var result: [Int] = []

        // [value: presenceCount]
        var hashMap: [Int: Int] = [:]

        nums1.forEach { value in
            hashMap[value, default: 0] += 1
        }

        for i in stride(from: nums2.count - 1, through: 0, by: -1) {
            let value = nums2[i]
            if hashMap[value, default: 0] > 0 {
                result.append(value)
                hashMap[value, default: 0] -= 1
            }
        }

        return result
    }
}