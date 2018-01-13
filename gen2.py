from random import randint
import sys
import math
import re

last=0
li=0
for i in range(1,1900):
	j= int(math.floor(math.exp(1)*i))
	if(j-last==3):
		sys.stdout.write(str(i-li)+" ")
		li=i
	last=j