function solution(arr) {
  return arr.filter((value, index) => value !== arr[index + 1]);
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12906
