function solution(numbers) {
  return 45 - numbers.reduce((sum, currentValue) => sum + currentValue, 0);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/86051
// 일부분만 더하는 문제니까 전체에서 현재 값을 빼면 됐음... 그리고 배열 reduce 함수 잘 기억하자.
// arr.reduce((누적, 현재)=>return 누적에 현재 값으로 뭔 연산 한거, 초기값) 요런식으로 사용하는 함수임.
