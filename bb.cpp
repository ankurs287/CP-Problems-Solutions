#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	float p,s,v;
	int t;
	cin>>t;
	while(t>0)
	{
		cin>>p>>s;
		float l,b,h;
		l=((p/2) - sqrt((p*p/4)-6*s))/6;
		//cout<<l<<"\n";
		b=l;
		h=(p/4)-2*l;
		//cout<<h;
		v=l*b*h*100;
		v=round(v);
		v=v/100;
		cout<<v<<"\n";
		t--;
	}
		return 0;

}
