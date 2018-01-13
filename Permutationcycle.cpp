#include <iostream>
using namespace std;
int main()
{
	int n,p,e,i,temp,j;
	int c1[5000];
	cin>>n;
	int a[n];
	for(i=0;i<n;i++)
	{
		cin>>a[i];
	}
	p=1;i=0;
	do
	{
		c1[i]=p;
		p=a[p-1];
		i++;

	} while(p!=1);
	
	for(j=0;j<i;j++)
	{
		cout<<c1[j];
	}
	return 0;

}