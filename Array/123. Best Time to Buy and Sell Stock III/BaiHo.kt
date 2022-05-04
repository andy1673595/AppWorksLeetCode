/**
Time O(n)
Space O(1)
 */
class Solution123 {
    fun maxProfit(prices: IntArray): Int {
        var buy1 = Int.MIN_VALUE
        var buy2 = Int.MIN_VALUE
        var sell1 = 0
        var sell2 = 0
        for (n in prices) {
            sell2 = maxOf(sell2, buy2 + n)
            buy2 = maxOf(buy2, sell1 - n)
            sell1 = maxOf(sell1, buy1 + n)
            buy1 = maxOf(buy1, -n)
        }
        return sell2
    }
}