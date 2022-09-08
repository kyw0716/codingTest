function solution(n) {
  let answer = 0;
  let threeNotation = [];
  while (1) {
    if (n < 1) break;
    threeNotation.push(n % 3);
    n = parseInt(n / 3);
  }
  threeNotation.reverse().forEach((value, index) => {
    answer += value * 3 ** index;
  });
  return answer;
}
