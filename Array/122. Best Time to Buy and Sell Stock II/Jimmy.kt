class Solution {
    /*
    * 想法：
    * 由於當 [a,b,c] 且 a<b<c 時，最大值為 (c - a)
    * 但這也等於 (b-a) + (b-c) 也就是全部的差異相加。
    *
    * 如此一來，我們主要就是找出目前最小值 (buyInPrice) 與 後來的高點 (sellOutPrice) 相差的總和即可。
    *
    * Time O(n)
    * Space O(1)
    * 
    * */
    fun maxProfit(prices: IntArray): Int {
        var maxIncome = 0
        for (i in 1 until prices.size) {
            maxIncome += maxOf(prices[i] - prices[i-1], 0)
        }
        return maxIncome
    }
}