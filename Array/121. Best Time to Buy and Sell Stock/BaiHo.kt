/**
Time O(n)
Space O(1)
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices.first()
        var ans = maxOf(prices.last() - buy, 0)
        for (n in prices) {
            ans = maxOf(n - buy, ans)
            buy = minOf(n, buy)
        }
        return ans
    }
}