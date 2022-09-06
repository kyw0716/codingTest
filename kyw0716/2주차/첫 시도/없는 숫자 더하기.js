function solution(numbers) {
  const allNumber = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
  var answer = 0;
  allNumber.map((number) => {
    if (numbers.includes(number)) return;
    answer += number;
  });
  return answer;
}
