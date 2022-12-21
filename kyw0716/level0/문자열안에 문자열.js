function solution(str1, str2) {
  for (let i = 0; i < str1.length; i++) {
    if (str1[i] === str2[0]) {
      for (let j = 0; j < str2.length; j++) {
        if (str1[i + j] !== str2[j]) {
          i += j;
          break;
        }
        if (j === str2.length - 1) return 1;
      }
    }
  }
  return 2;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120908
