SELECT NAME FROM ANIMAL_INS
WHERE DATETIME = (SELECT MIN(DATETIME) FROM ANIMAL_INS)

--MIN(DATETIME) 이면 가장 이른 날짜?