#include <iostream>
#include <cstring>
#include <string.h>
using namespace std;
 
int main()
{
    int i, t;
    cin>>t;
    int a1[26];
    int a2[26];
    while(t--)
    {
    	char x[1001];
	cin>>x;
	char x1[600];
	char x2[600];
    	int l=strlen(x);
    	if(l==1)
    	{ 
    	cout<<"YES\n";
    	continue;
		}
    	
    for(i=0;i<26;i++)
    {
        a1[i]=0;
        a2[i]=0;
    }
	
	
	int hl=l/2;int j;
    if((l%2)==0)
    {
	for(i=0;i<hl;i++)
        {
            x1[i]=x[i];
        }
        x1[i]='\0';
        j=0;
        while(j<hl)
        {
        x2[j]=x[i];
        i++;
        j++;
        }
        x2[j]='\0';
    }
 
 
  else {
        for(i=0;i<hl;i++)
        {
            x1[i]=x[i];
        }
        x1[i]='\0';
        j=0;
        while(j<hl)
        {
        x2[j]=x[i+1];
        i++;
        j++;
        }
        x2[j]='\0';
 
    }
 
//cout<<x1<<"\n"<<x2<<"\n";
  int flag=0;
 
    for(i=0;i<l/2;i++)
    {
       a1[x1[i]-97]++;
	}
	for(i=0;i<l/2;i++)
    {
       a2[x2[i]-97]++;
	}
	
 
	for(i=0;i<26;i++)
    {
       if(a1[i]!=a2[i])
       {    cout<<"NO\n";
            flag=1;
            break;
       }
	}
	if(flag==0)
       cout<<"YES\n";
 
    
    }
 
    return 0;
}
 

