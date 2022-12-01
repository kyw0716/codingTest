function solution(food) {
  let answer = "";
  let foodString = [];

  for (let i = 1; i < food.length; i++) {
    for (let j = 0; j < Math.floor(food[i] / 2); j++) {
      foodString.push(i);
    }
  }

  answer += foodString.join("");
  answer += "0";
  answer += foodString.reverse().join("");

  return answer;
}

//https://school.programmers.co.kr/learn/courses/30/lessons/134240
