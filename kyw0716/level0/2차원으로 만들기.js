function solution(num_list, n) {
  const answer = [];
  let tempArray = [];

  for (let i = 0; i < num_list.length; i++) {
    if (tempArray.length === n) {
      answer.push(tempArray);
      tempArray = [];
    }
    tempArray.push(num_list[i]);
  }

  answer.push(tempArray);

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120842
