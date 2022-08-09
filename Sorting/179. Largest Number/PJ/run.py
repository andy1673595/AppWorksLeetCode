from typing import List


class Solution:
    def compare(self, s1, s2):
        return s1 + s2 > s2 + s1

    def largestNumber(self, nums: List[int]) -> str:
        str_nums = [str(num) for num in nums]
        self.quickSort(str_nums, 0, len(str_nums) - 1)
        return "".join(str_nums).lstrip('0') or '0'

    def quickSort(self, nums, l, r):
        if l >= r:
            return
        mid = self.partition(nums, l, r)
        self.quickSort(nums, l, mid-1)
        self.quickSort(nums, mid+1, r)

    def partition(self, nums, l, r):
        pivot = nums[r]
        slow = l
        for fast in range(l, r):
            if self.compare(nums[fast], pivot):
                nums[slow], nums[fast] = nums[fast], nums[slow]
                slow += 1
        nums[r], nums[slow] = nums[slow], nums[r]
        return slow
