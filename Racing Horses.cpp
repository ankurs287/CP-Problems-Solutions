#include<iostream>
	using namespace std;

	int main()
	{
	int t,n,i,j,skey,sub,minsub,b;
 cin>> t;
 while(t--)
{
		cin>> n;
long A[n];
for(i=0;i<n;i++)
{
cin>> A[i];
}

for(j=0;j<n;j++)
{
skey=A[j];
i=j-1;
while(i>=0 && skey<A[i])
  { A[i+1]=A[i];
    i=i-1;
        }
A[i+1]=skey;
}
b=A[1]-A[0];
 
 for(i=1;i<n-1;i++)
  {
  if((A[i+1]-A[i])<b)
   {
	  b=A[i+1]-A[i];
    }
} 
 cout<<b<<"\n";   
    
}
		return 0;
	}

