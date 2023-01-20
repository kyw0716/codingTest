SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(TLNO, 'NONE') as TLNO FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC

-- ifnull()함수로 만약 항목이 null일 때 다른 값 넣어주기
-- as를 통해 column의 이름 재지정해주기!