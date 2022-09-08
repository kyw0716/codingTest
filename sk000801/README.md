#3 신고 결과 받기
!('https://school.programmers.co.kr/learn/courses/30/lessons/92334')

개인적으로 너무 힘들었다ㅠㅠ
다른 언어들은 어떤지 모르겠지만 배열과 리스트가 엄연히 달라 생성자를 선언하는 것부터 달랐다.
물론 내가 길을 많이 돌아돌아 풀어서 좀 간결히 만드는게 좋겠지만...

#4 같은 숫자는 싫어
!('https://school.programmers.co.kr/learn/courses/30/lessons/12906')

이거 나중에 자바 정규 표현식으로 풀어보라고 했다... 
처음에는 연속이라는 단어에 집착했는데 다시 생각해서 역발상으로 연속되지 않는 index 부분의 값을 추가해주었다. 

#5 최소직사각형
!('https://school.programmers.co.kr/learn/courses/30/lessons/86491')

이건 간소화시킬 방법을 찾아야할듯.. 자바가 가진 기능을 제대로 못 활용한 느낌이다
c++ 풀이같다...
오 맞다 가장 중요한거 2차원 배열 순서 까먹지 마시길!!!!!!!
``` (java)
arr[][] = [[2,3],[4,5]]; 라면
arr[1][0] = 4임!!
```

#6 로또의 최고 순위와 최저 순위
!('https://school.programmers.co.kr/learn/courses/30/lessons/77484')
간단하게 생각하면 될 문제를 혼자 복잡하게 경우 나누고 if문 써도 될 일을 for문으로 돌려서 복잡하게 만들었다..
변수명도 zeroCount 이런 식으로 어울리게 써보면 좋을듯

#7 음양 더하기 
#8 내적
모두 for문을 돌려 인덱스를 차례차례 거쳐 구했다 근데 이게 맞나..?
stream 써서 한줄만에 푸는 방법도 생각해보자!

#9 부족한 금액 계산하기
#10 나머지가 1이 되는 수 

#11 3진법 뒤집기
이 친구는 정말 구글링으로 해결한 문제다..
```(java)
String a = Integer.toString(n,3); //주어진 10진법 수 -> 3진법 수
//얘를 string으로 받은 이유는 문자열을 뒤집을 수 있어서
// StringBuilder#reverse() 이 친구를 이용해서!!
int answer = Integer.parseInt(reversed,3); //3진법 -> 10진법 수
```

#12 크레인 인형뽑기 게임
킹받는다 코드 다 짜놨는데 2차원 배열 행열 헷갈려서 거꾸로 적어놓고 화냈다