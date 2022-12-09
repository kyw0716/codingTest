const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const getAnswer = (time) => {
  const button = [300, 60, 10];
  let answer = [0, 0, 0];
  let index = 0;

  while (time > 0) {
    if (time - button[index] >= 0) {
      time -= button[index];
      answer[index]++;
      continue;
    }
    index++;
    if (index === 3 && time > 0) return -1;
  }

  return answer.join(" ");
};

rl.on("line", (input) => {
  const time = parseInt(input);
  console.log(getAnswer(time));
});
