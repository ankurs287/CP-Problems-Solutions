t=int(input())
for i in range(0,t):
	z = input()
	n,k,m = z.split(' ')
	n=int(n)
	k=int(k)
	m=int(m)
	
	min = n//k+1
	if(n%k == 0):
		min=n//k

	count=i=0

	if(k==1):
		print(min,1)
	else:
		while(n>=i*k+min):
			a=b=c=1
			for j in range(1,min+1):
				a=a*j
			for j in range(1,i+1):
				b=b*j	
			for j in range(1,min-i+1):
				c=c*j
			x=a//(b*c)

			a=b=c=1
			u=n-i*k-1
			v=n-(i*k)-min
			for j in range(1,u+1):
				a=a*j
			for j in range(1,v+1):
				b=b*j	
			for j in range(1,u-v+1):
				c=c*j
			y=a//(b*c)
			
			if(i%2==0):
				count=count+y*x
			else:
				count=count-x*y
			i+=1
		print(min,count%m)