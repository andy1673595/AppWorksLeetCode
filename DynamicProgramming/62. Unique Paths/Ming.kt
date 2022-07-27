/**
 Time : ?
 Space: O(1)

目的: 選擇左上到右下不同的路徑總數
作法: (m+n)! / (m! * n!)
例如: 長2格, 寬3格，即向下2格，向右1格，即可到目的地，DDR 排列(3! / (2! * 1!)):
      1. D -> D -> R
      2. D -> R -> D
      3. R -> D -> D

做法:
1. 其中一個為 1，則走法只有一種，不是向右，就是向下
2. m1 = m-1, n1 = n-1
3. 排列式整理後，[假如 m 比較大] 將可以簡化成 (m1+1)*(m1+2)....*(m1+n1)/(1*2*...n)

 */
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 1 || n == 1) return 1

        var uniPath = 1L
        var i = if (m > n) m else n
        var j = 1

        while (i <= (m + n - 2)) {
            uniPath *= i
            uniPath /= j
            i++
            j++
        }

        return uniPath.toInt()
    }
}