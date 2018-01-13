from fractions import gcd
class f():
	def __init__(self,p,q=1):
		d=gcd(p,q)
		# print(d)
		self.num=p//d
		self.den=q/d
	def __str__(self):
		return str(self.num)+"/"+str(self.den)
# print(isinstance(9/4,f))
print(f(10))

