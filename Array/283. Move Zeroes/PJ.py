from typing import List
# algo: Two pointer -> 同方向
# 思路：
# 有一個變數在記錄 0 的 index
# 另一個變數一直往後掃，掃到非 0 的 index
# Swap


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        slow_ptr = 0
        fast_ptr = 0
        for slow_ptr in range(len(nums)):
            while fast_ptr < len(nums) - 1 and nums[fast_ptr] == 0:
                fast_ptr += 1
            if nums[slow_ptr] == 0 and fast_ptr < len(nums):
                nums[fast_ptr], nums[slow_ptr] = nums[slow_ptr], nums[fast_ptr]
            fast_ptr += 1
