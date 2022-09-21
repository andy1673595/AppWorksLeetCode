class Solution:
    # time: O(N)
    # space: O(1)
    def maxArea(self, height):
        water = 0
        left, right = 0, len(height) - 1
        while left < right:
            water = max(water, (right - left) * min(height[left], height[right]))
            if height[left] < height[right]: # 比較小的前進一步 因為下一個有可能更高
                left += 1 
            else:
                right -= 1
        return water


# height[i] == height[j] 的 case
# 因為受限於寬，所以下一個有相同高度的高一定會比較小，因此不需要比較 height[i] == height[j] 的 case

height = [1,8,6,2,5,4,8,3,7]
ans = Solution().maxArea(height)
print(ans)