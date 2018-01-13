#include <bits/stdc++.h>
 
using namespace std;
 
#define ll long long
#define pint pair<int, int>
#define pll pair<ll, ll>
#define mk(a, b) make_pair(a, b)
#define pr(n) printf("%d\n", n)
#define sc(n) scanf ("%d", &n)
#define scll(n) scanf ("%lld", &n)
#define prll(n) printf("%lld\n", n)
#define MOD 1000000007ll
 
ll power (ll a, ll b) {
    if (b == 1) {
        return a;
    }
    if(b == 0) {
        return 1;
    }
    ll x = power(a, b/2);
    if (b % 2 == 0) {
        return (x%MOD * x%MOD)%MOD;
    
    }else{
        return ((((x%MOD)*(x%MOD))%MOD)*a)%MOD;
    }
}
 
int main (void) {
    int test;
    cin>>test;
    ll n;
    ll ans;
    while (test--) {
        scll(n);
        ans = (power(2ll, n-1)%MOD * ((n%MOD * (n-1)%MOD)%MOD +2ll)%MOD)%MOD - 1ll;
        if(ans < 0)
        ans = ans + MOD;
        ans = ans % MOD;
        prll(ans);
    }
 
	return 0;
} 