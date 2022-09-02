function solution(new_id) {
  new_id = new_id.toLowerCase();
  new_id = new_id
    .replace(
      /\~|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\=|\+|\[|\{|\]|\}|\:|\?|\,|\<|\>|\//g,
      ""
    )
    .replace(/\.+/g, ".")
    .replace(/^\.|$\./, "");
  if (new_id.length >= 16) new_id = new_id.slice(0, 15);
  new_id = new_id.replace(/\.$/, "");
  if (new_id.length === 0) new_id = "a";
  if (new_id.length <= 2) new_id = new_id.padEnd(3, new_id[new_id.length - 1]);

  return new_id;
}
//문자열 처리하는 문제는 정규 표현식 사용하는 방식 먼저 생각해볼것!
//https://school.programmers.co.kr/learn/courses/30/lessons/72410
