#include <iostream>
using namespace std;
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,m,k,x;
        cin>>n>>m>>k;
        x=-1;
        if((m-k)%2==0 && x>=0)
        {
            x=(n-(m-k))/(m-k);
            cout<<x+1<<endl;
        }
        else if((m-k)%2!=0 && x>=0)
        {
            x=(n-1)/(m-k);
            cout<<x<<endl;
        }
        else
         cout<<"-1\n";
    }
        return 0;
}