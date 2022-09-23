function solution(s) {
  let Stack = [];
  for (let i = 0; i < s.length; i++) {
    if (Stack.at(-1) === s[i]) Stack.pop();
    else Stack.push(s[i]);
  }
  return Stack.length > 0 ? 0 : 1;
}

// 자료구조 생각도 좀 해보자...
// https://school.programmers.co.kr/learn/courses/30/lessons/12973
