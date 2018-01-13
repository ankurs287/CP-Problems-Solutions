def offByK(s1,s2,k) :
    count=0
    if len(s1)==len(s2):
        
        
        for i in range(len(s1)) :
            if s1[i]!=s2[i] :
                count = count + 1
            else :
                continue
        if count == k:
            return True
        else :
            return False

    else :
        return False


            
        
def offBySwaps(s1,s2) :
    if len(s1)==len(s2) :
        for c in s1 :
            if s1.count(c)==s2.count(c) :
                continue

            else :
                return False
        return True 
    else:
        return False

    
def offByKExtra(s1,s2,k) :
    if len(s1)>len(s2) :
        str1=s1
        str2=s2
    
    else:
        str1=s2
        str2=s1

    
    s=""
    i=0
    j=0
    while i < len(str1) and j < len(str2):             
        if str1[i]==str2[j] :
            s=s+str1[i]
            i+=1
            j+=1

        else:
            i+=1
    
    
    if len(str1)-len(s)==k and s==str2 :
        return True
    else:
        return False

def ListOfNearStrings(s,L,k) :
    List=[]
    for c in L :
        if offByK(s,c,k) or offBySwaps(s,c) or offByKExtra(s,c,k) :
            List.append(c)
            
        else:
            continue
    List.sort()
    return List


def compare_distr(L1,L2,bi) :
    M=max(L1)
    m=min(L1)
    n=bi
    
    s2=[]
    L=[]
    i=0
    while m+n*i<M :
        i=i+1
        l=i

    if m+n*l==M :
        l=l+1
        
    s1=[]
    s1=[]*(l+1)
    for i in range(l):
        s1.append([])
        for j in range(len(L1)) :
            if m+n*i<=L1[j]<m+n*(i+1) :
                s1[i].append(L1[j])
    

    
    for i in range(len(s1)) :
        
        c=len(s1[i])
        s2.append(c)
    

    M=max(L2)
    m=min(L2)
    n=bi
    
    s3=[]
    L=[]
    i=0
    while m+n*i<M :
        i=i+1
        l=i

    if m+n*l==M :
        l=l+1
        
    s1=[]
    s1=[]*(l+1)
    for i in range(l):
        s1.append([])
        for j in range(len(L2)) :
            if m+n*i<=L2[j]<m+n*(i+1) :
                s1[i].append(L1[j])
    

    
    for i in range(len(s1)) :
        
        c=len(s1[i])
        s3.append(c)

    if s2==s3:
        return True
    else:
        return False






    
