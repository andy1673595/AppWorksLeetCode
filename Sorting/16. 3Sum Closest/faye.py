# three pointers
# time: O(n^2 + nlogn) = O(n^2) 

class Solution:
    def threeSumClosest(self, nums, target):
        nums.sort() # nlogn
        res = sum(nums[:3])

        for i in range(len(nums)): # n^2
            l, r = i+1, len(nums)-1
            while l < r:
                s = sum((nums[i], nums[l], nums[r]))
                if abs(s-target) < abs(res-target):
                    res = s
                if s < target:
                    l += 1
                elif s > target:
                    r -= 1
                else:
                    return res
        return res


nums = [-1,2,1,-4]
target = 1

Solution().threeSumClosest(nums, target)
