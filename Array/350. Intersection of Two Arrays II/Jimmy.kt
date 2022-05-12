class Solution {
    /**
     * 想法：
     * 使用 dictionary 紀錄較短的 arrayA 中的 值與出現次數 {value: 次數}
     * 再經由 for loop 在較長的 arrayB 與 dictionary 做對比。
     * 每當 arrayB 中出現 dictionary key 中之值，且次數 != 0 就將次數 -1 並記錄此值在新的 array 中 (ans)。
     * 最後再回傳 ans
     * 
     * Time O(n) //ans
     * Space ... 不會算
     */
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        val dic = mutableMapOf<Int, Int>()
        val ans = mutableListOf<Int>()

        if (nums1.size > nums2.size) {
            nums2.forEachIndexed { i, value ->

                if (!dic.containsKey(value)) {
                    dic[value] = 1
                } else {
                    dic[value]?.let {
                        dic[value] = it + 1
                    }
                }
            }

            nums1.forEachIndexed { i, value ->
                dic[value]?.let {
                    if (it > 0) {
                        ans.add(value)
                        dic[value] = it - 1
                    }
                }
            }
        } else {
            nums1.forEachIndexed { i, value ->

                if (!dic.containsKey(value)) {
                    dic[value] = 1
                } else {
                    dic[value]?.let {
                        dic[value] = it + 1
                    }
                }
            }

            nums2.forEachIndexed { i, value ->
                dic[value]?.let {
                    if (it > 0) {
                        ans.add(value)
                        dic[value] = it - 1
                    }
                }
            }
        }

        return ans.toIntArray()
    }
}