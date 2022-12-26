const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inputs = [];
let count = 0;

rl.on("line", (input) => {
  inputs.push(input);
  count += 1;

  if (count === parseInt(inputs[0].split(" ")[0], 10) + 1) rl.close();
}).on("close", () => {
  const totalTime = parseInt(inputs.shift().split(" ")[1], 10);
  const cycle = inputs.map(Number);
  let firework = new Array(totalTime).fill(false);

  firework = firework
    .map((v, i) => {
      for (let j = 0; j < cycle.length; j++) {
        if ((i + 1) % cycle[j] === 0) return true;
      }

      return false;
    })
    .filter((v) => v);

  console.log(firework.length);
});
