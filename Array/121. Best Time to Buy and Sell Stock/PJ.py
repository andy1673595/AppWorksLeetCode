from typing import List

# 當天的 price 減掉過去 N 天最小值即為 profit，而 max_profit 則需要將 N 天的 Profit 取 max。


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        min_prices = 10000
        for i in range(len(prices)):
            max_profit = max(prices[i] - min_prices, max_profit)
            min_prices = min(min_prices, prices[i])
        return max_profit
