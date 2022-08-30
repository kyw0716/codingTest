function solution(left, right) {
  var answer = 0;
  var startNum = left;

  function returnMeasureEvenOrOdd(number) {
    var count = 1;
    var divisionNumber = 1;
    while (divisionNumber <= number) {
      divisionNumber = divisionNumber + 1;
      if (number % divisionNumber === 0) count = count + 1;
    }
    if (count % 2 === 0) {
      return "even";
    }
    return "odd";
  }

  while (startNum <= right) {
    if (returnMeasureEvenOrOdd(startNum) === "even") {
      answer = answer + startNum;
    } else if (returnMeasureEvenOrOdd(startNum) === "odd") {
      answer = answer - startNum;
    }
    startNum = startNum + 1;
  }
  return answer;
}
