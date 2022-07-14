/**
Time : O(n)
Space: O(1)


Test case : [2,0,2,1,1,0]

[2, 0, 2, 1, 1, 0] whiteIndex = 0 blueIndex = 0
[0, 2, 2, 1, 1, 0] whiteIndex = 1 blueIndex = 1
[0, 2, 2, 1, 1, 0] whiteIndex = 1 blueIndex = 1
[0, 1, 2, 2, 1, 0] whiteIndex = 1 blueIndex = 2
[0, 1, 1, 2, 2, 0] whiteIndex = 1 blueIndex = 3
[0, 0, 1, 1, 2, 2] whiteIndex = 2 blueIndex = 4

 */
const val RED = 0
const val WHITE = 1
const val BLUE = 2
class Solution {
    fun sortColors(nums: IntArray): Unit {
        var whiteIndex = 0
        var blueIndex = 0
        
        fun swap(a: Int, b: Int) {
            val tmp = nums[a]
            nums[a] = nums[b]
            nums[b] = tmp
        }
        
        nums.forEachIndexed { i, n ->
            when(n) {
                RED -> {
                    swap(blueIndex, i)
                    swap(whiteIndex, blueIndex)
                    whiteIndex++
                    blueIndex++
                }
                WHITE -> {
                    swap(blueIndex, i)
                    blueIndex++
                }
                BLUE -> {
                    // do nothing
                }
            }
        }
    }
}