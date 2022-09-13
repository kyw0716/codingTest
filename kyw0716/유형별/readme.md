# - 해시

## 위장

- key-value의 쌍이 필요한 경우에 Map 객체를 이용해서 풀어보자.
- https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=javascript

<br><br>

# - 스텍/큐

## 올바른 괄호

- LIFO에는 stack 자료구조를 사용한다.
- https://school.programmers.co.kr/learn/courses/30/lessons/12909

<br><br>

## 기능 개발

- span 계산 하는 방식 익히자.
- https://school.programmers.co.kr/learn/courses/30/lessons/42586

<br><br>

## 프린터

- 바로 풀 수 있는 문제가 아니라면 로직을 머릿속으로만 생각하지말고 주석으로 적어보고 코딩 시작하자.
- https://school.programmers.co.kr/learn/courses/30/lessons/42587

<br><br>

## 다리를 지나는 트럭

- https://school.programmers.co.kr/learn/courses/30/lessons/42583

<br><br>

# - 정렬

## 가장 큰 수

- 문제 잘 읽어보고 예외의 경우 생각해보자.
- https://school.programmers.co.kr/learn/courses/30/lessons/42746#

<br><br>

## H-index

- 정확도 실패하면 예외의 경우 잘 생각해보자.
- https://school.programmers.co.kr/learn/courses/30/lessons/42747

<br><br>

# - 완전탐색

## 소수찾기

- 순열과 조합 만드는 알고리즘, 소수 찾는 알고리즘 숙지하자.

```javascript
// 순열 만드는 함수
function getPermutation(arr, selectNumber) {
  let results = [];
  if (selectNumber === 1) return arr;

  arr.forEach((fixed, index, original) => {
    let rest = original.filter((v, i) => i !== index);
    let permutations = getPermutation(rest, selectNumber - 1);
    let attach = permutations.map((permutation) =>
      [fixed, ...permutation].join("")
    );
    results.push(...attach);
  });

  return results;
}

// 조합 만드는 함수
function getCombination(arr, selectNumber) {
  let results = [];
  if (selectNumber === 1) return arr;

  arr.forEach((fixed, index, original) => {
    let rest = original.filter((v, i) => i > index);
    let combinations = getCombination(rest, selectNumber - 1);
    let attach = combinations.map((combination) =>
      [fixed, ...combination].join("")
    );
    results.push(...attach);
  });

  return results;
}

// n까지의 수 중에서 소수를 찾아주는 함수
function prime(n) {
  let primeArray = Array(n + 1)
    .fill(true)
    .fill(false, 0, 2);
  for (let i = 2; i * i <= n; i++) {
    if (primeArray[i])
      for (let j = i * i; j <= n; j += i) {
        primeArray[j] = false;
      }
  }
  return primeArray.map((v, i) => (v ? i : 0)).filter((v) => v);
}
```

- https://school.programmers.co.kr/learn/courses/30/lessons/42839

<br><br>

### 카펫

- 규칙성 찾아서 그거에 대해 전부 탐색하도록 만들자.
- https://school.programmers.co.kr/learn/courses/30/lessons/42842

<br><br>

### 피로도

- 모든 경우의 수를 다 고려하는 방식에서 순열 떠올려보자.
- https://school.programmers.co.kr/learn/courses/30/lessons/87946#

<br><br>
