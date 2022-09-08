function solution(arr) {
  return arr.reduce((sum, curr) => sum + curr, 0) / arr.length;
}
