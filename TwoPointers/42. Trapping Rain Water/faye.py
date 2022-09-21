class Solution:
    def dp_solution(self, height):
        # Dynanmic Programmin : 先列出每一點的左邊和右邊最高的牆
        # time: O(N)
        # space: O(N)
        if not height:
            return 0
        n = len(height)
        max_left = [0] * n
        max_right = [0]* n

        for i in range(1, n):
            max_left[i] = max(max_left[i - 1], height[i-1])

        for j in range(n-2, -1, -1): # 倒過來遍例陣列
            max_right[j] = max(max_right[j + 1], height[j + 1])
        
        trapped_water = 0
        for k in range(n):
            lower_wall = min(max_left[k], max_right[k]) # 可以裝的水量是由比較低的牆決定的
            trapped_at_k = lower_wall - height[k]
            if trapped_at_k > 0:
                trapped_water += trapped_at_k

        return trapped_water

    def two_pointer(self, height):
        # two pointer
        # time: O(N)
        # space: O(1)
        if not height:
            return 0
        left, right = 0, len(height) - 1
        left_max = height[left]
        right_max = height[right]
        trapped_water = 0
        while left < right:
            if left_max < right_max:
                left += 1
                left_max = max(left_max, height[left])
                trapped_water += left_max - height[left]
            else:
                right -= 1
                right_max = max(right_max, height[right])
                trapped_water += right_max - height[right]
        return trapped_water

height = [0,1,0,2,1,0,1,3,2,1,2,1]
ans = Solution().two_pointer(height)
print(ans)