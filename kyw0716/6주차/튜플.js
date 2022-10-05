function solution(s) {
  let answer = [];
  s = s
    .slice(2, -2)
    .replace(/\,\{/g, "")
    .replace(/\}/g, " ")
    .split(" ")
    .map((v) => v.split(","))
    .sort((a, b) => a.length - b.length);
  answer.push(s[0]);
  for (let i = 1; i < s.length; i++) {
    answer.push(s[i].filter((v) => !s[i - 1].includes(v)));
  }
  return answer.map((v) => Number(v));
}
