-- 코드를 입력하세요
-- 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

-- 중성화 되어있지 않은 동물
WITH NOT_NEUTRAL AS(
    SELECT *
    FROM ANIMAL_INS
    WHERE SEX_UPON_INTAKE LIKE "Intact%"
) 


SELECT DISTINCT NN.ANIMAL_ID, NN.ANIMAL_TYPE, NN.NAME
FROM ANIMAL_OUTS AS AO INNER JOIN NOT_NEUTRAL AS NN ON NN.ANIMAL_ID = AO.ANIMAL_ID
WHERE AO.SEX_UPON_OUTCOME LIKE "Spayed%" OR AO.SEX_UPON_OUTCOME LIKE "Neutered%"
# ORDER BY NN.NAME