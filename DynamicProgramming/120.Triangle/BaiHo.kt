/**

Example : 
   2
  3 4
 6 5 7
4 1 8 3

We solve this question by bottom - top dp.
    2     <- [11]
   3 4    <- [9, 10]
  6 5 7   <- [7, 6, 10]
 4 1 8 3  <- [4, 1, 8, 3]
0 0 0 0 0 <- initial dp


Time  : O(n), where n is total count of triangle
Space : O(row)
 */
class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        val dp = IntArray(n+1)
        for (i in n-1 downTo 0) {
            val row = triangle[i]
            for (j in row.indices) {
                dp[j] = row[j] + minOf(dp[j], dp[j+1])
            }
        }
        return dp[0]
    }
}