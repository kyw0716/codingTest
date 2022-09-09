function solution(nums) {
  let types = new Set([...nums]).size;
  return types > nums.length / 2 ? nums.length / 2 : types;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/1845
