/**
Time O(n^2)
Space O(1)
 */
class Solution48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val size = matrix.size
        val tmp = Array(size) { IntArray(size) }

        for (i in 0 until size) {
            for (j in 0 until size) {
                tmp[i][j] = matrix[size - j - 1][i]
            }
        }
        for (i in 0 until size) {
            for (j in 0 until size) {
                matrix[i][j] = tmp[i][j]
            }
        }
    }
}

fun main() {
    val matrix =
        arrayOf(intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10), intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16))
    Solution48().rotate(matrix)

}