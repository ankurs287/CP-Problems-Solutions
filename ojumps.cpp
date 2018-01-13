#include <iostream>
using namespace std;
int main()
{
	long long int a,x,i;
	cin>>a;
	x=a%6;
	int flag=0;
	if(x==0 || x==1 || x==3)
	{
		flag=1;
	}
	if(flag==1)
	{
		cout<<"yes"<<endl;
	}
	else
	{
		cout<<"no"<<endl;
	}

	return 0;
}
