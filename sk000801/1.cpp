#include <string>
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

int solution(int left, int right) {
    int answer = 0;
    double a;
    cin >> left >> right;
    
    for(int i=left; i<=right; i++) {
            a = sqrt(i);
            if(a-floor(a)>0) {
                answer += i;
            }
            else {
                answer -= i;
            }
        }

    return answer;
}
