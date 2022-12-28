function solution(t, p) {
  let count = 0;

  for (let i = 0; i < t.length - p.length + 1; i++) {
    if (parseInt(t.slice(i, i + p.length), 10) <= parseInt(p)) count += 1;
  }

  return count;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/147355
