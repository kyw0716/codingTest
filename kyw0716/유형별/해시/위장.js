function solution(clothes) {
  let hashMap = new Map();
  let mul = 1;
  clothes.forEach((value) => {
    if (hashMap.has(value[1])) {
      hashMap.set(value[1], [...hashMap.get(value[1]), value[0]]);
    } else hashMap.set(value[1], [value[0]]);
  });
  hashMap.forEach((value, key) => {
    mul *= value.length + 1;
  });
  return mul - 1;
}

// key-value의 쌍이 필요한 경우에 Map 객체를 이용해서 풀어보자.
// https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=javascript
