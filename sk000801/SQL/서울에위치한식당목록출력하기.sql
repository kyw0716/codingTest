# SELECT REST_INFO.REST_ID, REST_INFO.REST_NAME, REST_INFO.FOOD_TYPE, REST_INFO.FAVORITES, REST_INFO.ADDRESS, ROUND(avg(REST_REVIEW.REVIEW_SCORE), 2) AS SCORE
# FROM REST_INFO JOIN REST_REVIEW 
# ON REST_INFO.REST_ID = REST_REVIEW.REST_ID
# GROUP BY REST_INFO.REST_ID
# WHERE REST_INFO.ADDRESS LIKE CONCAT('서울', '%')
# ORDER BY SCORE DESC, REST_INFO.FAVORITES DESC

SELECT A.REST_ID, B.REST_NAME, B.FOOD_TYPE, B.FAVORITES, B.ADDRESS, ROUND(AVG(A.REVIEW_SCORE),2) AS SCORE
FROM REST_REVIEW A
JOIN REST_INFO B ON A.REST_ID = B.REST_ID
GROUP BY A.REST_ID
HAVING B.ADDRESS LIKE '서울%'
ORDER BY SCORE DESC, B.FAVORITES DESC