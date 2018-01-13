def f1(l):
	if len(l)==0:
		return 0
	else:
		return l[0] + f1(l[1:])
print(f1([1,4,2,5,3]))

l=[[1],[2,5],[100,2,-100],[4,9,41,0]
def ms(i,j):
	if i==len(l)-1:
		return l[i][j]
	elif j==0:
		return l[i][j]+min(ms(i+1,j),ms(i+1,j+1))
	else:
		return l[i][j]+min(ms(i+1,j),ms(i+1,j+1),ms(i+1,j-1))
ms(0,0)