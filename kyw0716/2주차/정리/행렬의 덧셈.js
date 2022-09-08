function solution(arr1, arr2) {
  let answer = arr1.map((subArray, subArrayIndex) => {
    return subArray.map((value, index) => {
      return value + arr2[subArrayIndex][index];
    });
  });
  return answer;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12950
