# 2D solution
# time: O(m*n)
# space: O(m*n)

# 1D solution
# time: O(m*n)
# space: O(n))


class Solution:
    def uniquePaths(self, m, n): # 2D solution
        dp = [[1 for x in range(n)] for y in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[m-1][n-1]
    
    def uniquePaths_1d(self, m, n): # 1D solution
        dp = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                print(dp[j - 1], dp[j])
                dp[j] = dp[j - 1] + dp[j]
        return dp[-1] if m and n else 0
