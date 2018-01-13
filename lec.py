# lec.py
def p(x,n):
	if n>0:
		u=x*p(x,n-1)
		return u
	else:
		return 1
# print(p(3,2))

def fib(n):
	f=0
	s=1
	if n==0:
		return 0
	elif n==1:
		return 1
	else:
		t=fib(n-1)+fib(n-2)	
		return t
# print(fib(5))

def rev(s):
	if(len(s)>0):
		t=s[-1]+rev(s[:-1])
		return t
	else:
		return s
# print(rev("PPAP"))
