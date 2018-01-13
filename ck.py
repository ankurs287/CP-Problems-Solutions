def compare_distr(L1,L2,bin):
	L1.sort()
	L2.sort()
	i,j,f1,k=0,L1[0],[0],0
	while(i<len(L1)):
		if j<=L1[i]<j+bin:
			f1[k]+=1
			i=i+1
		else:
			j=j+bin
			f1.append(0)
			k+=1
	i,j,f2,k=0,L2[0],[0],0
	while(i<len(L2)):
		if j<=L2[i]<j+bin:
			f2[k]+=1
			i=i+1
		else:
			j=j+bin
			f2.append(0)
			k+=1
	return f1,f2

print(compare_distr([1,2,4,1,3,1,4,6,9],[23,21,24,26,24,21,30,22,22],2))