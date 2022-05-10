// 122. Best Time to Buy and Sell Stock II

class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var min: Int = 0
        var profit: Int = 0
        
        for (index, price) in prices.enumerated() {
            if index == 0 {
                min = price
                continue
            }
            
            if price > prices[index - 1] {
                profit += price - min
            }
            min = price
        }
        
        return profit
    }
}