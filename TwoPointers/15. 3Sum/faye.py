class Solution:
    def threeSum(self, nums):
        # space: O(N)
        # time: O(2^N)
        if len(nums) < 3:
            return []
        ans = []        
        nums.sort()
        for x in range(len(nums)):
            if x > 0 and nums[x-1] == nums[x]:
                continue
            target = 0 - nums[x]
            y = x + 1
            z = len(nums) - 1
            while y < z:
                if nums[y] + nums[z] < target:
                    y += 1
                elif nums[y] + nums[z] > target:
                    z -= 1
                else:
                    ans.append([nums[x],nums[y],nums[z]])
                    y += 1 # 這邊只有 y+1 是因為要固定 z
                    while y < z and nums[y] == nums[y-1]: # 這邊不能用 if ，如果用 if 的時候遇到 [0,0,0,0,0,0] 這個情況只會 skip 一次
                        y += 1
        return ans

# [-4, -1, -1, 0, 1, 2]
# [0,0,0,0,0,0]
nums = [0,0,0,0,0,0]
a = Solution().threeSum(nums)
print(a)