function gcd(a, b) {
  if (a % b == 0) return b;
  return gcd(b, a % b);
}
function solution(n, m) {
  let answer = [];
  answer.push(gcd(n, m));
  for (let i = 1; i <= n * m; i++) {
    if (i % n === 0 && i % m === 0) {
      answer.push(i);
      break;
    }
  }
  return answer;
}

// 유클리드 호제법 사용 -> 시간 복잡도 훨씬 줄일 수 있을 듯.
// https://school.programmers.co.kr/learn/courses/30/lessons/12940
