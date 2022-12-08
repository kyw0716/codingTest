const readline = require("readline");
const r1 = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const getCombinations = (array, selectNumber) => {
  const results = [];
  if (selectNumber === 1) {
    return array.map((element) => [element]);
  }
  array.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = getCombinations(rest, selectNumber - 1);
    const attached = combinations.map((combination) => [fixed, ...combination]);
    results.push(...attached);
  });
  return results;
};

const getLCM = (a, b) => {
  const divider = [];
  const min = Math.min(a, b);

  for (let i = 1; i <= min; i++) {
    if (a % i === 0 && b % i === 0) divider.push(i);
  }

  const max = Math.max(...divider);

  return (a * b) / max;
};

r1.on("line", (input) => {
  const inputNumbers = input.split(" ");
  const combination = getCombinations(inputNumbers, 3);
  const multiple = [];

  for (let i = 0; i < combination.length; i++) {
    let LCM = getLCM(combination[i][0], combination[i][1]);
    LCM = getLCM(combination[i][2], LCM);

    multiple.push(LCM);
  }

  console.log(Math.min(...multiple));
});
