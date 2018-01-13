#include<iostream>
using namespace std;

int main()
{ 
int i,t,j,x,skey,n, m;
cin>>t;
while(t>0)
{
x=1;
cin>>n >>m ;
int a[n];
int b[m];
for(i=0;i<n;i++)
{
a[i]=x;
x=x+1;
}
for(i=0;i<m;i++)
{
cin>>b[i];
}

for(i=0;i<n;i++)
{
  for(j=0;j<m;j++)
  {
    if(a[i]==b[j])
      {
        a[i]=0;
        }
   }
        }
        
for(j=0;j<n;j++)
{
skey=a[j];
i=j-1;
while(i>=0 && skey<a[i])
  { a[i+1]=a[i];
    i=i-1;
        }
a[i+1]=skey;
}

for(i=m;i<n;i=i+2)
{
cout<<a[i]<<" ";
}	
cout<<"\n";
for(i=(m+1);i<n;i=i+2)
{
cout<<a[i] <<" ";
}
cout<<"\n";
t--;
}
return 0;
}
