#include<bits/stdc++.h>
using namespace std;
std::string a;
std::vector<char>ans;
#define try(i,a,b) for(register int i=a;i<=b;++i)
#define throw(i,a,b) for(register int i=a;i>=b;--i)
#define debug cout<<"debug"<<endl
const int maxn = 10001;
//char a[maxn];
int main()
{
	getline(std::cin,a);
	string temp = "http";
	int pos = a.find(temp,0);
	try(i,pos,a.size()-5) cout<<a[i];
	return 0;
}
