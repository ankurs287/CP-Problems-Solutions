#include <iostream>
#include <cstring>
#include <math.h>
using namespace std;
int main()
{
	int i,x1,x2,x3,y1,y2,y3,j,n,x=0;
	cin>>n;

	while(n--)
	{
		cin>>x1>>y1>>x2>>y2>>x3>>y3;
		float a=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
		float b=(x3-x1)*(x3-x1)+(y3-y1)*(y3-y1);
 		float c=(x2-x3)*(x2-x3)+(y2-y3)*(y2-y3);
 		//cout<<a*a<<" "<<b*b<<" "<<c*c;
        if(a==(b+c) || b==(a+c) || c==(a+b))
 		{
 			x++;
 			//cout<<x<<" ";
 		}
	}
    cout<<x;
	return 0;
}
