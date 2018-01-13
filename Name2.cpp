#include <iostream>
#include <cstring>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		string M,W,str,str1;
		cin>>M>>W;
		int i,j,x=0,maxlen;
		int l1=M.length();
		int l2=W.length();
		if(l1>l2)
        {
 			str=W;
            str1=M;
         	maxlen=l1;
        }
        else
        {
          	str=M;
            str1=W;
           	maxlen=l2;
        }
		for(i=0;i<maxlen;i++)
		{
			if(str[x]==str1[i])
			{
				x++;
			}

		}
		if(x==str.length())
		{
			cout<<"YES\n";
		}
		else
		{
			cout<<"NO\n";
		}
	}
	return 0;
}
