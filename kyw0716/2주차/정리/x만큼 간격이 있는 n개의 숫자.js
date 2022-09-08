function solution(x, n) {
  var answer = [x];
  for (let i = 1; i < n; i++) {
    answer[i] = answer[i - 1] + x;
  }
  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12954
