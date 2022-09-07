class Solution:
    def rotate(self, matrix):
        l = 0
        r = len(matrix) - 1
        while l < r:
            matrix[l], matrix[r] =  matrix[r],  matrix[l]
            l += 1
            r -= 1
        for i in range(len(matrix)):
            for j in range(i):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
Solution().rotate(matrix)
