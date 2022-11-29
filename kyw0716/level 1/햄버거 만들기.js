function solution(ingredient) {
  let answer = 0;
  let stack = [];

  for (let i = 0; i < ingredient.length; i++) {
    stack.push(ingredient[i]);
    if (stack.slice(-4).join("") === "1231") {
      answer += 1;
      for (let i = 0; i < 4; i++) {
        stack.pop();
      }
    }
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/133502
