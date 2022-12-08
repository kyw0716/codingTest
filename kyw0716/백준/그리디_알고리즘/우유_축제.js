const readline = require("readline");
const r1 = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let cnt = 0;
const inputs = [];

r1.on("line", (input) => {
  inputs.push(input);
  cnt++;

  if (cnt === 2) {
    r1.close();
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
