# exposed batch update (Not IdTable)

### Not IdTable 내용
- exposed 에서 공식적으로 지원하는게 BatchUpdateStatement 인데. IdTable 만 지원. id 가 아니면 구별할 수 없는 문제인거 같은데. 기존에 Oracle Sequence 사용하는 경우에 해결책을 못찾았음. 즉, PK 로 Sequence 를 사용해야함
- 대안으로 jdbc batch Template 을 찾았음. 하지만 Exposed SpringTransaction 에서 JdbcTemplate, exposed 를 묶어주지 않음

