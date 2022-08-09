# space: O(n)
# time: O(logN)

class Solution:
    def mySqrt(self, x: int) -> int:
        l = 0
        r = x
        while l <= r:
            mid = (l + r) // 2
            if mid*mid <= x < (mid+1)*(mid+1):
                return mid
            elif mid*mid > x:
                r = mid - 1
            else:
                l = mid + 1
