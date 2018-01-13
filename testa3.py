#Sahil Angral 2016082
#Ankur Sharma 2016225
import unittest
from a3 import *
from GetData import *
Q=fileToStringList('EnglishWords.txt')
# print(ListOfNearStrings("abss",Q[400:430],5))
class testpoint(unittest.TestCase):

        def testoffK(self):
            self.assertEqual(offByK("Zender","zENDER",6),True)
            self.assertEqual(offByK("Zender","Zender",0),True)
            self.assertEqual(offByK("dd","dD",2),False)
            self.assertEqual(offByK("JJAAck","jjAAcK",3),True)
            self.assertEqual(offByK("JJAAck","jjAAcK",0),False)

        def testoffS(self):
            self.assertEqual(offBySwaps("inDia","iDnai"),True)
            self.assertEqual(offBySwaps("JJAAck","kAAJcJ"),True)
            self.assertEqual(offBySwaps("Diary","iDrya"),True)
            self.assertEqual(offBySwaps("a","a"),True)
            self.assertEqual(offBySwaps("AAaaAa","aAaAaA"),True)

        def testoffE(self):
            self.assertEqual(offByKExtra("DesII","esII",1),True)
            self.assertEqual(offByKExtra("union","unionnn",2),True)
            self.assertEqual(offByKExtra("XenonX","XenonX",6),False)
            self.assertEqual(offByKExtra("XenonX","xENONx",6),False)
            self.assertEqual(offByKExtra("AAaaAa","AAAaaAaa",2),True)

        def testcompare(self):
            self.assertEqual(compare_distr([1,3,4,7,2,3,4,5,8,5],[17,12,14,18,15,14,13,15,13,11],3),True)
            self.assertEqual(compare_distr([1,3,4,7,2,3,4,5,8,5],[17,12,14,18,15,14,13,15,13,11],1),True)
            self.assertEqual(compare_distr([1,3,4,7,2,4,8,5,4,7],[17,12,14,17,15,14,13,16,14,11],1),False)
            self.assertEqual(compare_distr([2,5,3,2,5],[33,31,35,32,36],2),False)
            self.assertEqual(compare_distr([1,3,4,7,2,3],[17,12,14,19,13,14],3),True)

        def testList(self):
            self.assertEqual(ListOfNearStrings("aa",Q[:20],1),['a','aah','ab'])
            self.assertEqual(ListOfNearStrings("abet",Q[100:120],4),['aberrant', 'abet', 'abetment'])
            self.assertEqual(ListOfNearStrings("abo",Q[200:220],4),['abo', 'aboding', 'abolish'])
            self.assertEqual(ListOfNearStrings("abss",Q[400:430],5),['abstracts', 'abstricts', 'abstruser'])
            self.assertEqual(ListOfNearStrings("act",Q[1000:1020],5),['actually', 'actuated', 'actuates', 'actuator', 'acuities'])

if __name__=='__main__':
	unittest.main()