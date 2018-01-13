from random import randint
import sys
import math
import re

last=0
# a=[]
for i in range(1,900):
	j= int(math.floor(math.exp(1)*i))
	if(j-last==2):
		print
		sys.stdout.write(str(i)+" ")
	sys.stdout.write(str(j-last)+" ")
	last=j

last=0
s=""
for i in range(1,20000):
	j= int(math.floor(math.exp(1)*i))
	s=s+str(j-last)
	last=j


a=[i for i in range(len(s)) if s.startswith('23332333', i)]
# print m
# print(s.find("23332333"))
# print a

last=0
s=""
for i in a:
	s=s+str(i-last)
	# print str(i+1)+" "+str(i-last)
	last=i
# print s

# a=[i for i in range(len(s)) if s.startswith('3939', i)]
# print a