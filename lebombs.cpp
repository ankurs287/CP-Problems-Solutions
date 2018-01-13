#include <iostream>
#include <cstring>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while (t--)
	{
		int n,i; int x=0;
		cin>>n;
		string s;
		cin>>s;
		for(i=1;i<n-1;i++)
		{
			if(s[i]=='1')
			{
				s[i-1]='2';
				s[i]='2';
				if(s[i+1]!='1')
				{
					s[i+1]='2';
				}
			}
		}
		if(n>2)
		{
			if(s[0]=='1')
				{
					s[0]='2';
					s[1]='2';
				}
			if(s[n-1]=='1')
				{	
					s[n-1]='2';
					s[n-2]='2';
				}
		}
		if(n<=2 && (s[0]=='1' || s[n-1]=='1'))
		{
			s[0]='2';
			s[n-1]='2';
		}
		for(i=0;i<n;i++)
		{
			if(s[i]=='2')
			{
				x++;
			}
		}
		cout<<n-x<<endl;
	}
	return 0;
}
