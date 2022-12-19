function solution(numbers, direction) {
  if (direction === "left") {
    numbers.push(numbers.shift());
    return numbers;
  }
  numbers.unshift(numbers.pop());
  return numbers;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120844
