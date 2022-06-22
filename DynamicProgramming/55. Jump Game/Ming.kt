/**
Time  : O(n)
Space : O(1) 


作法:
1. 宣告 int max 用於記錄 nums array 可以走的最大步數
   最大步數為:值(當前可以走的步數) + 位置 index
2. 迴圈逐一查看:
   2-1 if(i > max) return false
       表示當前的位置 -> 已經超過可以走的步數
   2-2 if(max >= (length-1)) return true
       表示最大步數 -> 可以走超過(到達)最後一個位置
   2-3 max = Math.Max(max, nums[i] + i)
       max(目前最大步數) 與 [值(當前可以走的步數) + 位置 index] 取最大值
3. 迴圈結束後，沒有 return false，代表這個 array 是有辦法走到最後的，因此 return true

 */
class Solution {
    fun canJump(nums: IntArray): Boolean {
        val length: Int = nums.size
        if (length == 0) return false

        var max = 0
        for (i in 0 until length) {
            if (i > max) return false
            if (max >= (length-1)) return true
            max = Math.max(max, nums[i] + i)
        }

        return true
    }
}