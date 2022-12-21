function solution(order) {
  const clap = ["3", "6", "9"];
  let answer = 0;

  String(order)
    .split("")
    .forEach((v) => {
      if (clap.includes(v)) answer += 1;
    });

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120891
