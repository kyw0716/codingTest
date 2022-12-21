function solution(array, n) {
  let answer = array[0];

  array.forEach((v) => {
    if (Math.abs(n - v) < Math.abs(n - answer)) answer = v;
    if (Math.abs(n - v) === Math.abs(n - answer)) answer = Math.min(answer, v);
  });

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120890
