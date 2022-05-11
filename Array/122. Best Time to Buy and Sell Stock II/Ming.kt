/**
Time O(n)
Space O(1)
 */
class Solution122 {
    fun maxProfit(prices: IntArray): Int {
        var totalProfit = 0
        var prePrice = 0
        prices.forEachIndexed { index, price ->
            if (index > 0 && (price - prePrice)>0 ) {
                totalProfit += price - prePrice
            }
            prePrice = price
        }
        return totalProfit
    }
}

fun main() {
    val arry = intArrayOf(7,6,4,3,1)
    println(Solution122().maxProfit(arry))
}