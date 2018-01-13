#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int sum=0,i=0,j=0,d=0,n;
		cin>>n;
		char s[n];
		cin>>s;
		int a[n];
		for(i=0;i<=n;i++)
		{
			cin>>a[i];
		}
		int md=0,fd=0;
		i=0;
		while(s[i]==0)
		{
			sum=a[i+1]-a[i]+sum;
			i++;
		}
		for(i=0;i<n;i++)
		{
			if(s[i]==1 && s[i+1]==1)
			{
				fd=a[i+1]-a[i]+fd;
			}
		}
		i=0;
		for(j=0;j<n;j++)
		{do
		{
			if(s[i]!=0)
			{
				d=a[i+1]-a[i];
				s[i]=1;
				sum=sum+d;
				if(d>md)
				{
					md=d;
				}
				i++;
			}
		} while(s[i+1]==0);
		sum=sum-md;
		}
		cout<<sum<<endl;
	}
	return 0;
}
