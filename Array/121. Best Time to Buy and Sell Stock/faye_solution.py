class Solution:
    def maxProfit(self, prices):
        max_profit, min_price = 0, prices[0]
        for price in prices:
            min_price = min(min_price, price)
            max_profit = max(price - min_price, max_profit)
        return max_profit


class SolutionDP:
    def maxProfit(self, nums):
        ans, latest_dp = 0, 0
        for i in range(0, len(nums)-1):
            q = nums[i+1] - nums[i]
            latest_dp = max(latest_dp + q, q)
            ans = max(ans, latest_dp)
        return ans
