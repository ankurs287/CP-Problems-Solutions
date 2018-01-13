#include <iostream>
using namespace std;
int main()
{
	int t,n;
	cin>>t;
	while(t--)
	{
		cin>>n;
		if(n==1)
		{
			cout<<"ALICE\n";
		}
		else if(((n-1)%4)==0)
		{
			cout<<"ALICE\n";
		}
		else
		{
			cout<<"BOB\n";
		}
	}
        return 0;
}
