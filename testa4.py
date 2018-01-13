# Ankur Sharma 2016225
# Sahil Angral 2016082
#HW4
import unittest
from a4 import *

class testpoint(unittest.TestCase):
	def testrank(self):
		self.assertEqual(MatrixRank([[1,1,1],[1,1,1],[1,1,1]]),1)
		self.assertEqual(MatrixRank([[0,0],[0,0]]),0)
		self.assertEqual(MatrixRank([[1,2,4,4],[3,4,8,0]]),2)
		self.assertEqual(MatrixRank([[1,2,3],[2,3,5],[3,4,7],[4,5,9]]),2)
		self.assertEqual(MatrixRank([[3,3,6],[3,1,0],[1,0,0]]),3)
		self.assertEqual(MatrixRank([[1,1,1],[1,1,1],[1,1,1]]),1)
		self.assertEqual(MatrixRank([[0,0],[0,0]]),0)
		self.assertEqual(MatrixRank([[0,16,8,4],[2,4,8,16],[16,8,4,2],[4,8,16,2]]),4)
		self.assertEqual(MatrixRank([[1,2,3],[2,3,5],[3,4,7],[4,5,9]]),2)
		self.assertEqual(MatrixRank([[0,1,0],[0,0,1],[1,2,3]]),3)
		self.assertEqual(MatrixRank([[1,3],[2,-1],[-1,-3]]),2)
		self.assertEqual(MatrixRank([[1,2,0,5],[2,3,1,4],[-1,-1,-1,1]]),2)
		self.assertEqual(MatrixRank([[10,20,10],[20,40,20],[30,50,0]]),2)
		# '''EXTRAAAAAAAAAAAAAAAAAa'''
		# A=[[0, 1, 2], [1, 2, 1], [2, 7, 8]]
		# A2 = [[2, -1, 3], [1, 0, 1], [0, 2, -1], [1, 1, 4]]
		# B = [[1, -2, 0, 4], [3, 1, 1, 0], [-1, -5, -1, 8],[3, 8, 2, -12]]
		# C = [[1, -1, 1, -1], [-1, 1, -1, 1], [1, -1, 1, -1], [-1, 1, -1, 1]]
		# D = [[0, 1, 2], [1, 2, 1], [2, 7, 8]]
		# E = [[1, 2, 4, 4], [3, 4, 8, 0]]
		# F=[[1,2,3],[0,0,0],[450,2,0]]
		# G=[[1,0,0,0],[0,0,0,0]]
		# H=[[0,0,0,0,0],[0,3,0,4,1],[0,0,0,0,0],[0,0,1,2,3],[0,0,0,0,0]]
		# I=[[2,1,5,0],[7,3,5,2]]
		# self.assertEqual(MatrixRank(A), 2)
		# self.assertEqual(MatrixRank(A2), 3)
		# self.assertEqual(MatrixRank(B), 2)
		# self.assertEqual(MatrixRank(C), 1)
		# self.assertEqual(MatrixRank(D), 2)
		# self.assertEqual(MatrixRank(E), 2)
		# self.assertEqual(MatrixRank(F), 2)
		# self.assertEqual(MatrixRank(G), 1)
		# self.assertEqual(MatrixRank(I), 2)

if __name__=='__main__':
	unittest.main()