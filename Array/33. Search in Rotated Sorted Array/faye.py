# 將一個從小到大排列的陣列任意取一點 pivot 切一半，並前後交換
# 給定一任意 target，在 O(logN) 內找出 target 的 index，如果不存在回傳 -1
# 陣列可能不會交換過
# 陣列長度在 1 <= nums.length <= 5000，每個元素只存在一次
# 時間複雜度: O(logN)
# 空間複雜度: O(1)

class Solution:
    def search(self, nums, target):
        lft = 0
        rgt = len(nums) - 1
        while lft <= rgt:
            mid = (lft + rgt) // 2  # 取整數,因此 mid 會偏左
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[lft]: # 判斷為 left rotated ; 因為有可能 nums 只有一個數字所以要 >=
                if nums[lft] <= target < nums[mid]: # 因為已經先確認 mid 不是 target 所以可以不用 =
                    rgt = mid - 1
                else:
                    lft = mid + 1
            else: # right rotated
                if nums[mid] < target <= nums[rgt]:
                    lft = mid + 1
                else:
                    rgt = mid - 1
        return -1



nums = [5,6,7,8,9,10,11,12,1,2,3,4]
target = 0
ans = Solution().search(nums, target)
print(ans)