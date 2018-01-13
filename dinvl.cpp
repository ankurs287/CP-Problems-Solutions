#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	int i,j,k,N1,N2,N3; k=0;
	cin>>N1>>N2>>N3; //no. of voters in three lists
	long L1[N1], L2[N2], L3[N3];
	for(i=0;i<N1;i++)  //first list
	{
		cin>>L1[i];
	}
	for(i=0;i<N2;i++)   //second list
	{
		cin>>L2[i];
	}
	for(i=0;i<N3;i++)  //third list
	{
		cin>>L3[i];
	}
	
	for(i=0;i<5000;i++)
	{
		cout<<L1[i]<<" ";
	}
	/*long FL[50001];
	for(i=0;i<50000;i++)    //Comparing L1 with L2
	{
		for(j=0;j<50000;j++)
		{
			if(L1[i]==L2[j])
			{
				FL[k]=L1[i];
				k++;
			}
		}
	}
	for(i=0;i<50000;i++)    //Comparing L1 with L3
	{
		for(j=0;j<50000;j++)
		{
			if(L1[i]==L3[j])
			{
				FL[k]=L1[i];
				k++;
			}
		}
	}
	for(i=0;i<50000;i++)    //Comparing L2 with L3
	{
		for(j=0;j<50000;j++)
		{
			if(L2[i]==L2[j])
			{
				FL[k]=L2[i];
				k++;
			}
		}
	}
	for(i=0;i<50000;i++) //removing duplicate elements from final list
	{
		for(j=i+1;j<50001;j++)
		{
			if(FL[i]==FL[j])
			{
				FL[j]=0;
			}
		}
	}
	sort(FL,FL+50001);
	for(i=0;i<50001;i++)
	{
		cout<<FL[i]<<" ";
	}*/
	return 0;
}