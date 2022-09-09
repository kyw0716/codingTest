function solution(s) {
  let stack = [];
  s.split("").forEach((value) => {
    if (stack.at(-1) === "(" && value === ")") {
      stack.pop();
    } else {
      stack.push(value);
    }
  });

  return stack.length > 0 ? false : true;
}

// LIFO에는 stack 자료구조를 사용한다.
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
