#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int i,n,k;
		cin>>n>>k;
		k=min(k,n-k);
		int a[n],b[k],c[n-k];
		for(i=0;i<n;i++)
		{
			cin>>a[i];
		}
		sort(a,a+n);
		for(i=0;i<k;i++)
		{
			b[i]=a[i];
		}
		int kw=0;
		for(i=0;i<k;i++)
		{
			kw=b[i]+kw;
		}
		int j=0;
		for(i=k;i<n;i++)
		{
			c[j]=a[i];
			j++;
		}
		int fw=0;
		for(i=0;i<n-k;i++)
		{
			fw=c[i]+fw;
		}
		cout<<fw-kw<<endl;
	}
	return 0;
}
