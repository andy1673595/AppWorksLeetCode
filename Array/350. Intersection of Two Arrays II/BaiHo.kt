/**
 * n = size of nums1, m = size of nums2
 * Time O(n+m) 
 * Space O(m) 
 */

 /**
 Follow up:
- What if the given array is already sorted? How would you optimize your algorithm?
- What if nums1's size is small compared to nums2's size? Which algorithm is better?
- What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
  */

class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val count = IntArray(1001)
        
        for (n in nums1) {
            count[n] ++
        }
        
        val ans = mutableListOf<Int>()
        for (n in nums2) {
            if (count[n] > 0) {
                ans.add(n)
            }
            count[n] --
        }
        
        return ans.toIntArray()
    }
}