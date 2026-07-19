-- resources/schema.sql
-- sql 을 생성하는 명칭  =  schema
-- sql 은 대소문자 구분 대신에 _ 언더스코어를 사용하여
-- 명칭 구분 user_id 와 같은 형식으로 많이 사용
DROP TABLE IF EXISTS member;

CREATE TABLE member (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(200) NOT NULL
)