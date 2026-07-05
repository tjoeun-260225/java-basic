-- Post.java 에서는
-- 테이블의 명칭을 @Table(name="posts")
-- create table posts 로 지정하여 테이블이름을 세팅
-- Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "POST" not found; SQL statement:
-- 위와 같은 에러가 발생했을 때, entity 에 지정해주는 테이블 이름과
-- data.sql 에서 지정한 테이블이름이 일치하는지 확인
INSERT INTO posts(title, content)
VALUES ('첫 번째 글', '안녕하세요.첫글입니다.');

INSERT INTO posts(title, content)
VALUES ('두 번째 글', '스프링부트 공부중입니다.');