class Solution:
    # time: O(N)
    # space: O(N)
    def dp_solution(self, n):
        dp = [0]*(n + 1)
        if n == 1:
            return 1
        if n == 2:
            return 2
        dp[1] = 1
        dp[2] = 2
        for i in range(3, n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]

    # time: O(N)
    # space: O(1)
    def dp_constant_sapce(self, n):
        if n == 1:
            return 1
        a, b = 1, 2
        for i in range(2, n):
            tmp = b
            b = a + b
            a = tmp
        return b

n = 4
ans = Solution().dp_constant_sapce(n)
print(ans)