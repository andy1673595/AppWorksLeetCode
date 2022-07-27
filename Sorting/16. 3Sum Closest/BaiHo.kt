/**
Time : O(n^2)
Space: O(1)

Example: 
target = 1

mid = 1 :
[-5 , -4,  0,  1,  2,  3,  4]
  l    m   r                  sum = -9
  l    m       r              sum = -8
  l    m           r          sum = -7
   ...

mid = 2 :
[-5 , -4,  0,  1,  2,  3,  4]
       l   m   r              sum = -3
       l   m       r          sum = -2
    ...

mid = 3
[-5 , -4,  0,  1,  2,  3,  4]
           l   m   r          sum = 3
       l       m   r          sum = -2
       l       m       r      sum = 0
       l       m           r  sum = 1

 */
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closest = Int.MAX_VALUE
        var minOffset = Int.MAX_VALUE
        for (mid in 1 .. nums.size - 2) {
            var left = mid - 1
            var right = mid + 1
            while (left >= 0 && right < nums.size) {
                val sum = nums[left] + nums[mid] + nums[right]
                val offset = sum - target
                if (offset > 0) {
                    left --
                } else if (offset < 0) {
                    right ++
                } else {
                    return target
                }
                val absOffset = Math.abs(offset)
                if (absOffset < minOffset) {
                    minOffset = absOffset
                    closest = sum
                }
            }
        }
        return closest
    }
}