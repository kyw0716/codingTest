function solution(n) {
  let answer = n + 1;
  let countOne = n.toString(2).replace(/0/g, "").length;
  while (answer.toString(2).replace(/0/g, "").length !== countOne) {
    answer++;
  }
  return answer;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12911
