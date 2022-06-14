/**
 Time : O(mn)
 Space: O(mn)
 */
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m+1) { IntArray(n+1) }
        for (i in 1 .. m) {
            // we initialze value in first column to 1
            // 1 x x x ..
            // 1 x x x ..
            // 1 x x x ..
            dp[i][1] = 1 
            for (j in 2 .. n) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }
        return dp[m][n]
    }
}