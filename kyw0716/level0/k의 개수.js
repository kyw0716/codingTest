function solution(i, j, k) {
  let answer = 0;

  for (let index = i; index <= j; index++) {
    String(index)
      .split("")
      .forEach((v) => {
        if (v === `${k}`) answer += 1;
      });
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120887
