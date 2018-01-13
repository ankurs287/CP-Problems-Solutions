//Chef and digits of number
#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		string a;
		cin>>a;
		int i,n1=0,n0=0,len= a.length();
		for(i=0;i<len;i++)
		{
			if(a[i]=='1')
				n1++;
		}
		for(i=0;i<len;i++)
		{
			if(a[i]=='0')
				n0++;
		}
		if(n1==len-1 || n0==len-1)
		{
			cout<<"Yes"<<endl;
		}
		else
		{
			cout<<"No"<<endl;
		}
	}
	return 0;
}
