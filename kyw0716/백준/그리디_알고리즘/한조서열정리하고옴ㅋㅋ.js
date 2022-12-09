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
  const rounds = inputs[0];
  const mountains = inputs[1].split(" ").map((v) => parseInt(v));
  let max = 0;

  for (let i = 0; i < rounds; i++) {
    const currentMountain = mountains[i];
    let count = 0;
    let index = i + 1;

    while (currentMountain > mountains[index]) {
      count++;
      index++;
    }

    if (max < count) max = count;
  }

  console.log(max);
});
