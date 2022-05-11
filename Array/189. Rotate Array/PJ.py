from typing import List

# not in-place


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        new_nums = [0]*len(nums)
        for i, num in enumerate(nums):
            new_nums[(i+(k % len(nums))) % len(nums)] = num
        for i, num in enumerate(new_nums):
            nums[i] = num
