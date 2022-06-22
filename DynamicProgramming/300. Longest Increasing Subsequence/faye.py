# time: O(n^2)
# space: O(1)

class Solution:
    def lengthOfLIS(self, nums):
        if not nums:
            return 0
        n = len(nums)
        dp = [1] * n
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], 1 + dp[j])
        return max(dp)

nums = [10,9,2,5,3,7,101,18]
Solution().lengthOfLIS(nums)
