#include <iostream>
using namespace std;
int main()
{
	int i,j,n,ip,lp,p,count=0;
	cin>>n;
	int a[n],b[n];
	for(i=0;i<n;i++)
	{
		cin>>a[i];
		b[i]=a[i];
	}
	for(i=0;i<n;i++)
	{
		p=i;
		if(b[p]!=0)
		{
			count++;
			ip=p;
			//cout<<p+1<<" ";
			for(j=0;j<n;j++)
			{
				//cout<<a[p]<<" ";
				lp=p;
				p=b[p]-1;
				b[lp]=0;
				if(p==lp)
				{
					//cout<<"\n";
					break;
				}
				if(b[p]==ip+1 && b[p]!=0)
				{
					//cout<<ip+1<<" \n";
					b[p]=0;
					break;
				}
			}
		}
	}
	cout<<count<<"\n";
	for(i=0;i<n;i++)
	{
		p=i;
		if(a[p]!=0)
		{
			//count++;
			ip=p;
			cout<<p+1<<" ";
			for(j=0;j<n;j++)
			{
				cout<<a[p]<<" ";
				lp=p;
				p=a[p]-1;
				a[lp]=0;
				if(p==lp)
				{
					cout<<"\n";
					break;
				}
				if(a[p]==ip+1 && a[p]!=0)
				{
					cout<<ip+1<<" \n";
					a[p]=0;
					break;
				}
			}
		}
	}
	return 0;
}
