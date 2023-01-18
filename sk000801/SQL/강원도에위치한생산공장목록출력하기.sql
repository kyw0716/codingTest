package sk000801.SQL;

SELECT FACTORY_ID, FACTORY_NAME, ADDRESS FROM FOOD_FACTORY WHERE ADDRESS LIKE CONCAT('%','강원도','%') ORDER BY FACTORY_ID;

# 오 신기해 문자열이 포함돼 있는지 확인하려면 LIKE CONCAT('%','원하는 거', '%')
# %는 앞뒤로 뭐가 들어와도 상관없다는 말