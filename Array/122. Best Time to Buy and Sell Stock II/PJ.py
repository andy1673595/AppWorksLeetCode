from typing import List

# 思路：
# 前提： 當前為亂序 -> 依需求：不可排序 -> 不可能 BS
# Q1. 在 5 的時候，怎麼知道前面有個 1 ，而不是 2 ? A: 需要有一個變數記住當前 price 以前最小值。
# Q2. 在 6 的時候，怎麼知道前面有個 3 ，而不是 1 ? A: 每一次需要更新最小值，算完一次 profit 就 set 當下為最小值


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        min_price = 10000
        for i in range(len(prices)):
            if (prices[i] > min_price):
                max_profit += prices[i] - min_price
            min_price = prices[i]
        return max_profit
