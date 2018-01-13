#include <iostream>
#include <cmath>
using namespace std;
int binary[1048576][20];
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,m,i,j=0,flag=0;
		cin>>n>>m;
		int a[n];
		for(i=0;i<n;i++)
		{
			cin>>a[i];
		}
		int x=pow(2,n);
 		//int binary[x][n];
 		int r;
 		for(i=0;i<x;i++)
		{
			for(j=0;j<n;j++)
			{
				binary[i][j]=0;
			}
		}
		int num;
 		for(i=1;i<x;i++)
 		{
 			num=i,j=0;
 			while(num!=0 )
			{
  				r = num%2;
  				binary[i][j] = r;
 		 		num=num/2;
 		 		j++;
			}
		}
		int sum=0;
		for(i=0;i<x;i++)
		{
			for(j=0;j<n;j++)
			{
				//cout<<binary[i][j]<<" ";
				if(binary[i][j]==1)
				{
					sum=sum+a[j];
				}
			}
			if(sum==m)
			{
				flag=1;
				break;
			}
			sum=0;
		}
		if(flag==1)
		{
			cout<<"Yes\n";
		}
		else
		{
			cout<<"No\n";
		}
	}
	return 0;
}