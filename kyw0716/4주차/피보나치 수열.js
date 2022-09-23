function solution(n) {
  let fibo = Array(n + 1).fill(0);
  fibo[1] = 1;
  for (let i = 2; i <= n; i++) {
    fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
  }
  return fibo[n];
}

// 피보나치 수열을 재귀호출로 구현하면 호출 수가 엄청 늘어날 수 있으니 구현할 때 방식을 잘 선택하자
// https://school.programmers.co.kr/learn/courses/30/lessons/12945
