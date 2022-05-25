class Solution {
    /*
    * 想法：
    * 我們可以 Loop 過整個 array 並將非零值一到前面去，其他的則都設為 0
    * 
    * 我們可以這麼做：
    *   用 nextTargetIndex 來將目前最前面可放非零值的 index 紀錄下來
    *   當找到非零時，我們就可以將其放入 [nextTargetIndex] 位置，並讓 nextTargetIndex 增 1
    * 
    * 如此一來我們就可以用 1 次 loop 將所有的非零值都一到前面並保留順序，且也將剩餘的空間都更改為 0 。
    *
    * [1,0,1,3,2]
    *   nextTargetIndex = -1
    *   for
    *   i = 0 -> nextTargetIndex = -1
    *   i = 1 -> nextTargetIndex = i = 1
    *   i = 2 -> [2] -> [1] ==> [1,1,0,3,2]
    *
    *
    * Time: O(n)
    * Space: O(1)
    * */
    fun moveZeroesTrail_1(nums: IntArray): Unit {
        var nextTargetIndex = -1

        nums.forEachIndexed { i, value ->
            if (value == 0 && nextTargetIndex == -1) nextTargetIndex = i
            else if (value != 0 && nextTargetIndex != -1) {
                nums[nextTargetIndex] = value
                nums[i] = 0
                nextTargetIndex++
            }
        }
    }
}