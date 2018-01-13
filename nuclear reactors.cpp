#include<iostream>
	using namespace std;

	int main()
	{
		int a;
		int  n,k,i,j;
		cin>> a>> n>> k;
		int c[k];
		for(i=0;i<k;i++)
		{
		cout<<(a%(n+1));
		a=a/(n+1);			
			cout<<"\n";
		}
		
		
		
		return 0;
	}
