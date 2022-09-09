function solution(a, b) {
  let day = new Date(2016, a - 1, b).toString().slice(0, 3);
  return day.toUpperCase();
}
