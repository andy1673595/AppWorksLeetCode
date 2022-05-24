class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buyInPrice = prices.first()
        var profit = 0
        for (i in 1 until prices.size) {
            val price = prices[i]
            profit = maxOf(price - buyInPrice, profit)
            buyInPrice = minOf(price, buyInPrice)
        }
        return profit
    }
}