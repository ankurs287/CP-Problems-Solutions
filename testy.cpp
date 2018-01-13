#include <bits/stdc++.h>
using namespace std;
#define ll long long int

ll t,n,m,k,c;

int main()
{
	cin>>t;
	while(t--)
	{

		cin>>n;
		ll *a=new ll[n+1000];
		for(int i=1;i<=n;i++)
		{
			cin>>a[i];
		}
		sort(a+1,a+n+1);
		ll sum=0;
		for(int i=2;i<=n;i++)
		{
			sum=sum+a[1]*a[i];
		}

		cout<<sum<<endl;
	}
	return 0;
}
