#include<iostream>
#include<algorithm>
using namespace std;
int main()
{
	int i,skey,j,t,n,k,x;
	
	cin>>t;
	while(t--)
	{
	cin>>n;
	int a[n];
	for(i=0;i<n;i++)
	{
		cin>>a[i];
	}
	cin>>k;
	x=a[k-1];
	sort(a,a+n);
	for(i=0;i<n;i++)
	{
		if(a[i]==x)
		{
			cout<<(i+1)<<"\n";
		}
	}
	
    }
	return 0;
}
