# jdbc readonly 관련 이슈



### 참고

- https://tech.inflab.com/20240901-jdbc-set-readonly-issue/



### 내용

- 비즈니스 로직이 아닌 쿼리가 발생
- 자세히는 안봤는데 느낌이 failover 로직이 수행되는 도중에 setReadOnly 호출할 때, 뭔가 충돌나는거 같음
