/**
dp store minimum less than or equal k subsequence with length i

for input s = "1001010", k = 5
dp will be

[0, *, *, *, *, *, *, *]
[0, 1, *, *, *, *, *, *]
[0, 0, 2, *, *, *, *, *]
[0, 0, 0, 4, *, *, *, *]
[0, 0, 0, 1, *, *, *, *]
[0, 0, 0, 0, 2, *, *, *]
[0, 0, 0, 0, 1, 5, *, *]
[0, 0, 0, 0, 0, 2, *, *]

// Attempt 3 times

n = s.length
Time : O(n^2)
Space: O(n)
 */
class Solution {
    fun longestSubsequence(s: String, k: Int): Int {
        val dp = IntArray(s.length+1) { Int.MAX_VALUE }
        dp[0] = 0

        for (i in s.indices) {
            val n = s[i] - '0'
            // We should start from end(i+1) to 1
            for (len in i+1 downTo 1) {
                // should skip Int.MAX_VALUE at len-1
                if (dp[len-1] == Int.MAX_VALUE) continue
                val total = (dp[len-1] shl 1) + n
                if (total <= k) {
                    dp[len] = minOf(total, dp[len])
                }
            }
        }
  

        for (len in dp.size-1 downTo 1) {
            if (k >= dp[len]) {
                return len
            }
        }
        return 1
    }
}