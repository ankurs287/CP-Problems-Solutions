#Ankur Sharma 2016225
#Sahil Angral 2016082
def offByK(s1,s2,k):
	if(len(s1)!=len(s2)):
		return False
	count , j = 0 , 0
	for i in s1:
		if(i!=s2[j]):
			count+=1
		j+=1
	if(count==k):
		return True
	else:
		return False

def offBySwaps(s1,s2):
	if(len(s1)!=len(s2)):
		return False
	for i in s1:
		if(s1.count(i)!=s2.count(i)):
			return False
	return True

def offByKExtra(s1,s2,k):
	count,j,i=0,0,0
	if(s1==s2 and k!=0):
		return False
	elif(s1==s2 and k==0):
		return True
	if(len(s1)==len(s2) and k!=0):
		return False
	if(len(s1)>len(s2)):
		t=s1
		s1=s2
		s2=t
	t=s2
	for i in s1:
		if(t.find(i)!=-1):
			t=t[t.find(i)+1:]		
		else:
			return False
	count=len(s2)-len(s1)
	if(count==k):
		return True	
	else:
		return False

def ListOfNearStrings(s,L,k):
	t=[]
	for i in L:
		if(offByK(s,i,k)==True or offBySwaps(s,i)==True or offByKExtra(s,i,k)==True):
			t.append(i)
	t.sort()
	return t

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
	if(f1==f2):                      
		return True
	else:
		return False




# def rubbish(L1,L2,bin):
# 	k=(max(L1)-min(L1))//bin + 1
# 	fc1=[0]*k
# 	for i in L1:
# 		mini=min(L1)
# 		for j in range(k):
# 			if i>=mini and i<mini+bin:
# 				fc1[j]+=1
# 				break
# 			mini=mini+bin
# 	k=(max(L2)-min(L2))//bin + 1
# 	fc2=[0]*k
# 	for i in L2:
# 		mini=min(L2)
# 		for j in range(k):
# 			if i>=mini and i<mini+bin:
# 				fc2[j]+=1
# 			mini=mini+bin
# 	# print(fc1,fc2)
# 	if(fc1==fc2):
# 		return True
# 	else:
# 		return False