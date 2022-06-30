
/**
 m = word1.length
 n = word2.length
 Time : O(mm)
 Space: O(mn)

 Example : word1 = "abcdef", word2 = "dabef"
       d  a  b  e  f
   [0, 0, 0, 0, 0, 0]
 a [0, 0, 1, 1, 1, 1]
 b [0, 0, 1, 2, 2, 2] 
 c [0, 0, 1, 2, 2, 2] 
 d [0, 1, 1, 2, 2, 2] 
 e [0, 1, 1, 2, 3, 3] 
 f [0, 1, 1, 2, 3, 4]

 */
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        val dp = Array(m+1) { IntArray(n+1) }
        
        for (i in 1..m) {
            for (j in 1..n) {
                // Be careful, here should use 'i-1' and 'j-1', not i and j
                if (word1[i-1] == word2[j-1]) {
                    dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]+1)
                } else {
                    dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1])
                }
            }
        }
        
        return (m-dp[m][n]) + (n-dp[m][n])
    }
}