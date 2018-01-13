#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,m,c,x=1,y=1,count=0;
		cin>>n>>m>>c;
		while(x<=n)
		{
			float(y)=float(c)/float(x);
			// cout<<y<<" ";
			if(y>m)
			{
				x++;
				continue;
			}
			if(x*y==c)
			{
				// cout<<x;
				count++;
			}
			x++;
		}
		cout<<count;
	}
}