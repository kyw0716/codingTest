function solution(array, commands) {
  let answer = [];

  commands.forEach((command) => {
    let subArray = array
      .slice(command[0] - 1, command[1])
      .sort((a, b) => a - b);
    answer.push(subArray.at(command[2] - 1));
  });
  return answer;
}

// slice, sort, push 같은 배열 관련 메소드 잘 숙지해두자.
// https://school.programmers.co.kr/learn/courses/30/lessons/42748
