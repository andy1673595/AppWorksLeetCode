/**
Time O(n)
Space O(1)
*/
class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var lowest = Int.max
        var maxProfit = Int.zero
        
        for today in prices {
            lowest = min(lowest, today)
            
            let profit = today - lowest
            maxProfit = max(profit, maxProfit)
        }
        
        return maxProfit
    }
}