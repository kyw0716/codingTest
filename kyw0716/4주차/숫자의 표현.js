function solution(n) {
  var answer = 0;
  let sum = 0;
  for (let i = 0; sum < n; i++) {
    sum += i;
    if ((n - sum) % (i + 1) === 0 && n - sum !== 0) answer++;
  }
  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12924
