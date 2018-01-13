#include<iostream>
using namespace std;

int main()
{

int t,G,n,I,N,Q,H,T;
cin>>t;
while(t>0)
{
	cin>>G;
while(G>0)
{
cin>>I>>N>>Q;

n=N%2;
if(n==0) 
{
   
	H=N/2;
	T=N/2;
   
}

else if(n!=0)
{
  if(I==1)
  { 
	H=N/2;
	T=(N/2)+1;
  }   
   
   else if(I==2)
   {
   	T=N/2;
	H=(N/2)+1;
   }
}
if(Q==1)
{
cout<<H;

}
else
{
	cout<<T;
}
cout<<"\n";
G--;
}
t--;
}
return 0;
}
