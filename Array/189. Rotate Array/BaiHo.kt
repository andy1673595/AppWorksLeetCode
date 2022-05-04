/**
 Time O(n)
 Space O(1)
 */
class Solution189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        fun swap(s: Int, e: Int) {
            val mid = (s+e)/2
            var j = e
            for (i in s .. mid) {
                val tmp = nums[i]
                nums[i] = nums[j]
                nums[j] = tmp
                j --
            }
        }
        val kRemainder = k % nums.size
        if (kRemainder == 0) return
        swap(0, nums.size -1)
        swap(0, kRemainder-1)
        swap(kRemainder, nums.size -1)
    }
}