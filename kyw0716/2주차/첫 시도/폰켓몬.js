function solution(nums) {
  let types = new Set([...nums]).size;
  return types > nums.length / 2 ? nums.length / 2 : types;
}
