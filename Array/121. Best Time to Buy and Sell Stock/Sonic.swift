// 121. Best Time to Buy and Sell Stock

class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var min: Int = prices[0]
        var ans: Int = 0
        for price in prices {
            if price - min > ans {
                ans = price - min
            } else if price < min {
                min = price
            }
        }
        return ans
    }
}