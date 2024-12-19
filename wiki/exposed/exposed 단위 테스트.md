# exposed 단위 테스트
- kotlin exposed test 코드 작성
- sequence 만들 때, oracle, mysql, h2 sequence 생성, 사용이 다름. h2 mode 를 통해 세팅
- 순서는 아래와 같다.
  - Database.connect 연결
  - Transaction block
    - SchemaUtils 통해 Entity 생성
    - CUD 실행
    - 검증
  - SchemaUtils 통해 스키마 삭제

```kotlin
Database.connect(
"jdbc:h2:mem:test;Mode=Oracle;DB_CLOSE_DELAY=-1;",
driver = "org.h2.Driver"
)

transaction {
SchemaUtils.create(xxxEntity)

    xxxrepo.insert(xxx)

    SchemaUtils.drop(xxxEntity)
}




transaction {
SchemaUtils.createSequence(
Sequence("SEQ", 1, 1, 1, 1)
)

xxxNextVal
}

```
