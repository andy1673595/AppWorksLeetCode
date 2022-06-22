# time: O(n)
# space: O(1)

class Solution:
    def canJump(self, nums) -> bool:
        step = 0
        for i, n in enumerate(nums):
            if i > step:
                return False
            step = max(step, i + n)
        return True

nums = [
    [2,3,1,1,4],
    [3,2,1,0,4],
    [2,5,0,0],
    [2,0],
    [2,3,1,1,4],
    [0]
]
for i in nums:
    print(Solution().canJump(i))