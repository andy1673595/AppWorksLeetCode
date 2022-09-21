
class Solution:
    # time: O(n)
    # space: O(n)
    def dict_solution(self, nums, target):
        dict = {}
        for index, elem in enumerate(nums):
            if target - elem in dict:
                return [dict[target - elem], index]
            else:
                dict[elem] = index

    # time: O(NlogN + logN) ~= O(NlogN)
    # space: O(N)
    def two_pointer_solution(self, nums, target):
        arr = []
        for index, elem in enumerate(nums):
            arr.append([elem, index])
        arr.sort() # O(nlogn)
        lft, rgt = 0, len(nums) - 1
        while lft < rgt: # logN
            sum = arr[lft][0] + arr[rgt][0]
            if sum == target:
                return [arr[lft][1], arr[rgt][1]]
            elif sum < target:
                lft += 1
            else:
                rgt -= 1

nums = [2,7,12,15,3]
target = 18
