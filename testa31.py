import unittest
from a3 import *
from GetData import *
# Q=fileToStringList('EnglishWords.txt')
class testa3(unittest.TestCase):

    def test_offbyk(self):
        self.assertEqual(offByK('hello', 'hetto', 2), True)
        self.assertEqual(offByK('oh okay', 'okay', 3), False)
        self.assertEqual(offByK('mymy', 'heyy', 3), True)
        self.assertEqual(offByK('hi my name', 'he my name', 1), True)
        self.assertEqual(offByK('e', 'E', 1), True)
    def test_offbyswapos(self):
        self.assertEqual(offBySwaps('aaaa', 'aaaa'), True)
        self.assertEqual(offBySwaps('bleak', 'aelbk'), True)
        self.assertEqual(offBySwaps('aA', 'aa'), False)
        self.assertEqual(offBySwaps('forgett', 'foorget'), False)
        self.assertEqual(offBySwaps('home', 'amazing'), False)

    def test_offbykextra(self):
        self.assertEqual(offByKExtra('aa', 'aa', 0), True)
        self.assertEqual(offByKExtra('word', 'ordws', 1), False)
        self.assertEqual(offByKExtra('abcdefg','abdcfdgtefyug', 6), True)
        self.assertEqual(offByKExtra('word', 'powerful', 4), False)
        self.assertEqual(offByKExtra('', 'aa', 2), True)
        self.assertEqual(offByKExtra('hello','heleoo',1),False)

    def test_listofnearwords(self):
        L=fileToStringList('EnglishWords.txt')
        self.assertEqual(ListOfNearStrings('aa', L[:20], 1), ['a','aah','ab'])
        self.assertEqual(ListOfNearStrings('abandon', L[:20], 2), ['abandon', 'abandoned', 'abandonee'])
        self.assertEqual(ListOfNearStrings('word',L[1000:9000],2),['bard'])
        self.assertEqual(ListOfNearStrings('testing',L[1000:900000],0), ['setting', 'testing'])
        self.assertEqual(ListOfNearStrings('house',L[:90],2),[])
        self.assertEqual(ListOfNearStrings('',L[1:200],2),['ab'])


if __name__=='__main__':
	unittest.main()
