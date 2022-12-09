const readline = require("readline");
const r1 = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

r1.on("line", (input) => {
  const inputs = input.split(" ").map((v) => v.split(""));
  const min = [];
  const max = [];

  inputs.forEach((input) => {
    let minValue = "";
    for (let i = 0; i < input.length; i++) {
      if (input[i] === "6") {
        minValue += "5";
        continue;
      }
      minValue += input[i];
    }
    min.push(parseInt(minValue));
  });

  inputs.forEach((input) => {
    let maxValue = "";
    for (let i = 0; i < input.length; i++) {
      if (input[i] === "5") {
        maxValue += "6";
        continue;
      }
      maxValue += input[i];
    }
    max.push(parseInt(maxValue));
  });

  console.log([`${min[0] + min[1]}`, `${max[0] + max[1]}`].join(" "));
});
