function solution(price, money, count) {
  let answer;
  let requirePrice = 0;
  for (let i = 1; i <= count; i++) {
    requirePrice += price * i;
  }
  if (money - requirePrice >= 0) answer = 0;
  else answer = Math.abs(money - requirePrice);

  return answer;
}
