//Chef and calculation
#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,i,j,q1,min=0,nz=6;
		cin>>n;
		int a[n][7],p[n];
		for(i=0;i<n;i++) //putting all values in array zero
		{
			p[i]=0;
			for(j=0;j<7;j++)
			{
				a[i][j]=0;
			}
		}
		for(i=0;i<n;i++) //input
		{
			cin>>a[i][0];
			p[i]=a[i][0];
			for(j=1;j<=a[i][0];j++)
			{
				cin>>q1;
				if(q1==1)
					a[i][1]++;
				else if(q1==2)
					a[i][2]++;
				else if(q1==3)
					a[i][3]++;
				else if(q1==4)
					a[i][4]++;
				else if(q1==5)
					a[i][5]++;
				else if(q1==6)
					a[i][6]++;
			}
		}
		for(i=0;i<n;i++)
			sort(a[i]+1,a[i]+7);
		/*for(i=0;i<n;i++) //test1
		{
			for(j=0;j<7;j++)
			{
				cout<<a[i][j]<<" ";
			}
			cout<<endl;
		}*/
		for(i=0;i<n;i++)
		{
			nz=6;
			for(j=0;j<100;j++)
			{
				if(a[i][1]==0)
					nz--;
				if(a[i][2]==0)
					nz--;
				if(a[i][3]==0)
					nz--;
				if(a[i][4]==0)
					nz--;
				if(a[i][5]==0)
					nz--;
				if(a[i][6]==0)
					nz--; 
				min=a[i][6-nz+1];
				if(nz==0)
				{
					break;
				}
				if(nz==6)
				{
					p[i]=p[i]+min*4;
					if(a[i][1]!=0)
						a[i][1]=a[i][1]-min;
					if(a[i][2]!=0)
						a[i][2]=a[i][2]-min;
					if(a[i][3]!=0)
						a[i][3]=a[i][3]-min;
					if(a[i][4]!=0)
						a[i][4]=a[i][4]-min;
					if(a[i][5]!=0)
						a[i][5]=a[i][5]-min;
					if(a[i][6]!=0)
						a[i][6]=a[i][6]-min;
				}
				else if(nz==5)
				{
					p[i]=p[i]+min*2;
					if(a[i][1]!=0)
						a[i][1]=a[i][1]-min;
					if(a[i][2]!=0)
						a[i][2]=a[i][2]-min;
					if(a[i][3]!=0)
						a[i][3]=a[i][3]-min;
					if(a[i][4]!=0)
						a[i][4]=a[i][4]-min;
					if(a[i][5]!=0)
						a[i][5]=a[i][5]-min;
					if(a[i][6]!=0)
						a[i][6]=a[i][6]-min;
				}
				else if(nz==4)
				{
					p[i]=p[i]+min*1;
					if(a[i][1]!=0)
						a[i][1]=a[i][1]-min;
					if(a[i][2]!=0)
						a[i][2]=a[i][2]-min;
					if(a[i][3]!=0)
						a[i][3]=a[i][3]-min;
					if(a[i][4]!=0)
						a[i][4]=a[i][4]-min;
					if(a[i][5]!=0)
						a[i][5]=a[i][5]-min;
					if(a[i][6]!=0)
						a[i][6]=a[i][6]-min;
				}
				else if(nz<4)
					break;
			}
		}
		/*for(i=0;i<n;i++) //test 2
		{
			cout<<p[i]<<" ";
		}*/
		int win=0, max=p[0];
		for(i=1;i<n;i++) //check max points
		{
			if(max<p[i])
			{	
				win=i;
				max=p[i];
			}
		}
		sort(p,p+n);
		if(p[n-1]==p[n-2] && n>1)
			cout<<"tie"<<endl;
		else if(win==0)
			cout<<"chef"<<endl;
		else
			cout<<win+1<<endl;
	}
	return 0;
}