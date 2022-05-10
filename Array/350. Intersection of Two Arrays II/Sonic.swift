// 350. Intersection of Two Arrays II

class Solution {
    func intersect(_ nums1: [Int], _ nums2: [Int]) -> [Int] {
        var sortedNums1 = nums1.sorted()
        var sortedNums2 = nums2.sorted()
        let setNums1 = Set(sortedNums1)
        let setNums2 = Set(sortedNums2)
        var nums1Index: Int = 0
        var nums2Index: Int = 0
        var ans: [Int] = []
        
        if setNums1.count <= setNums2.count {
            for num in setNums1 {
                let count1 = sortedNums1.lastIndex(of: num)! - sortedNums1.firstIndex(of: num)! + 1
                var count2 = 0
                if setNums2.contains(num) {
                    count2 = sortedNums2.lastIndex(of: num)! - sortedNums2.firstIndex(of: num)! + 1
                }
                ans += Array(repeating: num, count: min(count1, count2))
            }
        } else {
            for num in setNums2 {
                let count2 = sortedNums2.lastIndex(of: num)! - sortedNums2.firstIndex(of: num)! + 1
                var count1 = 0
                if setNums1.contains(num) {
                    count1 = sortedNums1.lastIndex(of: num)! - sortedNums1.firstIndex(of: num)! + 1
                }
                ans += Array(repeating: num, count: min(count1, count2))
            }
        }
        return ans
    }
}