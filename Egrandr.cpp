#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int i,n;
		cin>>n;
		int a[n];
		for(i=0;i<n;i++)
		{
			cin>>a[i];
		}
		int flag=0;
		for(i=0;i<n;i++)
		{
			if(a[i]==5)
			{
				flag++;
				break;
			}
		}
		int total=0;
		for(i=0;i<n;i++)
		{
			total=total+a[i];
		}
		if((total/n)>=4)
		{
			flag++;
		}
		for(i=0;i<n;i++)
		{
			if(a[i]==2)
			{
				flag--;
				break;
			}
		}
		if(flag==2)
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