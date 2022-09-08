function solution(absolutes, signs) {
  var answer = 0;
  signs.map((isPositive, index) => {
    if (isPositive) answer += absolutes[index];
    else answer -= absolutes[index];
  });
  return answer;
}
