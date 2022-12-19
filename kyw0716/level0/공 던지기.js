function solution(numbers, k) {
  let index = 0;
  let preIndex = index;

  while (k > 0) {
    preIndex = index;
    index += 2;
    index = index % numbers.length;
    k -= 1;
  }

  return numbers[preIndex];
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120843
