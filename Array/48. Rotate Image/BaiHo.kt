/**
Time O(n^2)
Space O(1)
*/
class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        // [1, 2, 3]
        // [4, 5, 6]
        // [7, 8, 9]
        
        
        // diagonal flip
        // [1, 4, 7]
        // [2, 5, 8]
        // [3, 6, 9]
        for (i in 0 until n) {
            for (j in i+1 until n) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp
            }
        }
        // horizontal flip
        // [7 ,4, 1]
        // [8 ,5, 2]
        // [9 ,6, 3]
        for (i in 0 until n) {
            for (j in 0 until n/2) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[i][n-1-j]
                matrix[i][n-1-j] = tmp
            }
        }
    }
}