function solution(left, right) {
  let answer = 0;

  for (let i = left; i <= right; i++) {
    if (Math.sqrt(i) % 1) {
      answer += i;
    } else answer -= i;
  }
  return answer;
}
