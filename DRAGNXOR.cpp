#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,a,b,k=1,i,j=0,count=0,p,r;
		cin>>n>>a>>b;
		int mx=max(a,b);
		int mn=min(a,b);
		a=mx; b=mn;
		/*while(true)
		{
			k=2*k;
			count++;
			if(l<k)
			{
				break;
			}
		}
		cout<<count<<endl;*/
		int b1[n],b2[n];
		for(i=0;i<n;i++)
		{
			b2[i]=0;
			b1[i]=0;
		}
		j=0;
		while(a!=0)
		{
  			r = a%2;
  			b1[j] = r;
 	 		a=a/2;
 	 		j++;
		}
		j=0;
		while(b!=0)
		{
  			r =b%2;
  			b2[j] = r;
 	 		b=b/2;
 	 		j++;
		}
		sort(b1,b1+n,greater<int>());
		sort(b2,b2+n,greater<int>());
		/*for(i=0;i<n;i++)
		{
			cout<<b1[i]<<" "<<b2[i]<<endl;
		}*/
		for(i=0;i<n;i++)
		{
			if(b1[i]==0)
			{
				p=i;
				break;
			}
		}
		int base=1;a=0,b=0;
		for(i=n-1;i>=0;i--)
		{
			a=a+b1[i]*base;
			b=b+b2[i]*base;
			base=base*2;
		}
    	b=b>>p;
    	//cout<<a<<" "<<b;
    	a=a^b;
    	cout<<a<<endl;
	}
	return 0;
}
