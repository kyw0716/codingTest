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
  <br/><br/>

## 19. x만큼 간격이 있는 n개의 숫자

- https://school.programmers.co.kr/learn/courses/30/lessons/12954
  <br/><br/>

## 20. 행렬의 덧셈

- https://school.programmers.co.kr/learn/courses/30/lessons/12950
  <br/><br/>

## 21. 핸드폰 번호 가리기

- https://school.programmers.co.kr/learn/courses/30/lessons/12948
  <br/><br/>

## 22. 하샤드 수

- https://school.programmers.co.kr/learn/courses/30/lessons/12947
  <br/><br/>

## 23. 평균 구하기

- https://school.programmers.co.kr/learn/courses/30/lessons/12944
  <br/><br/>

## 24. 콜라츠 추측

- https://school.programmers.co.kr/learn/courses/30/lessons/12943
  <br/><br/>

## 25. 최대공약수와 최소공배수

- 유클리드 호제법 사용 -> 시간 복잡도 훨씬 줄일 수 있을 듯.
- https://school.programmers.co.kr/learn/courses/30/lessons/12940
  <br/><br/>

## 26. 짝수와 홀수

- https://school.programmers.co.kr/learn/courses/30/lessons/12937
  <br/><br/>

## 27. 제일 작은 수 제거하기

- https://school.programmers.co.kr/learn/courses/30/lessons/12935
  <br/><br/>

## 28. 정수 제곱근 판별

- https://school.programmers.co.kr/learn/courses/30/lessons/12934
  <br/><br/>

## 29. 정수 내림차순으로 배치하기

- https://school.programmers.co.kr/learn/courses/30/lessons/12933
  <br/><br/>

## 30. 자연수 뒤집어 배열로 만들기

- https://school.programmers.co.kr/learn/courses/30/lessons/12932
  <br/><br/>

## 31. 자릿수 더하기

- https://school.programmers.co.kr/learn/courses/30/lessons/12931
  <br/><br/>

## 32. 이상한 문자 만들기

- https://school.programmers.co.kr/learn/courses/30/lessons/12930
  <br/><br/>

## 33. 약수의 합

- https://school.programmers.co.kr/learn/courses/30/lessons/12928
  <br/><br/>

## 35. 시저암호

- https://school.programmers.co.kr/learn/courses/30/lessons/12926
  <br/><br/>

## 36. 문자열을 정수로 바꾸기

- 쓸데없는 조건문 안쓰도록 조심하기
- https://school.programmers.co.kr/learn/courses/30/lessons/12925
  <br/><br/>

## 37. 수박수박수박수박수박수?

- https://school.programmers.co.kr/learn/courses/30/lessons/12922
  <br/><br/>

## 38. 폰켓몬

- https://school.programmers.co.kr/learn/courses/30/lessons/1845
  <br/><br/>

## 39. 2016년

- 날짜 구하는 문제에서 Date 객체 사용하자.
- https://school.programmers.co.kr/learn/courses/30/lessons/12901
  <br/><br/>

## 40. 문자열 내마음대로 정렬하기

- 어떤 문자열의 아스키코드를 이용할 일이 있으면 charCodeAt() 함수를 이용하자.

```javascript
문자열.charCodeAt();
```

- https://school.programmers.co.kr/learn/courses/30/lessons/12915
  <br/><br/>

## 41. 문자열 다루기 기본

- 문자열엔 뭐다? 정규표현식이다~
- https://school.programmers.co.kr/learn/courses/30/lessons/12918
  <br/><br/>

## 42. 문자열 내림차순으로 배치하기

- https://school.programmers.co.kr/learn/courses/30/lessons/12917
  <br/><br/>

## 43. 가운데 글자 가져오기

- https://school.programmers.co.kr/learn/courses/30/lessons/12903
  <br/><br/>

## 44. 나누어 떨어지는 숫자 배열

- https://school.programmers.co.kr/learn/courses/30/lessons/12910
  <br/><br/>

## 45. 서울에서 김서방 찾기

- https://school.programmers.co.kr/learn/courses/30/lessons/12919
  <br/><br/>

## 46. 두 정수 사이의 합

- https://school.programmers.co.kr/learn/courses/30/lessons/12912
  <br/><br/>

## 47. 문자열 내 p와 y의 개수

- https://school.programmers.co.kr/learn/courses/30/lessons/12916
  <br/><br/>

## 48. 소수 찾기

- 일정 구간내의 소수를 찾는 문제는 에라토스테네스의 체 알고리즘 적용해보자.
- https://school.programmers.co.kr/learn/courses/30/lessons/12921
  <br/><br/>
