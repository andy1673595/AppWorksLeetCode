class Solution {

    /**
     * 想法：
     * 我們需要知道 k 值是否可以經過全部的 elements。
     *
     * 我們先看看在不同 size 時會發生什麼事吧
     * size     k       steps
     *  1       1
     *  2       1       2 : [a,b] -> [a,a] -> [b,a] 需要用兩步才能得到結果
     *  3       1       3 : [a,b,c] -> [a,a,c] -> [a,a,b] -> [c,a,b] 三步
     *          2       3 : [a,b,c] -> [a,b,a] -> [c,b,a] 兩步 --> 我們還可以將 [b] 的不動當作是 1 步，所以還是三步
     *
     * 這時你會發現無論 k 值，所需的步驟皆為 n，且會被互相需要看同一組的值即可 (像是 k = 2 時 [a,b,c] 可分為 {a,c} 與 {b} 兩組)
     * size     k      groups
     * 4        2      2 : [a,b,c,d] -1 {a,c} -> [a,b,a,d] -> [c,b,a,d]
     *                               -2 {b,d} -> [c,b,a,b] -> [c,d,a,b]
     *          3      1 : [a,b,c,d] -> [a,b,c,a] -> [a,b,d,a] -> [a,c,d,a] -> [b,c,d,a]
     *
     * 5        1-4    1
     * 6        2      2 : [a,b,c,d,e,f] -1 {a,c,e} -> [a,b,a,d,e,f] -> [a,b,a,d,c,f] -> [e,b,a,d,c,f]
     *                                   -2 {b,d,f} -> [e,b,a,b,c,f] -> [e,b,a,b,c,d] -> [e,f,a,b,c,d]
     *          3      3 : [a,b,c,d,e,f] -1 {a,d} -> [a,b,c,a,e,f] -> [d,b,c,a,e,f]
     *                                   -2 {b,e} -> [d,b,c,a,b,f] -> [d,e,c,a,b,f]
     *                                   -3 {c,f} -> [d,e,c,a,b,c] -> [d,e,f,a,b,c]
     *          4      2 : [a,b,c,d,e,f] -1 {a,e,c} -> [a,b,c,d,a,f] -> [a,b,e,d,a,f] -> [c,b,e,d,a,f]
     *                                   -2 {b,f,b} -> [c,b,e,d,a,b] -> [c,b,e,f,a,b] -> [c,d,e,f,a,b]
     *
     * 你會發現 group 的值其實是 k 與 size 的 GCD。
     * 所以我們可以用 GCD 值來找到相對的數組
     *
     * 而每個數組中數字的 indexes 為：
     * for (i in 0 until GCD) {
     *      [i], [(i + k)%size], [(i + 2k)%size] ... 直到回到 [i]
     * }
     *
     * 因此，我們可以寫成：
     * for (i in 0 until GCD) {
     *      var nextIndex = i + k
     *      var temp = nums[i]
     *      while(nextIndex != i) {
     *          val nextTemp = nums[nextIndex]
     *          nums[nextIndex] = temp
     *          temp = nextTemp
     *          nextIndex = (nextIndex + k)%size
     *      }
     *      nums[nextIndex] = temp
     * }
     *
     *
     * Time : ... 不會算
     * Space: O(1)
     *
     */
    fun rotate(nums: IntArray, k: Int): Unit {

        fun findGCD(a: Int, b: Int): Int {
            var larger = a
            var smaller = b
            if (b > larger) {larger = b; smaller=a}
            val r = larger%smaller
            if (r == 0) {return minOf(a,b)}
            return findGCD(smaller, r)
        }


        val size = nums.size
        val newK = k%size
        if (newK == 0) {return}

        val gcd = findGCD(size, newK)

        for (i in 0 until gcd) {
            var nextIndex = (i + newK)%size
            var temp = nums[i]
            while(nextIndex != i) {
                val nextTemp = nums[nextIndex]
                nums[nextIndex] = temp
                temp = nextTemp
                nextIndex = (nextIndex + newK)%size
            }
            nums[nextIndex] = temp
        }
    }
}