/**
Time : O(NlogN)
Space : O(N)
 */
class Solution {
    fun reversePairs(nums: IntArray): Int {
        // has a Int.MAX_VALUE test case
        val list = mutableListOf<Long>()
        var ans = 0
        nums.forEachIndexed { i, n ->
            // before insert, find the index large than 2n
            val largeIndex = list.findLarge(0, list.size -1, n.toLong()*2)
            if (largeIndex < list.size && list[largeIndex] > n.toLong()*2) {
                ans += (i - largeIndex)
            }
     
            // binary insert
            val result = list.binarySearch(n.toLong())
            val insert = if (result >= 0) {
                result
            } else {
                (result+1)*-1
            }
            list.add(insert, n.toLong())

        }
        return ans
    }

    fun List<Long>.findLarge(s: Int, e: Int, goal: Long): Int {
        if (s >= e) return s
        val mid = (s+e)/2
        return if (this[mid] <= goal) {
            this.findLarge(mid+1, e, goal)
        } else {
            this.findLarge(s, mid, goal)
        }
    }
}