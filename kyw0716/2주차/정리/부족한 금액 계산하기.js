function solution(price, money, count) {
  let answer = 0;
  for (let i = 1; i <= count; i++) {
    answer += price * i;
  }

  return answer - money < 0 ? 0 : answer - money;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/82612
// 삼항 연산자 잘 활용하기
