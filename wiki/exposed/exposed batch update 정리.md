# exposed batch update (Not IdTable)

### Not IdTable 내용
- exposed 에서 공식적으로 지원하는게 BatchUpdateStatement 인데. IdTable 만 지원. id 가 아니면 구별할 수 없는 문제인거 같은데. 기존에 Oracle Sequence 사용하는 경우에 해결책을 못찾았음. 즉, PK 로 Sequence 를 사용해야함
- 대안으로 jdbc batch Template 을 찾았음. 하지만 Exposed SpringTransaction 에서 JdbcTemplate, exposed 를 묶어주지 않음

# exposed batch update (IdTable)
- exposed BatchUpdateStatements 를 쓸려면 IdTable 을 상속받아야하는데. IdTable 은 autoIncrement() 를 사용함. 자동으로 ID 를 관리한다는건데. Oracle 은 이 기능이 없음. MySQL 은 있음
- exposed 에서 LongIdTable 로 만들고, batchInsert 를 할 떄, ID 값을 넣어주면 동작을 하네?
- exposed 에서 INSERT 할 때, 자동으로 생성하는 부분이 문제구만

### 해결방안
- exposed IdTable 을 보고 SequenceName 을 입력받도록 추가 구현

```kotlin
open class LongIdTableWithSequence(name: String = "", columnName: String = "id", sequenceName: String = "") :
    IdTable<Long>
        (name) {
    /** The identity column of this [IntIdTable], for storing 4-byte integers wrapped as [EntityID] instances. */
    final override val id: Column<EntityID<Long>> = long(columnName).autoIncrement(sequenceName).entityId()
    final override val primaryKey = PrimaryKey(id)
}

// 사용법
object TestEntity : LongIdTableWithSequence(  xxx ) {

}

```

- [x] spring-batch 에서 위와 같이 사용했을 때, 트랜잭션이 묶이는가?  묶임
- [x] spring-batch 에서 batchInsert 동작하는가? ID 가 자동생성되는가? SEQUENCE 로 -> 정상 동작
- [x] spring-batch 에서 batchUpdate 동작하는가?
    - 동작하는거 같음
    - 10000건 batchUpdate 할 때, 10~20초
    - 10000건 단건 업데이트 할 때, 1분~1분20초
    - BatchUpdate 예시는 https://cheese10yun.github.io/mysql-batch-update/ 참고

