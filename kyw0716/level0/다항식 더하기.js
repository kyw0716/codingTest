function calcValue(regExp, v) {
  const value = v.replace(regExp, "");

  if (value === "") return 1;
  return parseInt(value, 10);
}

function getArraySum(array) {
  return array.reduce((arr, curr) => (arr += curr), 0);
}

function solution(polynomial) {
  const answer = [];
  const arr = polynomial.split(" + ");
  const single = arr
    .filter((v) => v.match(/x/) !== null)
    .map((v) => calcValue(/x/, v));
  const constant = arr
    .filter((v) => v.match(/x/) === null)
    .map((v) => parseInt(v, 10));

  if (getArraySum(single) !== 0 && getArraySum(single) !== 1)
    answer.push(`${getArraySum(single)}x`);
  if (getArraySum(single) === 1) answer.push(`x`);
  if (getArraySum(constant) !== 0) answer.push(`${getArraySum(constant)}`);

  return answer.join(" + ");
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120863#
