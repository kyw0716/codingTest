function solution(topping) {
  const young = {};
  const old = new Set([]);
  let answer = 0;
  let youngSize = 0;

  for (let i = 0; i < topping.length; i++) {
    if (young[topping[i]] !== undefined) {
      young[topping[i]]++;
      continue;
    }
    young[topping[i]] = 1;
  }

  youngSize = Object.keys(young).length;

  for (let i = 0; i < topping.length; i++) {
    if (old.size === youngSize) answer++;

    old.add(topping[i]);
    young[topping[i]]--;

    if (young[topping[i]] === 0) {
      youngSize--;
    }
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/132265
