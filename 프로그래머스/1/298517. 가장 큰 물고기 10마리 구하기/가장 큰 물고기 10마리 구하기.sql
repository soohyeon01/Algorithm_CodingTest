-- 테이블에서 가장 큰 물고기 10마리의 ID와 길이 출력
-- 길이를 기준으로 내림차순, 길이가 같다면 ID에 대하여 오름차순

SELECT ID, LENGTH FROM FISH_INFO
ORDER BY LENGTH DESC, ID ASC
LIMIT 10;