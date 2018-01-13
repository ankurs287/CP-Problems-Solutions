// https://www.codechef.com/problems/TWTCLOSE
#include <iostream>
#include <cstring>
using namespace std;
int main()
{
	int n,k,count=0,i;
	cin>>n>>k;
	char c[n],t;
	memset(c, 0, n);
	char a[10];
	while(k--)
	{
		count=0;
		cin>>a;
		if(a[5]=='A' || a[5]=='a')
		{
			memset(c, 0, n);
			cout<<"0\n";
		}
		else
		{
			t=a[5]-48;
			if(c[t-1]==0)
			{
				c[t-1]=1;	
			}
			else
			{
				c[t-1]=0;
			}
			for(i=0;i<n;i++)
			{
				if(c[i]==1)
				{
					count++;
				}
			}
			cout<<count<<"\n";
		}
	}
	return 0;
}
 