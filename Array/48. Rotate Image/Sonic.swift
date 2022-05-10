// 48. Rotate Image

class Solution {
    func rotate(_ matrix: inout [[Int]]) {
        let count = matrix.count
        for i in 0..<count {
            for j in 0..<count {
                matrix[i].append(matrix[count - 1 - j][i])
            }
        }
        for i in 0..<count {
            matrix[i] = matrix[i].suffix(count)
        }
    }
}