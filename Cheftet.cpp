#include <algorithm>
#include <iostream>
using namespace std;
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        int j,i,b[n],a[n];
        for(i=0;i<n;i++)
        {
            cin>>b[i];
        }
        for(i=0;i<n;i++)
        {
            cin>>a[i];
        }
        int index=0;
        if(n==1)
        {
            cout<<a[0]+b[0]<<endl;
        }
        else
        {
            for(j=0;j<n;j++)
            {
                for (i=1;i<n;i++)
                {
                    if(a[i]<a[index])
                    {
                        index=i;
                    }
                }
                if(index==n-1)           //if index is at end point
                {
                    if(b[n-1]>=b[n-2])
                    {
                        a[index]=a[index]+b[n-1];
                        b[n-1]=0;
                    }
                    else if(b[n-1]<b[n-2])
                    {
                        a[index]=a[index]+b[n-2];
                        b[n-2]=0;
                    }
                    index=0;
                }
                else if(index==0)  //if index is first element
                {
                    if(b[0]>=b[1])
                    {
                        a[index]=a[index]+b[0];
                        b[0]=0;
                    }
                    else if(b[0]<b[1])
                    {
                        a[index]=a[index]+b[1];
                        b[1]=0;
                    }
                    index=0;
                }
                else   //other positions
                {
                    if(b[index]>=b[index-1] && b[index]>=b[index+1])
                    {
                        a[index]=a[index]+b[index];
                        b[index]=0;
                    }
                    else if(b[index-1]>=b[index+1])
                    {
                        a[index]=a[index]+b[index-1];
                        b[index-1]=0;
                    }
                    else if(b[index+1]>b[index-1])
                    {
                        a[index]=a[index]+b[index+1];
                        b[index+1]=0;
                    }
                    index=0;
                }
                index=0;
            }
            int flag=0;
            for(i=0;i<n-1;i++)
            {
                if(a[i]==a[i+1])
                {
                    flag++;
                }               
            }
            for(i=0;i<n;i++)
            {
                if(b[i]!=0)
                {
                    flag=0;
                    break;
                }
            }
            if(flag==n-1)
            {
                cout<<a[0]<<endl;
                continue;
            }
            else
               cout<<"-1"<<endl;
        }
 
    }
    return 0;
}