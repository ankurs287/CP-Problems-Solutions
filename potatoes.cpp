#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int x,y,i,j=0;
		int flag=0;
		cin>>x>>y;
		int n=x+y;
		while(j<=2*(x+y))
		{	flag=0;
		    n++;
			for(i=2;i<=n/2;i++)
  			{
      			if(n%i==0)
      			{
      				flag=1;
      				break;
      			}

 	 		}
      		if(flag==1)
      			continue;
      		else
      		{	cout<<n-x-y<<endl;
      			break;
      		}
        j++;
 	 	}
	}
	return 0;
}
