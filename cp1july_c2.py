p = 1000000007
 
for t in range(int(input())):
	n = int(input())
	ans = pow(2,n-1,p) * (n*n - n + 2) - 1
	ans = ans & (p-1)
	print(ans) 