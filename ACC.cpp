#include<iostream>
#include<cmath>
using namespace std;
int main()
{
    int t;
    scanf("%d",&t);
    int i;
    int m,n,p;
    for(p=0;p<t;p++)
    {
      cin>>n;
      m=sqrt(n);
      for(i=m;i>=1;i--)
      {
        if(n%i==0)
        {
          cout<<"\n"<<(n/i)-i;
          break;
        }
      }
    } 
    return 0;
}   