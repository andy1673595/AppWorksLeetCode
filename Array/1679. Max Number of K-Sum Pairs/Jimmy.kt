class Solution {

    // Time O(n)
    // Space O(n)
    fun maxOperationsDic(nums: IntArray, k: Int): Int {
        val dic = mutableMapOf<Int,Int>()
        var counter = 0

        nums.forEachIndexed{i, value ->

            if (value <= k) {
                println("value=$value, dic=$dic")
                // check if companion value is available
                if (dic.containsKey(k - value) && dic[k-value]!! > 0) {
                    dic[k-value]?.let { dic[k-value] = it-1; counter++ }
                } else {
                    if (!dic.containsKey(value)) { dic[value] = 1 }
                    else {
                        dic[value]?.let { dic[value] = it+1 }
                    }
                }
            }
        }
        return counter
    }

    // Time O(logn) -> sort algorithm + O(n) -> loop == O(logn)
    // Space O(1)
    fun maxOperationsSorted(nums: IntArray, k: Int): Int {
        var counter = 0
        if (nums.size <= 1) return counter

        nums.sort()
        var stop = false
        var startIndex = 0
        var endIndex = nums.size - 1
        var startingValue = nums.first()
        var endingValue = nums.last()

        while(!stop) {
            startingValue = nums[startIndex]
            endingValue = nums[endIndex]
            if (k - startingValue != endingValue) {
                if (k - startingValue > endingValue) {
                    startIndex++
                } else {
                    endIndex --
                }
            } else {
                startIndex ++
                endIndex --
                counter ++
            }
            stop = (startIndex >= endIndex)
        }
        return counter
    }
}