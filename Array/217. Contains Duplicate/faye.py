class Solution:
    # time: O(n)
    # space: O(n)
    def hash_solution(self, nums):
        elem = {}
        for i in nums:
            if i in elem:
                return True
            elem[i] = 1
        return False

    # time: O(N) set building
    # space: O(N)
    def set_solution(self, nums):
        return len(nums) != len(set(nums))

    # time: O(nlogn)
    # space: O(1)
    def sort_solution(self, nums):
        if len(nums) < 1:
            return False
        nums.sort()
        for i in len(nums) - 1:
            if nums[i] == nums[i+1]:
                return True
        return False
