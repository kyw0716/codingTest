const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let cnt = 0;
const inputs = [];

rl.on("line", (input) => {
  inputs.push(input);
  cnt++;

  if (cnt === 2) {
    rl.close();
  }
}).on("close", () => {
  const milks = [0, 1, 2];
  const rap = parseInt(inputs[0]);
  const markets = inputs[1].split(" ").map((v) => parseInt(v));
  let index = 0;
  let answer = 0;

  for (let i = 0; i < rap; i++) {
    if (markets[i] === milks[index]) {
      index = (index + 1) % 3;
      answer++;
      continue;
    }
  }

  console.log(answer);
});
