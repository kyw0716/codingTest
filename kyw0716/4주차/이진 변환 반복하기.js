function solution(s) {
  let deleteZeroCount = 0;
  let changeCount = 0;
  while (s !== "1") {
    deleteZeroCount += s.replace(/1/g, "").length;
    s = s.replace(/0/g, "");
    s = s.length.toString(2);
    changeCount++;
  }
  return [changeCount, deleteZeroCount];
}

// 정규표현식은 진짜로 공부해보자
// https://school.programmers.co.kr/learn/courses/30/lessons/70129
