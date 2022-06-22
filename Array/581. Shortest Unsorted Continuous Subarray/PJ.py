from typing import List


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        sorted_nums = sorted(nums)
        if sorted_nums == nums:
            return 0
        ans = []
        for i in range(len(nums)):
            if nums[i] != sorted_nums[i]:
                ans.append(i)
        return max(ans)+1 - min(ans)
