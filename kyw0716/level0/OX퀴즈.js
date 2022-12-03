const calculator = (num1, num2, operator) => {
  if (operator === "-") return Number(num1) - Number(num2);
  return Number(num1) + Number(num2);
};

function solution(quiz) {
  var answer = [];
  const elements = [];

  for (let i = 0; i < quiz.length; i++) {
    elements.push(quiz[i].split(" "));
  }

  elements.forEach((element) => {
    if (calculator(element[0], element[2], element[1]) === Number(element[4]))
      answer.push("O");
    else answer.push("X");
  });

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120907
