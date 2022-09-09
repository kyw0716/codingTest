function solution(arr, divisor) {
  arr = arr.filter((value) => value % divisor === 0).sort((a, b) => a - b);
  return arr.length > 0 ? arr : [-1];
}
