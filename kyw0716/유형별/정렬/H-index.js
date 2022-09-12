// citations.length => 논문 개수(n)
// h변수가 있어야할듯
// h변수를 0부터 n까지 반복문 돌리고 그 반복문 속에서 citations.filter를 해준다.

function solution(citations) {
  let h = 0;
  for (let i = Math.floor(citations.length / 2); i <= citations.length; i++) {
    let overH = citations.filter((citation) => citation >= i).length;
    if (overH >= i) h = i;
  }
  return h;
}

// 정확도 실패하면 예외의 경우 잘 생각해보기
// https://school.programmers.co.kr/learn/courses/30/lessons/42747
