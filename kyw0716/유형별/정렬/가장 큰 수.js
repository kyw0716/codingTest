// 앞자리의 수가 큰 순서대로 정렬한다.
// 앞자리가 같은 수들끼리 큰 숫자를 만들 수 있는 순으로 정렬한다.
// 3, 30의 경우에는 30이 더 크지만 30의 두번째 숫자가 3보다 작으므로 3이 더 큰 수로 정렬되게 한다.

function solution(numbers) {
  numbers
    .sort(
      (a, b) => Number(String(b).split("")[0]) - Number(String(a).split("")[0])
    )
    .sort((a, b) => Number(`${b}${a}`) - Number(`${a}${b}`));

  return numbers.filter((value) => value !== 0).length > 0
    ? numbers.join("")
    : "0";
}
