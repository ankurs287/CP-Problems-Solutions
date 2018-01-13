import unittest
from a1 import *

class testpoint(unittest.TestCase):
	
	def testresponse(self):
		self.assertEqual(currency_response("USD","BGN","1"),'b\'{ "lhs" : "1 United States Dollar", "rhs" : "1.750618 Bulgarian Levs", "valid" : true, "error" : "" }\'')
		self.assertEqual(currency_response("INR","NAD","2"),'b\'{ "lhs" : "2 Indian Rupees", "rhs" : "0.43576301835407 Namibian Dollars", "valid" : true, "error" : "" }\'')
		self.assertEqual(currency_response("FKP","SOS","0.5"),'b\'{ "lhs" : "0.5 Falkland Islands Pounds", "rhs" : "387.37397596288 Somali Shillings", "valid" : true, "error" : "" }\'')
		self.assertEqual(currency_response("EUR","INR","0.1"),'b\'{ "lhs" : "0.1 Euros", "rhs" : "7.4427613522258 Indian Rupees", "valid" : true, "error" : "" }\'')
		self.assertEqual(currency_response("SOS","USD","INR"),'b\'{ "lhs" : "", "rhs" : "", "valid" : false, "error" : "Currency amount is invalid." }\'')

	def testquery(self):
		self.assertEqual(has_error('b\'{ "lhs" : "", "rhs" : "", "valid" : false, "error" : "Currency amount is invalid." }\''),True)
		self.assertEqual(has_error('b\'{ "lhs" : "4 Euros", "rhs" : "297.71045408903 Indian Rupees", "valid" : true, "error" : "" }\''),False)
		self.assertEqual(has_error('b\'{ "lhs" : "2 Afghan Afghanis", "rhs" : "2.0018341339558 Indian Rupees", "valid" : true, "error" : "" }\''),False)
		self.assertEqual(has_error('b\'{ "lhs" : "", "rhs" : "", "valid" : false, "error" : "Source currency code is invalid." }\''),True)
		self.assertEqual(has_error('b\'{ "lhs" : "", "rhs" : "", "valid" : false, "error" : "Exchange currency code is invalid." }\''),True)
		
		
	def testexchange(self):
		self.assertEqual(exchange("INR","AFN","1"),0.99908377326338)
		self.assertEqual(exchange("EUR","USD","2"),2.2313957380341)
		self.assertEqual(exchange("INR","SOS","one"),-1)
		self.assertEqual(exchange("ABC","DEF","3"),-1)
		self.assertEqual(exchange("AFN","FKP","3"),0.03385695270561)
		

if __name__=='__main__':
	unittest.main()
