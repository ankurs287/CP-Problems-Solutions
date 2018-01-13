#include <iostream>
using namespace std;
int main()
{
	int t,x,n,i;
	long speed;
	cin>>t;
	while(t>0)
	{
	cin>>n;
	long a[10001];
	for(i=0;i<n;i++)
	{
		cin>>a[i];
	}
	x=1;
	speed=a[0];
	for(i=1;i<n;i++)
	{
		if(a[i]<speed)
		{
			x=x+1;
			speed=a[i];
		}
	}
	cout<<x<<"\n";
	t--;
}
	return 0;
}
