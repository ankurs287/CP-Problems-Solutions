#include <iostream>
#include <cstring>

using namespace std;
int main()
{
	int t,i,j,k,l;

	char a[100000];
	cin>>t;
	while(t--)
	{
		int flag=0;
		cin>>a;
		//gets(a);
		int l=strlen(a);
		for(i=0;i<l;i++)
		{
    		j=i+1; k=j+1;
    		if(a[i]==a[k] && a[i]!=a[j])
    		{
    			flag=1;
    			break;
    		}

		}
		if(flag==1)
		{
			cout<<"GOOD\n";
		}
		else if(flag==0)
		{
			cout<<"BAD\n";
		}

	}

	return 0;
}
