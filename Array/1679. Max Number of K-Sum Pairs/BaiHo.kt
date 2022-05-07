/**
n = nums.size
Time : O(n)
Space : O(n)
 */
class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()
        nums.forEach { n ->
            map[n] = (map[n] ?: 0) + 1
        }
        var ans = 0
        map.keys.forEach { n ->
            ans += minOf(map[n] ?: 0, map[k-n] ?: 0)
        }
        return ans/2
    }
}