// 다리를 건너는 시간 -> 다리 길이
// 다리에 트럭이 올라오는걸 큐로 구현해야될듯.
// 다리를 지난 트럭을 저장하는 배열을(end) 만들고, 그 배열의 길이가 처음 truck_weights의 길이와 같아지면 반복문을 종료하도록 while문을 작성한다.

// 지나는 트럭을 저장하는 배열을(during) 0으로 가득 채운다.(bridge_length 길이 만큼의 크기로 선언)
// 매 반복문이 시작될때 during.shift를 통해 앞 부분을 제거해준다. 이때 만약 제거된 값이 0이 아니라면 end에 해당 값을 push한다.
// if문을 통해 다리에 새로운 트럭이 추가될 수 있다면 해당 트럭의 무게를 during에 push하고, 아니면 0을 push 한다.
// 매 반복문 마지막단에 time++를 해주어 시간을 측정한다.
// end배열과 truck_weights배열의 초기 크기가 서로 같아질때 while문이 종료되고 time을 리턴한다.

function sum(arr) {
  return arr.reduce((sum, curr) => sum + curr, 0);
}

function solution(bridge_length, weight, truck_weights) {
  let during = Array(bridge_length).fill(0);
  let end = [];
  let truckCount = truck_weights.length;
  let time = 0;
  while (end.length !== truckCount) {
    if (during.at(0) !== 0) end.push(during.at(0));
    during.shift();
    // 다음 차량이 들어올 수 있을 때
    if (sum(during) + truck_weights.at(0) <= weight) {
      during.push(truck_weights.shift());
    }
    // 다음 차량이 들어오지 못할 때
    else if (sum(during) + truck_weights.at(0) > weight) {
      during.push(0);
    }
    time++;
  }
  return time;
}
