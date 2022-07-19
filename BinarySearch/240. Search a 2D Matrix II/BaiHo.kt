/**
 Time : O(NlogM)
 Space : O(1)

 [1,4,7,11,15],
 [2,5,8,12,19],
 [3,6,9,16,22],
 [10,13,14,17,24],
 [18,21,23,26,30]

 If we want to find 9,
 We will have the remaingin matrix

[1,4,7]
[2,5,8]
[3,6,9]

Then, do binary search for each row. Worst case time is O(NLogM)


Have another version answer with time complexity O(N+M).
 */
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        fun binarySearchRow(s: Int, e: Int) : Int {
            if (s >= e) return s
            val mid = (s+e+1)/2
            return if (matrix[mid][0] > target) {
                binarySearchRow(s, mid-1)
            } else {
                binarySearchRow(mid, e)
            }
        }
        
        fun binarySearchCol(s: Int, e: Int, row: Int) : Int {
            if (s >= e) return s
            val mid = (s+e+1)/2
            return if (matrix[row][mid] > target) {
                binarySearchCol(s, mid-1, row)
            } else {
                binarySearchCol(mid, e, row)
            }
        }
        
        val row = binarySearchRow(0, matrix.size - 1)
        val col = binarySearchCol(0, matrix[0].size -1, 0)
        for (i in 0 .. row) {
            val colIndex = binarySearchCol(0, col, i)
            if (matrix[i][colIndex] == target) return true
        }
        return false
    }
}