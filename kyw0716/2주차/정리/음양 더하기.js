function solution(absolutes, signs) {
  var answer = 0;
  signs.map((isPositive, index) => {
    if (isPositive) answer += absolutes[index];
    else answer -= absolutes[index];
  });
  return answer;
}

// map, filter 이런 함수들 이용해서 최대한 반복문 피해보자
// https://school.programmers.co.kr/learn/courses/30/lessons/76501
