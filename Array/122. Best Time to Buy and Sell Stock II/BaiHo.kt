
/**
Time O(n)
Space O(1)
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var ans = 0
        for (i in 1 until prices.size) {
            val spread = prices[i] - prices[i-1]
            if (spread > 0) ans += spread
        }
        return ans
    }
}