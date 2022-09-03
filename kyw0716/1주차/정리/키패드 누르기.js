function solution(numbers, hand) {
  let position = [
    [1, 0],
    [0, 3],
    [1, 3],
    [2, 3],
    [0, 2],
    [1, 2],
    [2, 2],
    [0, 1],
    [1, 1],
    [2, 1],
    [0, 0],
    [2, 0],
  ];
  let currentLeft = 10,
    currentRight = 11;
  numbers.map((number, index) => {
    if (number === 1 || number === 4 || number === 7) {
      numbers[index] = "L";
      currentLeft = number;
    } else if (number === 3 || number === 6 || number === 9) {
      numbers[index] = "R";
      currentRight = number;
    } else {
      let leftDistance = 0,
        rightDistance = 0;
      position[number].map((coordinate, index) => {
        leftDistance += Math.abs(coordinate - position[currentLeft][index]);
        rightDistance += Math.abs(coordinate - position[currentRight][index]);
      });
      if (leftDistance > rightDistance) {
        numbers[index] = "R";
        currentRight = number;
      } else if (leftDistance < rightDistance) {
        numbers[index] = "L";
        currentLeft = number;
      } else {
        if (hand === "right") {
          numbers[index] = "R";
          currentRight = number;
        } else {
          numbers[index] = "L";
          currentLeft = number;
        }
      }
    }
  });

  return numbers.join("");
}

// 어떤 요소 간의 거리를 구할 때는 좌표 배열을 만들어서 해보자.
// https://school.programmers.co.kr/learn/courses/30/lessons/67256
