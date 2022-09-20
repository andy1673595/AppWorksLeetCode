/**
  Time : O(n)
  Space: O(1)
 */
class Solution {
    fun twoSum(ar: IntArray, t: Int): IntArray {
        var s = 0
        var e = ar.size - 1
        while (s < e) {
            val sum = ar[s] + ar[e]
            if (sum == t) {
                break
            } else if (sum > t) {
                e --
            } else {
                s ++
            }
        }
        
        return intArrayOf(s+1, e+1)
    }
}