function solution(A, B) {
  let count = 0;

  while (A !== B) {
    const arr = A.split("");
    arr.unshift(arr.pop());
    A = arr.join("");
    count += 1;
    if (count > A.length) return -1;
  }

  return count;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120921
