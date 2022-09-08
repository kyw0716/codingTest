function solution(n, arr1, arr2) {
  let answer = [];
  arr1.forEach((code, index) => {
    arr1[index] = code.toString(2).padStart(n, 0).split("");
    arr2[index] = arr2[index].toString(2).padStart(n, 0).split("");
  });
  arr1.forEach((code, index) => {
    let concatArray = [...code];
    let result = [];
    for (let i = 0; i < n; i++) {
      if (code[i] !== arr2[index][i]) {
        concatArray[i] = 1;
      }
    }
    answer.push(concatArray.join("").replace(/1/g, "#").replace(/0/g, " "));
  });
  return answer;
}
// 문자를 바꾸는거면 정규표현식 사용한 replace 매서드 사용해보자..
// https://school.programmers.co.kr/learn/courses/30/lessons/17681
