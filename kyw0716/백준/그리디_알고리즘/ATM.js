const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inputs = [];
let count = 0;

rl.on("line", (input) => {
  inputs.push(input);
  count++;

  if (count === 2) rl.close();
}).on("close", () => {
  const sums = [];
  let waitTimes = inputs[1].split(" ").map((v) => parseInt(v, 10));
  waitTimes.sort((a, b) => a - b);

  waitTimes.reduce((acc, curr) => {
    const noojuck = (acc += curr);
    sums.push(noojuck);
    return noojuck;
  }, 0);

  console.log(sums.reduce((acc, curr) => (acc += curr), 0));
});
