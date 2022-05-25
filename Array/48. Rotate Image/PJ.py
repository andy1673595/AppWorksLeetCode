from typing import List


class BruteForceSolution:
    def rotate(self, matrix: List[List[int]]) -> None:
        new_matrix = []
        for i in range(len(matrix)):
            row = []
            for j in range(len(matrix)-1, -1, -1):
                row.append(matrix[j][i])
            new_matrix.append(row)
        for i in range(len(matrix)):
            for j in range(len(matrix)):
                matrix[i][j] = new_matrix[i][j]


class InplaceSolution:
    def rotate(self, matrix: List[List[int]]) -> None:
        def diagonal(matrix):
            for i in range(len(matrix)):
                for j in range(i, len(matrix)):
                    matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        def flip(matrix):
            for i in range(len(matrix)):
                for j in range(len(matrix)//2):
                    matrix[i][j], matrix[i][len(matrix)-1-j] = matrix[i][len(matrix)-1-j], matrix[i][j]
        diagonal(matrix)
        flip(matrix)
