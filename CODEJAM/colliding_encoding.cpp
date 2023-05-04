#include <iostream>
using namespace std;

int main(){
    int t;
    cin >> t;

    for(int j=0; j<t; j++){
        int alph[26];
        for(int i=0; i<26; i++){
            cin >> alph[i];
        }

        int s;
        cin >> s;
        string str;
        for(int i=0; i<s; i++){
            cin >> str[i];
        }
        for(int i=0; i<s; i++){
            cout << str[i];
        }
    }
    

    return 0;
}