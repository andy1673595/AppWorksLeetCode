class Solution:
    def maxProfit(self, prices):
        max_profit = 0
        for i in range(len(prices)-1):
            j = i + 1
            if prices[j] > prices[i]:
                max_profit += prices[j] - prices[i]
        return max_profit
