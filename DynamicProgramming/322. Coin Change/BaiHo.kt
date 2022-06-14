/**
n = coins.size
Time : O(n*amount)
Space: O(amount)


Input: coins = [1,2,5], amount = 11
dp : [0, MAX, MAX, MAX, MAX, MAX, MAX, MAX, MAX, MAX, MAX, MAX,]
 */
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount+1) { Int.MAX_VALUE }
        dp[0] = 0
        
        for (i in 1 .. amount) {
            for (c in coins) {
                // dp[i-c] == Int.MAX_VALUE means that there is no combination eqaul to 'i-c'
                // For example, if we get input: coins = [2,4], amount = 7
                // Position 1,3,5,7 will always be Int.MAX_VALUE
                if ((i-c) < 0 || dp[i-c] == Int.MAX_VALUE) continue
                dp[i] = minOf(dp[i-c]+1, dp[i])
            }
        }
        
        return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
    }
}