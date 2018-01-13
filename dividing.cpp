#include <iostream>
using namespace std;
int main()
{
	int n,i,x=0,y=0;
	cin>>n;
	int a[n];
	for(i=0;i<n;i++)
	{
		cin>>a[i];
	}
	for(i=1;i<=n;i++)
	{
		x=x+i;
	}
	for(i=0;i<n;i++)
	{
		y=y+a[i];
	}
	if(x==y)
	{
		cout<<"YES";
	}
	else
	{
		cout<<"NO";
	}
	return 0;
}