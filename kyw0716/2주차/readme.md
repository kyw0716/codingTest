## 1. 없는 숫자 더하기

- 일부분만 더하는 문제니까 전체에서 현재 값을 빼면 됐음... 그리고 배열 reduce 함수 잘 기억하자.

```javascript
arr.reduce((누적, 현재)=>return 누적에 현재 값으로 뭔 연산 한거, 초기값)
```

- https://school.programmers.co.kr/learn/courses/30/lessons/86051

<br/><br/>

## 2. 음양 더하기

- map, filter 이런 함수들 이용해서 최대한 반복문 피해보자.
- https://school.programmers.co.kr/learn/courses/30/lessons/76501
  <br/><br/>

## 3. 내적

- https://school.programmers.co.kr/learn/courses/30/lessons/70128
  <br/><br/>

## 4. 크레인 인형뽑기 게임

- 배열의 마지막 요소에 접근

```javascript
array.at(-1);
```

- https://school.programmers.co.kr/learn/courses/30/lessons/64061
  <br/><br/>

## 5. 소수 만들기

- 3개를 골라 부분 배열을 만드는 과정 => 조합 만들기로 해결함. 조합 만드는 알고리즘 외우고 있자.
- https://school.programmers.co.kr/learn/courses/30/lessons/12977
  <br/><br/>

## 6. 나머지가 1이 되는 숫자

- https://school.programmers.co.kr/learn/courses/30/lessons/87389
  <br/><br/>

## 7. 부족한 금액 계산하기

- https://school.programmers.co.kr/learn/courses/30/lessons/82612
- 삼항 연산자 잘 활용하기
  <br/><br/>

## 8. 3진법 뒤집기

- 숫자 진법으로 변환

```javascript
number.toString(숫자);
```

- '숫자' 진법으로 이루어진 string을 10진법 number로 바꾸어줌

```jsavascript
parseInt(string, 숫자);
```

- https://school.programmers.co.kr/learn/courses/30/lessons/68935
  <br/><br/>

## 9. 두개 뽑아서 더하기

- set쓰면 중복 제거됨, combination 알고리즘 잘 써보기
- https://school.programmers.co.kr/learn/courses/30/lessons/68644
  <br/><br/>

## 10. 실패율

- https://school.programmers.co.kr/learn/courses/30/lessons/42889
  <br/><br/>

## 11. 체육복

- 문제 잘 읽어보고 풀자... 대충 이해하고 풀었다가 시도 겁나게 했잖아 ㅠㅠ
- https://school.programmers.co.kr/learn/courses/30/lessons/42862
  <br/><br/>

## 12. 모의고사

- 일정 구간이 반복되면 그 구간의 길이로 나눈 나머지를 활용해보자.
- https://school.programmers.co.kr/learn/courses/30/lessons/42840
  <br/><br/>

## 13. K번째 수

- slice, sort, push 같은 배열 관련 메소드 잘 숙지해두자.
- https://school.programmers.co.kr/learn/courses/30/lessons/42748
  <br/><br/>

## 14. 완주하지 못한 선수

- 배열로 풀기 힘들때 해시맵도 한번 생각해보자.
- 해시맵에서 value로 key값을 찾는 방법

```javascript
Object.keys(hash).forEach((key) => {
  if (hash[key] === value) return key;
});
```

- https://school.programmers.co.kr/learn/courses/30/lessons/42576
  <br/><br/>

## 15. 다트게임

- 일단 문제가 길면 문제부터 정확히 이해하고 코드 치기 시작하자.
- 정규표현식 사용하면 조건문 엄청 줄일 수 있으니까 잘 써먹어보자.
- https://school.programmers.co.kr/learn/courses/30/lessons/17682
  <br/><br/>

## 16. 비밀지도

- 문자를 바꾸는거면 정규표현식 사용한 replace 매서드 사용해보자..
- https://school.programmers.co.kr/learn/courses/30/lessons/17681
  <br/><br/>

## 17. 예산

- https://school.programmers.co.kr/learn/courses/30/lessons/12982
  <br/><br/>

## 18. 직사각형 별찍기

- console.log는 기본적으로 줄바꿈이 되어있는 출력이라 줄바꿈을 하지 않고 싶다면 process.stdout.write함수를 사용해야 한다.
- https://school.programmers.co.kr/learn/courses/30/lessons/12969
