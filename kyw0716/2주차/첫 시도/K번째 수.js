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
