# Ankur Sharma 2016225
# Sahil Angral 2016082
#HW4
def swapRows(A,row1,row2):
	A[row1] , A[row2] = A[row2] , A[row1]
	return A

def Row_Transformation(A,x,row1,row2):
	for i in range(len(A[row2])):
		A[row2][i]=A[row2][i]+A[row1][i]*x
	return A

def MatrixRank(A):
	t=len(A)
	rankA=min(len(A[0]),len(A))
	i=flag=count=0
	while(i<rankA):
		if A[i][i]!=0:
			for j in range(len(A)):
				if(j!=i):
					x=-(A[j][i]/A[i][i])
					A=Row_Transformation(A,x,i,j)
			# print(A,"1")			
		elif(i<len(A)-1 and A[i][i]==0):
			for o in range(i+1,len(A)):
				if(A[o][i]!=0):
					A=swapRows(A,i,o)
					flag=1
					# print(A,"2.1")
					break
				else:
					flag=0	
			if(flag==0):
				for o in range(len(A)):
					# print(A)
					A[o][i],A[o][len(A[o])-1]=A[o][len(A[o])-1],A[o][i]
					A[o].pop(len(A[o])-1)
				# print(A,"2.2")
			i-=1
			rankA-=1
		i+=1
	# print(A,"0")
	flag=0
	for i in range(len(A)):
		for j in range(len(A[0])):
			if(A[i][j]!=0):
				flag=1
				break
			else:
				flag=0
		if(flag==1):
			count+=1
	rankA=count
	# print(A)
	return rankA

# A=[[1,0,0,1],[0,0,0,1]]
# A=[[1,2,3],[4,5,6],[7,8,9]]
# A=[[0, 1, 2], [1, 2, 1], [2, 7, 8]]
# A=[[1,0,0],[0,1,0],[0,2,0]]
# A=[[1,2,3],[0,0,0],[2,2,1]]
# print(MatrixRank(A))