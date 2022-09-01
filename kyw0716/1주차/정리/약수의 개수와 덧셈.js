function solution(left, right) {
  let answer = 0;

  for (let i = left; i <= right; i++) {
    if (Math.sqrt(i) % 1) {
      answer += i;
    } else answer -= i;
  }
  return answer;
}

//제곱수는 약수의 개수가 홀수다.
// https://school.programmers.co.kr/learn/courses/30/lessons/77884
