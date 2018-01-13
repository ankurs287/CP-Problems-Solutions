#include <iostream>
using namespace std;
int main()
{
	int i,j,t;
	char J[100];
	char S[100];
	cin>> J>>S;
	int a1[52]={0};
	int a2[52]={0};
	
	for(i=0;i<100;i++)
	{
		a1[J[i]-65]++;
	}
	
	for(i=0;i<100;i++)
	{
		a2[S[i]-65]++;
	}
	
	
	int x=0;
	for(i=0;i<52;i++)
	{
		if(a2>0 && a2[i]<=a1[i])
		x++;
		
	}
	cout<<x;
	return 0;
}
