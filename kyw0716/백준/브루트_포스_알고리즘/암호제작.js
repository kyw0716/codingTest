const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  const inputs = input.split(" ");
  const primeNumber = [];

  for (let i = 0; i < BigInt(inputs[1]); i++) {
    primeNumber.push(true);
  }

  primeNumber[0] = false;
  primeNumber[1] = false;

  for (let i = 2; i < Math.sqrt(parseInt(inputs[1], 10)); i++) {
    if (primeNumber[i]) {
      let j = 2;

      while (i * j <= parseInt(inputs[1], 10)) {
        primeNumber[i * j] = false;
        j += 1;
      }
    }
  }

  for (let i = 2; i < primeNumber.length; i++) {
    const prime = primeNumber[i];

    if (prime && BigInt(inputs[0]) % BigInt(i) === BigInt(0))
      return console.log(`BAD ${i}`);
  }

  console.log("GOOD");
});
