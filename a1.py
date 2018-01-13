import urllib.request
def currency_response(currency_from,currency_to,amount_from):
        url="http://cs1110.cs.cornell.edu/2015fa/a1server.php?from="+currency_from+"&to="+currency_to+"&amt="+amount_from
        wp = urllib.request.urlopen(str(url))
        pw = wp.read()
        return str(pw)

def has_error(json):
        if(json.find('"valid" : true, "error" : ""')!=-1):
                return False
        else:
                return True
def before_space(s):
        s1=s[:s.find(" ")]
        return float(s1)
def after_space(s):
        s2=s[s.find(" ")+1:]
        return s2
def exchange(currency_from, currency_to, amount_from):
        json=currency_response(currency_from,currency_to,amount_from)
        i=json.find('"rhs" : "')
        s=json[i+9:]
        j=s.find('"')
        s=s[:j]
        if(has_error(json)==False):
                return (before_space(s))
        else:
                return -1

currency_from=str(input())
currency_to=str(input())
amount_from=str(input())
exchange(currency_from,currency_to,amount_from)


