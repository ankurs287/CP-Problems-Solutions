import unittest
from a4 import *


class testa4(unittest.TestCase):
    def testMatrixRank(self):
        A = [[2, -1, 3], [1, 0, 1], [0, 2, -1], [1, 1, 4]]
        B = [[1, -2, 0, 4], [3, 1, 1, 0], [-1, -5, -1, 8],[3, 8, 2, -12]]
        C = [[1, -1, 1, -1], [-1, 1, -1, 1], [1, -1, 1, -1], [-1, 1, -1, 1]]
        D = [[0, 1, 2], [1, 2, 1], [2, 7, 8]]
        E = [[1, 2, 4, 4], [3, 4, 8, 0]]
        self.assertEqual(MatrixRank(A), 3)
        self.assertEqual(MatrixRank(B), 2)
        self.assertEqual(MatrixRank(C), 1)
        self.assertEqual(MatrixRank(D), 2)
        self.assertEqual(MatrixRank(E), 2)


if __name__ == '__main__':
    unittest.main()
