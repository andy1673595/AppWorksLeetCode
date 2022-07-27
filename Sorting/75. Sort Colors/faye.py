# time: O(n)
# space: O(1)
# 3 pointers solution

class Solution:
    def sortColors(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        red, white, blue = 0, 1, 2
        head, mid, last = 0, 0, len(nums) - 1
        while mid <= last:
            if nums[mid] == blue:
                nums[mid], nums[last] = nums[last], nums[mid]
                last -= 1
            elif nums[mid] == white:
                mid += 1
            else:
                nums[head], nums[mid] = nums[mid], nums[head]
                head += 1
                mid += 1
        return
    
    def countColors(self, nums):
        red_count, white_count, blue_count = 0, 0, 0
        for i in nums:
            if i == 0:
                red_count += 1
            elif i == 1:
                white_count += 1
            else:
                blue_count += 1
        nums[:red_count] = [0] * red_count
        nums[red_count:red_count + white_count] = [1] * white_count
        nums[red_count + white_count:] = [2] * blue_count
        return

nums = [2,0,2,1,1,0]
Solution().sortColors(nums)
Solution().countColors(nums)
print(nums)