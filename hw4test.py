def swapRows(A,row1,row2):
	A[row1], A[row2] = A[row2], A[row1]
	"""temp=[]
	temp=A[row1-1]
	A[row1-1]=A[row2-1]
	A[row2-1]=temp"""

def Row_Transformation(A,x,row1,row2):
	cols=len(A[0])
	row1=int(row1)
	row2=int(row2)
	for i in range(cols):
		A[row2][i]=A[row2][i]+x*A[row1][i]
def MatrixRank(A):
	rows=len(A)
	cols=len(A[0]) 
	i=0
	p=0
	while i+p < cols and i<rows:	
		if(A[i][i+p]==0):
			p+=1
			continue
		if(A[i][i+p]==0):
			for t in range(i+1,rows):
				if A[t][i+p]!=1:
					swapRows(A,i,t)
					break
		else:
			for j in range(rows):
				if(j!=i):
					Row_Transformation(A,-A[j][i+p]/A[i][i+p],i,j)
		i=i+1
	for i in range(rows):
		for j in range(cols):
			if A[i][j]!=0:
				tmp=A[i][j]
				for k in range(j,cols):
					A[i][k]/=tmp
				break
	print(A)
	count=0
	for i in range(rows):
		if(A[i]==[0]*cols):
			count+=1
	rank=rows-count		
	return rank
A=[
	[1,-2,0,4],
	[3,1,1,0],
	[-1,-5,-1,8]
	[3,8,2,-12]
	]
print(MatrixRank(A))