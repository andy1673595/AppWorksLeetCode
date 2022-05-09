class Solution:
    def maxProfit(self, prices):
        profits = []
        max_profit = 0
        current_min = prices[0]
        for price in prices:
            current_min = min(current_min, price)
            max_profit = max(max_profit, price - current_min)
            profits.append(max_profit)

        # backward traversal, max_profit records the max profit
        # after the ith day, this is the second transaction 
        total_max = 0    
        max_profit = 0
        current_max = prices[-1]
        for i in range(len(prices) - 1, -1, -1):
            current_max = max(current_max, prices[i])
            max_profit = max(max_profit, current_max - prices[i])
            total_max = max(total_max, max_profit + profits[i])
        return total_max

    def maxProfit_dp(self, prices):
        if len(prices) == 0 or not prices:
            return 0
        dp = [[0 for i in range(len(prices))]for i in range(3)]
        for k in range(1, 3):
            for i in range(1, len(prices)):
                min_price = prices[0]
                for j in range(1, i+1):
                    min_price = min(min_price, prices[j] - dp[k-1][j-1])
                dp[k][i] = max(dp[k][i-1], prices[i] - min_price)
        print(dp)
        return dp[2][len(prices) - 1]



prices = [1,2,4,2,5,7,2,4,9,0]
a = Solution().maxProfit_dp(prices)
# print(a)
