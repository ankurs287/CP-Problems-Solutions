#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,p,i,sum=0;
		cin>>n;
		for(i=0;i<n;i++)
		{
			cin>>p;
			sum=sum+(p/3);
		}
		cout<<sum<<endl;
	}
	return 0;
}