function solution(a, b) {
  return Array(Math.abs(a - b) + 1)
    .fill()
    .map((value, index) => index + Math.min(a, b))
    .reduce((sum, curr) => sum + curr, 0);
}
