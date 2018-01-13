#include <iostream>
#include <algorithm>
using namespace std;
typedef long long int l;
l a[100000];
 
l gcd(l a,l b)
    
    {
    if(b == 0)
       return a; 
    else
       return gcd(b, a% b);
    }
int main() {
	
	l t,n;
	cin>>t;
	{
		while(t--)
		{
			cin>>n;
			for(int i=0;i<n;i++)
			{
				cin>>a[i];
				
			}
			sort(a,a+n);
			l ans=a[0];
			for(int i=0;i<n;i++)
			{
				 ans=gcd(ans,a[i]);
			}
			cout<<ans<<"\n";
		}
		
	}
 
	return 0;
} 