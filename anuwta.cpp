#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		long long int n;
		cin>>n;
		n=(((n*n)+n)/2)+n;
		cout<<n<<endl;
	}
	return 0;
}
