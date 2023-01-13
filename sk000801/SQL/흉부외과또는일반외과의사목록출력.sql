-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD,'%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR 
WHERE MCDP_CD='CS' OR MCDP_CD='GS' 
ORDER BY HIRE_YMD DESC, DR_NAME ASC

--  DATE_FORMAT(HIRE_YMD,'%Y-%m-%d')
-- 어떤 특정 항목을 기준으로 값을 뽑아낼 때 wHERE 여러개면 OR
-- 그러나 둘 다 해당되는 경우여야 하면 AND
-- DESC 는 내림차순(큰순으로), ASC는 오름차순
-- 앞에 적은 것을 우선으로, 뒤에게 앞의 것이 같다면 차선으로 적용!
-- DATE_FORMAT으로 원하는 날짜의 정보만 추출할 수 있고 AS로 그 이름을 다시 설정해줘야함


