// 전체적인 로직
// 일단 하나 꺼내고
// 만약 꺼낸 애보다 중요도 높은 애가 있으면 다시 뒤로 집어넣고
// 꺼낸 애가 중요도 제일 높은 애면 다시 집어넣지 않고 printCount 변수에 1 더해준다.
// 만약 꺼낸 애가 처음 location에 있었던 애면 break해주고 printCount를 리턴한다.

// location 추적 로직
// 만약 push가 일어나면 location--를 해준다.(앞으로 한칸씩 땡겨지니까)
// 이때 location이 push된거라면 location = priorities.length - 1을 해준다.
// push되지 않고 출력이 된거라면 location--를 해준다.(앞으로 한칸씩 땡겨지니까)

function solution(priorities, location) {
  let printCount = 0;

  while (priorities.length > 0) {
    let J = priorities.shift();

    if (priorities.filter((p) => p > J).length > 0) {
      priorities.push(J);
      if (location === 0) location = priorities.length - 1;
      else location--;
    } else {
      printCount++;
      if (location === 0) break;
      location--;
    }
  }
  return printCount;
}

// 바로 풀 수 있는 문제가 아니라면 로직을 머릿속으로만 생각하지말고 주석으로 적어보고 코딩 시작하자.
// https://school.programmers.co.kr/learn/courses/30/lessons/42587
