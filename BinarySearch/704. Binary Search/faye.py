# space: O(n)
# time: O(logN)

class Solution:
    def search(self, nums, target):
        lft = 0
        rgt = len(nums) - 1
        while lft <= rgt:
            mid = (lft + rgt) // 2
            if nums[mid] > target:
                rgt = mid - 1
            elif nums[mid] < target:
                lft = mid + 1
            else:
                return mid
        return -1
