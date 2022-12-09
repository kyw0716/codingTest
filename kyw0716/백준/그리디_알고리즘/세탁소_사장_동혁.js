const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let count = 0;
const inputs = [];

const getAnswer = (money) => {
  const unit = [25, 10, 5, 1];
  const answer = [0, 0, 0, 0];
  let index = 0;
  let count = 0;

  while (money > 0) {
    if (money - unit[index] >= 0) {
      money = money - unit[index];
      answer[index]++;
      continue;
    }
    index++;
  }

  return answer.join(" ");
};

rl.on("line", (input) => {
  count++;
  inputs.push(input);

  if (count === parseInt(inputs[0]) + 1) {
    rl.close();
  }
}).on("close", () => {
  inputs.shift();
  inputs.forEach((input) => {
    console.log(getAnswer(input));
  });
});
