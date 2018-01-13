#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,m;
		cin>>n>>m;
		int temp=(n*m)-1;
		if(temp%2==0)
		{
			cout<<"No\n";
		}
		else
		{
			cout<<"Yes\n";
		}
	}
	return 0;
}