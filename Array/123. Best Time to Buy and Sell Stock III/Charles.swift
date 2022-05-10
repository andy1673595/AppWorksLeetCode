/**
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

Time O(n)
Space O(1)

想法：如果今天是第二次買進，如何記住第一段的收益。

假如今天是第二段的買進點 (x)，設第二次賣出的價格: y、第一段的收益: profit1，可得出以下關係：
y - x + profit1 即兩段的總收益 (profit2)
可改寫成 y - (x - profit1)，也就是說 (x - profit1) 越小，兩段總收益越大
*/
class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var buy1 = Int.max
        var buy2 = Int.max
        var profit1 = Int.zero
        var profit2 = Int.zero

        for today in prices {
            // 截至今日的最低價格
            buy1 = min(buy1, today)
            // 截至今日的最大收益（只買賣一次）
            profit1 = max(profit1, today - buy1)

            // (x - profit1) 的最小值
            buy2 = min(buy2, today - profit1)
            // y - (x - profit1) 的最大值
            profit2 = max(profit2, today - buy2)
        }

        return profit2
    }
}