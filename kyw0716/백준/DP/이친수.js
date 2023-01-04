const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  const order = parseInt(input, 10);
  const pinary = [];

  for (let i = 0; i < order; i++) {
    if (i === 0) {
      pinary[i] = BigInt(1);
      continue;
    }
    if (i === 1) {
      pinary[i] = BigInt(1);
      continue;
    }
    pinary[i] = pinary[i - 1] + pinary[i - 2];
  }

  console.log(String(pinary[order - 1]));
});
