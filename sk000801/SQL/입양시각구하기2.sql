WITH RECURSIVE num(HOUR) AS (
    SELECT 0
    UNION ALL 
    SELECT HOUR+1 FROM num WHERE HOUR<23
)

SELECT A.HOUR, 
    CASE WHEN B.CNT IS NULL THEN 0 
    ELSE B.CNT END AS COUNT 
FROM num A
LEFT JOIN (SELECT HOUR(DATETIME) AS H, COUNT(ANIMAL_ID) AS CNT
            FROM ANIMAL_OUTS 
           GROUP BY 1) AS B ON A.HOUR = B.H

--정리 필수,,,