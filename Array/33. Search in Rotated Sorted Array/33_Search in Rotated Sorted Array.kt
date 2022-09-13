
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        // binary search
        while (left <= right) {
            val mid = (right + left) / 2

            if (nums[mid] == target) return mid

            if (nums[mid] > nums[right]) {
                if (target < nums[mid] && target >= nums[left])
                    right = mid - 1
                else
                    left = mid + 1
            } else {
                if (target > nums[mid] && target <= nums[right])
                    left = mid+1
                else
                    right = mid - 1
            }
        }
        return -1
    }
}
