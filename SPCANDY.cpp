#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
    {
        long long n,k;
        cin>>n>>k;
        if(k==0&&n==0)
        cout<<"0 0\n";
        else if(k==0&&n!=0)
        cout<<"0 "<<n<<endl;
        else if(k!=0&&n!=0)
        cout<<n/k<<" "<<n%k<<endl;
        else if(k!=0&&n==0)
        cout<<"0 0\n";;
    }
    return 0;
}
