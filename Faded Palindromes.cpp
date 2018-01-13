//Faded Palindromes
#include <iostream>
#include <cstring>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		cin>>s;
		int i,len= s.length(),flag=0;
		if(len%2==1 && s[len/2]=='.')
		{
			s[len/2]='a';
		}
		for(i=0;i<len/2;i++)
		{
			if(s[i]=='.' && s[len-1-i]=='.')
			{
				s[i]='a';
				s[len-1-i]='a';
				flag=1;
				//cout<<"1";
				continue;
			}
			else if(s[i]=='.')
			{
				s[i]=s[len-1-i];
				flag=1;
				//cout<<"2";
				continue;
			}
			else if(s[len-1-i]=='.')
			{
				s[len-1-i]=s[i];
				flag=1;
				//cout<<"3";
				continue;
			}
			else if(s[i]==s[len-1-i])
			{
				s[i]=s[len-1-i];
				flag=1;
				//cout<<"4";
				continue;
			}
			else
				flag=0;
				//cout<<"3";
				break;
		}
		if(flag==0)
			{
				cout<<"-1"<<endl;
			}
			else
			{
				cout<<s<<endl;
			}
		}
	return 0;
}
