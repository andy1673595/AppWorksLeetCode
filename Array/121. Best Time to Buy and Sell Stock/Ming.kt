/**
Time O(n)
Space O(1)
 */
class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var lowPrice = prices.first()
        var maxProfit = 0
        for (price in prices) {
            maxProfit = maxOf(price - lowPrice, maxProfit)
            lowPrice = minOf(price, lowPrice)
        }
        println("maxProfit: $maxProfit")
        return maxProfit
    }
}

fun main() {
    val arry = intArrayOf(7,1,5,3,6,4)
    Solution121().maxProfit(arry)
}