#SAJAG AGARWAL 2016185 KAUSTAV VATS 2016048
import unittest
from a4 import *

class a4test(unittest.TestCase):
	def testmatrix_rank(self):
		self.assertEqual(MatrixRank([[1,2,3],[4,5,6]]),2)
		self.assertEqual(MatrixRank([[1,2,3]]),1)
		self.assertEqual(MatrixRank([[10,19,75],[0,0,1],[0,0,0]]),2)
		self.assertEqual(MatrixRank([[0,0,0,0,0,0,0],[0,0,1,0,0,0,0],[1,1,1,1,1,1,1],[0,0,0,0,0,0,1],[1,0,0,0,0,0,0]]),4)
		self.assertEqual(MatrixRank([[1,1,1,1,1,1],[0,0,0,0,0,1],[0,0,0,0,0,0]]),2)
		self.assertEqual(MatrixRank([[0,0,0]]),0)
		self.assertEqual(MatrixRank([[0],[0],[1]]),1)
		self.assertEqual(MatrixRank([[0,0,1],[1,2,0],[0,0,0]]),2)
		self.assertEqual(MatrixRank([[1,0,-2,1,0],[0,-1,-3,1,3],[-2,-1,1,-1,3],[0,3,9,0,-12]]),3)
		self.assertEqual(MatrixRank([[1,2,0,-1,1],[1,3,1,1,-1],[2,5,1,0,0],[3,6,0,0,-6],[1,5,3,5,-5]]),3)
		self.assertEqual(MatrixRank([[0]]),0)
		self.assertEqual(MatrixRank([[1,2,3],[4,5,8],[9,15,14]]),3)
		self.assertEqual(MatrixRank([[2,1,5,0],[7,3,5,2]]),2)
		self.assertEqual(MatrixRank([[1,2,3],[2,3,5],[3,4,7],[4,5,9]]),2)
		self.assertEqual(MatrixRank([[2,1,5,0],[2,1,5,0],[1,1,1,1],[1,1,1,1]]),2)
		self.assertEqual(MatrixRank([[1,2,3],[4,5,6],[7,8,9]]),2)
        

if __name__=='__main__':
    unittest.main()
