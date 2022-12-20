function solution(numlist, n) {
  numlist.sort((a, b) => {
    const A = Math.abs(n - a);
    const B = Math.abs(n - b);
    return A > B ? 1 : A === B ? b - a : -1;
  });
  return numlist;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/120880
