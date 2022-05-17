class Solution:
    def moveZeroes(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        for j in range(len(nums)):
            if nums[i] == 0:
                nums.pop(i)
                nums.append(0)
            else:
                i += 1
        return


nums = [0,1,0,3,12]
Solution().moveZeroes(nums)