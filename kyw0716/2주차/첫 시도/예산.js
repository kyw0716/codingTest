function solution(d, budget) {
  var answer = 0;
  d.sort((a, b) => a - b);
  d.forEach((value) => {
    budget -= value;
    if (budget >= 0) answer += 1;
  });
  return answer;
}
