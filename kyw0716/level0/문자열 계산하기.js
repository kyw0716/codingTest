function solution(my_string) {
  const number = [];
  const operator = [];

  my_string.split(" ").forEach((v) => {
    if (v === "+" || v === "-") operator.push(v);
    else number.push(parseInt(v, 10));
  });

  let result = number.shift();

  while (number.length > 0) {
    const o = operator.shift();
    const n = number.shift();

    if (o === "+") result += n;
    else result -= n;
  }

  return result;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120902
