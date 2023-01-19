package sk000801.SQL;

SELECT FIRST_HALF.FLAVOR
FROM FIRST_HALF JOIN ICECREAM_INFO
ON FIRST_HALF.FLAVOR = ICECREAM_INFO.FLAVOR
WHERE TOTAL_ORDER > 3000 AND INGREDIENT_TYPE = 'fruit_based'
ORDER BY TOTAL_ORDER DESC

--외래 키를 참조할 때는 꼭 JOIN을 쓰고
--ON을 사용해 조건을 첨부해줄 것!!!
