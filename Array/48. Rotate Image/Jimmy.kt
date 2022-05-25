
class Solution {
    // Time : O(n^2) 
    // Space : O(1)
    /*
    * 想法：旋轉矩陣時我們會發現 
    * 
    * _____________        _____________
    * | 1 | 4 | 7 |        | 3 | 2 | 1 |
    * | 2 | 5 | 8 | ===>   | 6 | 5 | 4 |
    * | 3 | 6 | 9 |        | 9 | 8 | 7 |
    * -------------        -------------
    * 
    * 四個角                       四邊
    * (0,0) [1] -> (2,0) [7]      (1,0) [4] -> (2,1) [8]
    * (2,0) [7] -> (2,2) [9]      (2,1) [8] -> (1,2) [6]
    * (2,2) [9] -> (0,2) [3]      (1,2) [6] -> (0,1) [2]
    * (0,2) [3] -> (0,0) [1]      (0,1) [2] -> (1,0) [4]
    * 
    * 我們會發現以下規律：
    * i 為外圍 layers
    * j 為內部 elements
    * (j,i) -> (n-i-1, j)
    * (n-i-1, j) -> (n-j-1, n-i-1)
    * (n-j-1, n-i-1) -> (n-(n-i-1)-1, n-j-1) -> (i, n-j-1)
    * (i, n-j-1) -> (j, i)
    * */
    fun myRotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        for (i in 0 until n/2) {
            for (j in i until n-i-1) {
                val temp = matrix[j][i]
                matrix[j][i] = matrix[n - i - 1][j]
                matrix[n - i - 1][j] = matrix[n - j - 1][n - i - 1]
                matrix[n - j - 1][n - i - 1] = matrix[i][n - j - 1]
                matrix[i][n - j - 1] = temp
            }
        }
    }
}